/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;
import gui.Login;

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
import javax.swing.*;

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
    public static final ArrayList<Usuari> usuarios = new ArrayList<>();
    public static final ArrayList<Pelicula> peliculas = new ArrayList<>();
    public static final ArrayList<Serie> series = new ArrayList<>();


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
    
    static public ArrayList<String> buscarPeliculas(ArrayList<Pelicula> pelicula) {

        Pelicula peli = new Pelicula();
        ArrayList<String> listaOrd = new ArrayList<>();

        for (int i = 0; i <= pelicula.size() - 1; i++) {
            peli = pelicula.get(i);
            listaOrd.add(peli.getNom());
        }

        Collections.sort(listaOrd);

        return listaOrd;

    }//end buscarPelicules

    /*
     *   Métode per a cercar les series en ordre alfabètic.
     *   
     *   @args: int;
     *   @return: ArrayList <String> Aquest no més son Strings, no els objectes.
     *   OCO!
     */
    
    static public ArrayList<String> buscarSeries(ArrayList<Serie> serios) {

        Serie serie = new Serie();
        ArrayList<String> listaOrd = new ArrayList<>();

        for (int i = 0; i <= serios.size() - 1; i++) {
            serie = serios.get(i);
            listaOrd.add(serie.getNom());
        }

        Collections.sort(listaOrd);

        return listaOrd;

    }//end buscarSeries

    /*
     *   Mètode amb el que es carrega tota l'informació en variables.
     *
     *   @args: ArrayList<Usuari>, ArrayList<Pelicula>, ArrayList<Serie>;
     *   @return: void: Carrega l'informació a les variables cridades. Feu servir les globals sempre!
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

    }//end carregarBD


    /*
     *   Mètode amb el que es desa tota l'informació en variables.
     *
     *   @args: ArrayList<Usuari>,  ArrayList<Pelicula>, ArrayList<Serie>;
     *   @return: void: Desa les arrays en els fitxers. Feu servir les globals sempre!
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
    }//end desarBD

    /*
     *  Es filtren els objectes de Series o Pelicules dels arrays globals per la categoria demanada
     *  i es retorna a un Array de strings ordenat alfabèticament. Es fa servir la funció buscar*();
     *  
     *   @args: String, String;
     *   @return: ArrayList<String>; NO OBJECTS!
     *
     */
    static public ArrayList<String> filtrarContingut(String clase, String categoria) {

        String peli;
        String serie;
        int i;
        ArrayList<String> pels = new ArrayList<>();
        ArrayList<String> sers;
        ArrayList<String> lista = new ArrayList<>();

        if ("Pelicula".equals(clase)) {
            Pelicula objectPel;
            ArrayList<Pelicula> pelicules = new ArrayList<>();
            for (i = 0; i < peliculas.size(); i++) {
                objectPel = peliculas.get(i);
                if(categoria.equals(objectPel.getCategoria())){
                    pelicules.add(objectPel);
                }    
            }
            lista = buscarPeliculas(pelicules);
            return lista;
        } else if ("Serie".equals(clase)) {
            Serie objectSerie;
            ArrayList<Serie> serios = new ArrayList<>();
            for (i = 0; i < series.size(); i++) {
                objectSerie = series.get(i);
                if(categoria.equals(objectSerie.getCategoria())){
                    serios.add(objectSerie);
                }    
            }
            lista = buscarSeries(serios);
            return lista;
        } else {
            System.out.println("Error al trobar la categoria.");
            return lista;
        }
    }//end filtrarContingut

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO code application logic here
        
        carregarBD(usuarios, peliculas, series);
        
        Login login = new Login();
        
        login.setVisible(true);
        
//        Pelicula peli;
//        Serie serie;
//        int i;
//
//        for ( i = 0; i < 20; i++) {
//            peli = peliculas.get(i);
//            System.out.println(peli.getCategoria() + " " + i);
//
//            if (i < 13) {
//                serie = series.get(i);
//                System.out.println(serie.getCategoria() + " " + i + " serie");
//            }
//        }
//        
//        ArrayList<String> listadoSer = new ArrayList<>();
//        ArrayList<String> listadoPel;
//        
//        listadoPel = buscarPeliculas(peliculas);
//        
//        String text = new String();
//        
//        for (i=0; i < listadoPel.size();i++){
//            text= listadoPel.get(i);
//            System.out.println(text);
//        }
//
//        
//        listadoPel = filtrarContingut("Pelicula","Acción");
//        
//        for ( i=0; i < listadoPel.size(); i++){
//            text = listadoPel.get(i);
//            System.out.println(text);
//        }
        
        
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
