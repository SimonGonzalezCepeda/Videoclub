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

    public static String rutaUsr = "BD/usuaris.bin";
    public static String rutaPel = "BD/pelicules.bin";
    public static String rutaSer = "BD/series.bin";
    public Usuari usuari;
    public Lloguer lloguer;
    
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
     *   Métode per a cercar els continguts de l'aplicació.
     *
     *   @args: int;
     *   @return: ArrayList <String>;
     */
    public ArrayList<String> buscarLloguer() {

        ArrayList<String> lista = new ArrayList<>(); //carregarBD();

        Collections.sort(lista);

        return lista;

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
        int i=0;

        //Llegim fitxer per a Pelicula
        
        master = new ObjectInputStream(new FileInputStream(rutaPel));
        Pelicula peli;
        
        while (true) {
            try {
                peli = (Pelicula) master.readObject();
                pelicules.add(peli);
                System.out.println("chivato");
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
                //System.out.println("\nSe ha leído el fichero usuaris.txt\n");
                break;
            }
        }//endwhile
        
    }


    /*
     *   Mètode amb el que es desa tota l'informació en variables.
     *
     */


    
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
        for (i = 0; i < series.size() - 1; i++) {
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

        

        /*
         *   Objectes de Pel.licules
         */
        
        Pelicula dragonBallZBattleOfGods = new Pelicula();
        
        dragonBallZBattleOfGods.setNom("Dragon Ball Z: Battle of Gods");
        dragonBallZBattleOfGods.setSinopsis("Algunos años después de la batalla con Majin Buu, Bils, el dios de la destrucción,"
                + " encargado de mantener el equilibrio del universo, se ha despertado de un largo sueño. Al escuchar rumores sobre"
                + " un saiyajin que ha vencido a Freezer, Bils parte a la búsqueda de Goku. Emocionado por el hecho de que haya aparecido,"
                + " después de tanto tiempo, un oponente tan poderoso, Goku ignora las advertencias de Kaito y decide enfrentarse a él.");
        dragonBallZBattleOfGods.setProductora("Toei Animation");
        dragonBallZBattleOfGods.setCategoria("Aventura");
        dragonBallZBattleOfGods.setDisponible(true);
        dragonBallZBattleOfGods.setAny(2013);

        Pelicula onePieceBattleOfZ = new Pelicula();

        onePieceBattleOfZ.setNom("One Piece: Battle of Z");
        onePieceBattleOfZ.setProductora("Toei");
        onePieceBattleOfZ.setCategoria("Aventura");
        onePieceBattleOfZ.setDisponible(true);
        onePieceBattleOfZ.setSinopsis("Se dice que su poder es comparable al de las Armas Ancestrales, la \"carta de triunfo\" de la Marine,"
                + " \"La Piedra Dyna\", fue robada. El responsable es el temido y terriblemente poderoso, ex-Almirante de la Marine,"
                + " un hombre llamado \"Z\", quien se cruza en el camino de los Piratas del Sombrero de Paja.\n El Cuartel General de la "
                + "Marine se mueve hacia adelante para hacer frente a esta conspiración, que es capaz de hacer temblar los pilares"
                + " del Nuevo Mundo. Por otra parte el ex-almirante Aokiji, persigue a los Sombreros de Paja por el Nuevo Mundo,"
                + " mientras estos deciden enfrentar a Z y a su tripulación con su increíble poder.");
        onePieceBattleOfZ.setAny(2012);

        /*
         *   ArrayList de Pelicula
         */
        
        ArrayList<Pelicula> pelicules = new ArrayList<>();
        pelicules.add(dragonBallZBattleOfGods);
        pelicules.add(onePieceBattleOfZ);
        
        ArrayList<Pelicula> peliculas = new ArrayList<>();
   

        /*
         *   Objectes de Serie
         */
        
        Serie shingekiNoKyojin = new Serie();
        Serie boBoBo = new Serie();

        shingekiNoKyojin.setNom("Shingeki no Kyojin");
        shingekiNoKyojin.setCategoria("Acción");
        shingekiNoKyojin.setDisponible(true);
        shingekiNoKyojin.setProductora("Studio	Wit Studio, Production I.G");
        shingekiNoKyojin.setAny(2013);
        shingekiNoKyojin.setSinopsis("La historia se desarrolla en un pasado ficticio ligeramente basado en la Edad Media, "
                + "en el que la humanidad fue casi exterminada con la repentina aparición de los Titanes "
                + "(criaturas de enorme tamaño con aparentemente poca inteligencia). La humanidad fue devorada sin contemplación, "
                + "no obstante, un grupo reducido de personas pudo sobrevivir dentro de una enorme área de terreno amurallada, "
                + "protegida por muros de 50 metros de altura, el triple de los gigantes más altos registrados hasta la fecha "
                + "de su construcción.\n 107 años después, la humanidad vive pacíficamente dentro de las murallas y no ha sido testigo de "
                + "ataques por parte de los Titanes durante todo ese tiempo. Hasta que un día el joven Eren Jaeger, su hermana adoptiva "
                + "Mikasa Ackerman y su amigo Armin Arlerlt, presencian cómo un Titán tan alto como la propia muralla hace repentinamente"
                + " su aparición, haciendo una abertura en una de las murallas exteriores de la ciudad,  "
                + "permitiendo la entrada de un gran grupo de Titanes de menor tamaño. Ambos jóvenes ven con horror cómo su madre es "
                + "devorada viva por uno de ellos. Tras haber sobrevivido al ataque, Eren jura eliminar a todos los Titanes, "
                + "en venganza por la muerte de su madre.");
        shingekiNoKyojin.setEmissio(true);
        shingekiNoKyojin.setTotalTemporades(2);

        boBoBo.setNom("Bobobo");
        boBoBo.setCategoria("Humor");
        boBoBo.setDisponible(true);
        boBoBo.setAny(2003);
        boBoBo.setProductora("Toei");
        boBoBo.setSinopsis("En el año 300X la Tierra cae bajo el dominio del malvado Imperio Margarita y el emperador Bola de Billar IV,"
                + " quien, para afianzar su poder, decide crear un ejército de Cazadores de Pelo, que se dedican a rapar a la gente de"
                + " todo el mundo. Bobobo, que desde pequeño tuvo la especial habilidad de comunicarse con el pelo de la gente e incluso"
                + " con el suyo propio, se ve empujado a luchar contra Bola de Billar IV y toma el seudónimo de \"El liberta-cabelleras\"."
                + " Con la ayuda de cada vez más personajes, igual de variopintos que él, y sus ataques con los pelos de la nariz,"
                + " irá derrotando a las diferentes divisiones del ejército del malvado emperador, hasta crear un mundo en el que el pelo"
                + " de la gente pueda ser libre.");
        boBoBo.setEmissio(false);
        boBoBo.setTotalTemporades(2);

        /*
         *   ArrayList de Series
         */
        
        ArrayList<Serie> series = new ArrayList<>();
        series.add(boBoBo);
        series.add(shingekiNoKyojin);
        ArrayList<Serie> serios = new ArrayList<>();

        /*
         *   D'Objectes i ArrayList de Temporades
         */

        /*
         *  Codi per a crear temporades. Necesita que l'arraylist estigui incialitzada.
         *  Preguntarà a l'última temporada si està en emisió o no, si está ho desa tal cual,
         *  si està acabada ens deixa desar els capítols.
         */
        
        int i;
        /*for (i = 1; i <= boBoBo.getTotalTemporades(); i++) {

            Temporada tempora = new Temporada();
            tempora.setNumeroTemporada(i);
            tempora.setNom("Temporada " + i);
            if (i == boBoBo.getTotalTemporades()) { // Aixó si es l'última
                System.out.println("\nLa " + tempora.getNom() + " de " + boBoBo.getNom() + " está en emisióbn? (true o false)\n");
                String string;
                Scanner e = new Scanner(System.in);
                string = e.nextLine();
                boolean si = Boolean.valueOf(string);
                tempora.setEmissio(si);
                if (si) { // Aixó si está en emissio
                    boBoBo.afegirTemporada(tempora);
                } else { // Aixó si está acabada
                    System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + boBoBo.getNom() + ": \n");
                    string = e.nextLine();
                    int y = Integer.parseInt(string);
                    tempora.setTotalCapitols(y);
                    boBoBo.afegirTemporada(tempora);  // Afegim Temporada a la Serie
                }//endif
            } else { // Aixó si está acabada
                tempora.setEmissio(false);
                System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + boBoBo.getNom() + ": \n");
                String string;
                Scanner e = new Scanner(System.in);
                string = e.nextLine();
                int y = Integer.parseInt(string);
                tempora.setTotalCapitols(y);
                boBoBo.afegirTemporada(tempora);  // Afegim Temporada a la Serie
            } //endif  
     
        } //endfor
        
        /*
         *  Mateixa funció per a shingekiNoKyojin.
         */

        /*for (i = 1; i <= shingekiNoKyojin.getTotalTemporades(); i++) {
            Temporada tempora = new Temporada();
            tempora.setNumeroTemporada(i);
            tempora.setNom("Temporada " + i);
            if (i == shingekiNoKyojin.getTotalTemporades()) { // Aixó si es l'última
                System.out.println("\nLa " + tempora.getNom() + " de " + shingekiNoKyojin.getNom() + " está en emisióbn? (true o false)\n");
                String string;
                Scanner e = new Scanner(System.in);
                string = e.nextLine();
                boolean si = Boolean.valueOf(string);
                tempora.setEmissio(si);
                if (si) { // Aixó si está en emissio
                    shingekiNoKyojin.afegirTemporada(tempora);
                } else { // Aixó si está acabada
                    System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + shingekiNoKyojin.getNom() + ": \n");
                    string = e.nextLine();
                    int y = Integer.parseInt(string);
                    tempora.setTotalCapitols(y);
                    shingekiNoKyojin.afegirTemporada(tempora);  // Afegim Temporada a la Serie
                }//endif
            } else { // Aixó si está acabada
                tempora.setEmissio(false);
                System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + shingekiNoKyojin.getNom() + ": \n");
                String string;
                Scanner e = new Scanner(System.in);
                string = e.nextLine();
                int y = Integer.parseInt(string);
                tempora.setTotalCapitols(y);
                shingekiNoKyojin.afegirTemporada(tempora);  // Afegim Temporada a la Serie
            } //endif
        } //endfor
        
        /*
         *   Creació d'Objectes d'Usuari.
         */
        
        Usuari admin = new Usuari();
         		         
         admin.setNom("admin");	
         admin.setCiutat("Internet");
         admin.setCodiPostal(6666);
         admin.setCognoms("strador");	
         admin.setDireccio("www.google.com");
         admin.setDni("127.0.0.1");
         admin.setNumTargeta(0000000000007);
         admin.setTelefon(687969314);

        /*
         *  Creació d'ArrayList d'Usuari.
         */
         
        ArrayList<Usuari> usuaris = new ArrayList<>();
        usuaris.add(admin);
        ArrayList<Usuari> usuarios = new ArrayList<>();

        /*
         *  Merda de codi de prova
         */
         
//         if (shingekiNoKyojin instanceof Serie){
//             System.out.print(shingekiNoKyojin);	
//         }//endif
         
        /*
         *  Codi semi-definitiu.
         */
        
        //desarBD(usuaris, pelicules, series);
        carregarBD(usuarios, peliculas, serios);
        System.out.println(shingekiNoKyojin.getSinopsis());
        
    } //endmain

} //endclass
