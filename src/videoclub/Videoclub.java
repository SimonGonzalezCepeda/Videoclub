/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.*;

/**
 *
 * @author Simón i Pau
 */
public class Videoclub implements Serializable {

    private static final String rutaUsr = "BD/usuaris.bin";
    private static final String rutaPel = "BD/pelicules.bin";
    private static final String rutaSer = "BD/series.bin";
    public Usuari usuari;
    public Lloguer lloguer;
    public static ArrayList<Usuari> usuarios = new ArrayList<>();
    public static ArrayList<Pelicula> peliculas = new ArrayList<>();
    public static ArrayList<Serie> series = new ArrayList<>();

    /*
     *   Constructor
     */
    public Videoclub() {
        usuari = new Usuari();
        lloguer = new Lloguer();
    }

    /*
     *   Funcuions.
     */
    
    /*
     *   Métode per a cercar les pelicules en ordre alfabètic.
     *   
     *   @args: int;
     *   @return: ArrayList <String> Aquest no més son Strings, no els objectes.
     *   OCO!
     */
    static public ArrayList<String> buscarPelicules(ArrayList<Pelicula> pelicula){
        
        Pelicula peli = new Pelicula();
        ArrayList<String> listaOrd = new ArrayList<>();
        
         for(int i = 0; i<=pelicula.size()-1; i++){
            peli = pelicula.get(i);
            listaOrd.add(peli.getNom());
        }
   
        Collections.sort(listaOrd);

        return listaOrd;

    }
    
    /*
     *   Métode per a cercar les series en ordre alfabètic.
     *   
     *   @args: int;
     *   @return: ArrayList <String> Aquest no més son Strings, no els objectes.
     *   OCO!
     */
    static public ArrayList<String> buscarSeries(ArrayList<Serie> series){
        
        Serie serie = new Serie();
        ArrayList<String> listaOrd = new ArrayList<>();
        
         for(int i = 0; i<=series.size()-1; i++){
             serie = series.get(i);
            listaOrd.add(serie.getNom());
        }
   
        Collections.sort(listaOrd);

        return listaOrd;

    }

    /*
     *   Mètode per a que els usuaris es puguin conectar.
     *
     */
    public void loguejar() {

    }

    /*
     *   Mètode amb el que es carrega tota l'informació en variables.
     *
     */
    static public void carregarBD(ArrayList<Usuari> usuaris, ArrayList<Pelicula> pelicules, ArrayList<Serie> series) throws IOException {
        ObjectInputStream master;
        int i = 0;

        //Llegim fitxer per a Pelicula
        master = new ObjectInputStream(new FileInputStream(rutaPel));
        Pelicula peli;

        while (true) {
            try {
                peli = (Pelicula) master.readObject();
                pelicules.add(peli);
            } catch (FileNotFoundException e) {
                System.out.println("\nEl fichero no existe o esta vacio!\n");
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("\nNo se ha encontrdo la clase readObject!\n");
                break;
            } catch (EOFException e) {
                System.out.println("\nSe ha leído el fichero pelicules.txt\n");
                break;
            }
        }//endwhile

        //Llegim fitxer per a Serie
        master = new ObjectInputStream(new FileInputStream(rutaSer));
        Serie serie;
        while (true) {
            try {
                serie = (Serie) master.readObject();
                series.add(serie);
            } catch (FileNotFoundException e) {
                System.out.println("\nEl fichero no existe o esta vacio!\n");
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("\nNo se ha encontrdo la clase readObject!\n");
                break;
            } catch (EOFException e) {
                System.out.println("\nSe ha leído el fichero series.txt\n");
                break;
            }
        }//endwhile

        //Llegim fitxer per a Usuari
        master = new ObjectInputStream(new FileInputStream(rutaUsr));
        Usuari user;
        while (true) {
            try {
                user = (Usuari) master.readObject();
                usuaris.add(user);
            } catch (FileNotFoundException e) {
                System.out.println("\nEl fichero no existe o esta vacio!\n");
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("\nNo se ha encontrdo la clase readObject!\n");
                break;
            } catch (EOFException e) {
                System.out.println("\nSe ha leído el fichero usuaris.txt\n");
                break;
            }
        }//endwhile

    }


    /*
     *   Mètode amb el que es desa tota l'informació en variables.
     *
     */
    static public void desarBD(ArrayList<Usuari> usuaris, ArrayList<Pelicula> pelicules, ArrayList<Serie> series) throws IOException {
        ObjectOutputStream master;
        int i;

        //Creem fitxer per a Usuaris
        master = new ObjectOutputStream(new FileOutputStream(rutaUsr));
        for (i = 0; i <= usuaris.size() - 1; i++) {
            try {
                master.writeObject(usuaris.get(i));
            } catch (IOException e) {
                System.out.println("Error!");
                break;
            }//endtry
        }//endfor

        //Creem fitxer per a Pelicules
        master = new ObjectOutputStream(new FileOutputStream(rutaPel));
        for (i = 0; i <= pelicules.size() - 1; i++) {
            try {
                master.writeObject(pelicules.get(i));
            } catch (IOException e) {
                System.out.println("Error!");
                break;
            }//endtry
        }//endfor

        // Creem fitxer per a Series
        master = new ObjectOutputStream(new FileOutputStream(rutaSer));
        for (i = 0; i <= series.size() - 1; i++) {
            try {
                master.writeObject(series.get(i));
            } catch (IOException e) {
                System.out.println("Error!");
                break;
            }//endtry
        }//endfor

    }

    /*
     *   Mètode amb el que filtrem els continguts de les búsquedes.
     *
     */
    public void filtrarContingut() {
        
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here

        carregarBD(usuarios, peliculas, series);
        
        Pelicula peli;
        Serie serie;
    
        for (int i = 0; i < 20; i++) {
            peli = peliculas.get(i);
            System.out.println(peli.getNom());
            System.out.println(peli.getCategoria() + " " + i);
            
            if (i < 13) {
                serie = series.get(i);
                System.out.println(serie.getNom());
                System.out.println(serie.getCategoria() + " " + i + " serie");
            }
        }
        
        /*
         *  Aquest for de davant el vam fer servir per a plenar els objectes que vam crear manualment en el codi.
         *  Es necesita una array de series amb objectes per a que funcioni. Per a veure el codi complert ho podeu
         *  trobar en GitHub en el següent commit.
         *  https://github.com/SimonGonzalezCepeda/Videoclub/tree/9d5445bd9b329f60bd7b10c8a9bf510a086caadd
         */
        
//        int i, j;
//
//        for (j = 0; j < series.size(); j++) {
//            
//            Serie serie = series.get(j);
//            
//            
//            for (i = 1; i <= serie.getTotalTemporades(); i++) {
//
//                Temporada tempora = new Temporada();
//                tempora.setNumeroTemporada(i);
//                tempora.setNom("Temporada " + i);
//                if (i == serie.getTotalTemporades()) { // Aixó si es l'última
//                    System.out.println("\nLa " + tempora.getNom() + " de " + serie.getNom() + " está en emisión? (true o false)\n");
//                    String string;                          // Creem una String per a desar si sí (true) o si no (false)
//                    Scanner e = new Scanner(System.in);     // Amb això llegim la inserció del teclat
//                    string = e.nextLine();                  // Ho dessem.
//                    boolean si = Boolean.valueOf(string);   // Creem una boolea que desa la paraula que hem escrit com a valor boolean.
//                    tempora.setEmissio(si);                 // Dessem l'estat de l'última temporada.
//                    if (si) { // Aixó si está en emissio
//                        serie.afegirTemporada(tempora);     // Adegim Temporada a la Serie
//                    } else { // Aixó si está acabada
//                        System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + serie.getNom() + ": \n");
//                        string = e.nextLine();
//                        int y = Integer.parseInt(string);
//                        tempora.setTotalCapitols(y);
//                        serie.afegirTemporada(tempora);  // Afegim Temporada a la Serie
//                    }//endif
//                } else { // Aixó si está acabada
//                    tempora.setEmissio(false);
//                    System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + serie.getNom() + ": \n");
//                    String string;
//                    Scanner e = new Scanner(System.in);
//                    string = e.nextLine();
//                    int y = Integer.parseInt(string);
//                    tempora.setTotalCapitols(y);
//                    serie.afegirTemporada(tempora);  // Afegim Temporada a la Serie
//                } //endif  
//
//            } //end2nfor
//        } //end1rfor

    } //endmain
    

} //endclass
