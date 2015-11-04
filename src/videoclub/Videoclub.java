/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Simón i Pau
 */
public class Videoclub {

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

        ArrayList<String> lista = new ArrayList<String>(); //carregarBD();

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
    public void carregarBD() {

        int i;

    }

    /*
     *   Mètode amb el que es desa tota l'informació en variables.
     *
     */
    public void desarBD() {

    }

    /*
     *   Mètode amb el que filtrem els continguts de les búsquedes.
     *
     */
    public void filtrarContingut() {

    }

    public static void main(String[] args) {
        // TODO code application logic here

        Videoclub aplicacio = new Videoclub();

        System.out.print(aplicacio.buscarLloguer());

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
         *  Codi per a crear temporades. Necesita que l'arraylist estigui incialitzada.
         *  Preguntarà a l'última temporada si està en emisió o no, si está ho desa tal cual,
         *  si està acabada ens deixa desar els capítols.
         */
        int i;
        for (i = 1; i <= boBoBo.getTotalTemporades(); i++) {

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
                    boBoBo.afegirTemporada(tempora);
                }//endif
            } else { // Aixó si está acabada
                tempora.setEmissio(false);
                System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + boBoBo.getNom() + ": \n");
                String string;
                Scanner e = new Scanner(System.in);
                string = e.nextLine();
                int y = Integer.parseInt(string);
                tempora.setTotalCapitols(y);
                boBoBo.afegirTemporada(tempora);
            } //endif
        } //endfor
        
        /*
         *  Mateixa funció per a shingekiNoKyojin.
         */

        for (i = 1; i <= shingekiNoKyojin.getTotalTemporades(); i++) {
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
                    shingekiNoKyojin.afegirTemporada(tempora);
                }//endif
            } else { // Aixó si está acabada
                tempora.setEmissio(false);
                System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + shingekiNoKyojin.getNom() + ": \n");
                String string;
                Scanner e = new Scanner(System.in);
                string = e.nextLine();
                int y = Integer.parseInt(string);
                tempora.setTotalCapitols(y);
                shingekiNoKyojin.afegirTemporada(tempora);
            } //endif
        } //endfor

    } //endmain

} //endclass
