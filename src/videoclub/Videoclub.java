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
    public static final String rutaPel = "BD/pelicules.bin";
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
        int i = 0;

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
        dragonBallZBattleOfGods.setSinopsis("Algunos años después de la batalla con Majin Buu, Bills, el dios de la destrucción,"
                + " encargado de mantener el equilibrio del universo, se ha despertado de un largo sueño. Al escuchar rumores sobre"
                + " un saiyajin que ha vencido a Freezer, Bills parte a la búsqueda de Goku. Emocionado por el hecho de que haya aparecido,"
                + " después de tanto tiempo, un oponente tan poderoso, Goku ignora las advertencias de Kaito y decide enfrentarse a él.");
        dragonBallZBattleOfGods.setProductora("Toei Animation");
        dragonBallZBattleOfGods.setCategoria("Aventura");
        dragonBallZBattleOfGods.setDisponible(true);
        dragonBallZBattleOfGods.setAny(2013);
        dragonBallZBattleOfGods.setDuracio(85);

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
        onePieceBattleOfZ.setDuracio(107);

        Pelicula thePlacePromisedinOurEarlyDays = new Pelicula();

        thePlacePromisedinOurEarlyDays.setNom("The Place Promised in Our Early Days");
        thePlacePromisedinOurEarlyDays.setSinopsis(" En un lugar alternativo de la historia justo después de finalizada la segunda guerra mundial,"
                + " Japón fue dividida y gobernada en una parte por la Unión Soviética y por otro lado los Estados unidos. Tres estudiantes de"
                + " secundaria deciden hacer la promesa de cruzar la frontera con un avión construido por ellos mismos y desentrañar el misterio"
                + " tras una enorme torre que se ve a lo lejos. Sayuri Sawatari enferma de manera misteriosa y sus amigos deben de buscar la "
                + "manera de salvarla y la respuesta puede encontrarse más allá de la frontera. ");
        thePlacePromisedinOurEarlyDays.setProductora("Makoto Shinkai");
        thePlacePromisedinOurEarlyDays.setCategoria("Romántica");
        thePlacePromisedinOurEarlyDays.setDisponible(true);
        thePlacePromisedinOurEarlyDays.setAny(2004);
        thePlacePromisedinOurEarlyDays.setDuracio(90);

        Pelicula narutoTheLast = new Pelicula();

        narutoTheLast.setNom("The Last: Naruto the Movie");
        narutoTheLast.setSinopsis("¡La luna está cerca de colisionar! ¡A este paso, con la luna a punto de colisionar, caerá a la Tierra "
                + "convirtiéndose en un meteorito! ¡La cuenta atrás del Día del Juicio Final comienza! ¡¿Cómo se enfrentará Naruto a esta "
                + "crisis?!");
        narutoTheLast.setProductora("Studio Pierrot");
        narutoTheLast.setCategoria("Acció");
        narutoTheLast.setDisponible(true);
        narutoTheLast.setAny(2014);
        narutoTheLast.setDuracio(112);

        Pelicula elViajeDeChihiro = new Pelicula();

        elViajeDeChihiro.setNom("El viaje de Chichiro");
        elViajeDeChihiro.setSinopsis("Chihiro es una niña de diez años que viaja en coche con sus padres. Después de atravesar un túnel, "
                + "llegan a un mundo fantástico, en el que no hay lugar para los seres humanos, sólo para los dioses de primera y segunda "
                + "clase. Cuando descubre que sus padres han sido convertidos en cerdos, Chihiro se siente muy sola y asustada. ");
        elViajeDeChihiro.setProductora("Studio Ghibli");
        elViajeDeChihiro.setCategoria("Aventura");
        elViajeDeChihiro.setDisponible(true);
        elViajeDeChihiro.setAny(2002);
        elViajeDeChihiro.setDuracio(125);

        Pelicula miVecinoTotoro = new Pelicula();

        miVecinoTotoro.setNom("Mi Vecino Totoro");
        miVecinoTotoro.setSinopsis("En los años 50, una familia japonesa se traslada al campo. Las dos hijas, Satsuki y Mei, entablan "
                + "amistad con Totoro, un espíritu del bosque. El padre es un profesor universitario que estimula la imaginación de sus"
                + " hijas relatándoles fábulas e historias mágicas sobre duendes, fantasmas y espíritus protectores de los hogares, mientras"
                + " la madre se encuentra enferma en el hospital.");
        miVecinoTotoro.setProductora("Studio Ghibli");
        miVecinoTotoro.setCategoria("Fantastico");
        miVecinoTotoro.setDisponible(true);
        miVecinoTotoro.setAny(1988);
        miVecinoTotoro.setDuracio(86);

        Pelicula laTumbaDeLasLuciernagas = new Pelicula();

        laTumbaDeLasLuciernagas.setNom("La tumba de las luciernagas");
        laTumbaDeLasLuciernagas.setSinopsis("Segunda Guerra Mundial (1939-1945). Seita y Setsuko son hijos de un oficial de la marina "
                + "japonesa que viven en Kobe. Un día, durante un bombardeo, no consiguen llegar a tiempo al búnker donde su madre los "
                + "espera. Cuando después buscan a su madre, la encuentran malherida en la escuela, que ha sido convertida en un hospital"
                + " de urgencia. ");
        laTumbaDeLasLuciernagas.setProductora("Studio Ghibli");
        laTumbaDeLasLuciernagas.setCategoria("Drama");
        laTumbaDeLasLuciernagas.setDisponible(true);
        laTumbaDeLasLuciernagas.setAny(2003);
        laTumbaDeLasLuciernagas.setDuracio(90);

        Pelicula bleachMemoriesOfNobody = new Pelicula();

        bleachMemoriesOfNobody.setNom("Bleach: Memories of nobody");
        bleachMemoriesOfNobody.setSinopsis("Después de regresar de la Sociedad de Almas y estando en el mundo humano, específicamente "
                + "en la ciudad Karakura, Ichigo Kurosaki y Rukia Kuchiki son atacados por una gran cantidad de almas desconocidas. "
                + "Mientras Ichigo y Rukia peleaban contra estos espíritus, aparece un shinigami llamado Senna, una chica de pelo morado "
                + "y ojos anaranjados, quien destruye fácilmente a los espíritus con su shikai. Como Senna niega responder pregunta alguna "
                + "por parte de Ichigo, se ve obligado a seguirla.");
        bleachMemoriesOfNobody.setProductora("Studio Pierrot");
        bleachMemoriesOfNobody.setCategoria("Accion");
        bleachMemoriesOfNobody.setDisponible(true);
        bleachMemoriesOfNobody.setAny(2006);
        bleachMemoriesOfNobody.setDuracio(90);

        Pelicula fairyTailLaSacerdotisaDelFenix = new Pelicula();

        fairyTailLaSacerdotisaDelFenix.setNom("Fairy Tail: La sacerdotisa del fénix");
        fairyTailLaSacerdotisaDelFenix.setSinopsis(" En Fairy Tail: Hoo no Miko, Lucy conocerá a una joven amnésica llamada Eclair, "
                + "cuyo único recuerdo es que debe entregar la Piedra del Fénix en algún lugar. Así, Lucy se propondrá ayudar a la chica "
                + "a completar su misión, empezando una nueva aventura.");
        fairyTailLaSacerdotisaDelFenix.setProductora("A-1 Pictures");
        fairyTailLaSacerdotisaDelFenix.setCategoria("Aventuras");
        fairyTailLaSacerdotisaDelFenix.setDisponible(true);
        fairyTailLaSacerdotisaDelFenix.setAny(2012);
        fairyTailLaSacerdotisaDelFenix.setDuracio(86);

        Pelicula pokemonArceusYLaJoyaDeLaVida = new Pelicula();

        pokemonArceusYLaJoyaDeLaVida.setNom("Pokémon: Arceus y la joya de la vida");
        pokemonArceusYLaJoyaDeLaVida.setSinopsis("Los protagonistas conocen a unos muchachos que resultan ser los cuidadores de unas ruinas"
                + " y les darán información importante. Deben viajar al pasado para hablar con el poseedor de la joya de la vida. ");
        pokemonArceusYLaJoyaDeLaVida.setProductora("OLM Incorporated");
        pokemonArceusYLaJoyaDeLaVida.setCategoria("Aventuras");
        pokemonArceusYLaJoyaDeLaVida.setDisponible(true);
        pokemonArceusYLaJoyaDeLaVida.setAny(2009);
        pokemonArceusYLaJoyaDeLaVida.setDuracio(93);

        Pelicula karukenbo = new Pelicula();

        karukenbo.setNom("Karukenbo");
        karukenbo.setSinopsis("Según la leyenda urbana, en una ciudad abandonada se juega el Otokoyo una versión del Kakurenbo, donde "
                + "los niños que deseen participar deben ponerse máscaras de zorros y seguir las pistas que los llevarán al punto de"
                + " inicio del juego; una vez que haya siete niños se iniciará el juego de las escondidas por los oscuros callejones de"
                + " la ciudad. Sin embargo los rumores dicen que los niños desaparecen uno a uno cada vez que participan, y que los"
                + " culpables de estas desapariciones son onis (en el kakurembo el encargado de buscar a los que se ocultan es llamado Oni).");
        karukenbo.setProductora("YamatoWorks");
        karukenbo.setCategoria("Terror");
        karukenbo.setDisponible(true);
        karukenbo.setAny(2005);
        karukenbo.setDuracio(25);

        Pelicula perfectBlue = new Pelicula();

        perfectBlue.setNom("Perfect blue");
        perfectBlue.setSinopsis("Mima es la cantante de un famoso grupo musical japonés. Debido al fracaso de ventas de sus discos, su "
                + "mánager decide apartarla del grupo y darle un papel en una serie de televisión. Mima cae entonces en una profunda"
                + " depresión que la lleva a replantearse su vida y su carrera, pero su crisis se agrava cuando descubre que su vida está"
                + " al alcance de cualquiera en Internet y que alguien la está vigilando. Cuando la serie empieza a emitirse por televisión,"
                + " Mima comprueba que la ficción se reproduce en su vida real: sueño y realidad se confunden hasta el punto de "
                + "cuestionarse su propia identidad. El desarrollo de los acontecimientos y su propia intuición llevarán a la protagonista"
                + " a un desenlace absolutamente inesperado... ");
        perfectBlue.setProductora("Rex Entertainment");
        perfectBlue.setCategoria("Terror");
        perfectBlue.setDisponible(true);
        perfectBlue.setAny(1998);
        perfectBlue.setDuracio(81);

        Pelicula astroBoy = new Pelicula();

        astroBoy.setNom("Astro Boy");
        astroBoy.setSinopsis("\"Astro Boy\" es la adaptación cinematográfica de un cómic del prestigioso Osamu Tezuka, que dio origen a "
                + "una popular serie de televisión japonesa de los 60. Su protagonista es un joven robot con increíbles poderes que ha"
                + " sido creado por un brillante científico para reemplazar al hijo que perdió. Sintiéndose incapaz de colmar las "
                + "expectativas que el hombre ha depositado en él, se embarcará en un viaje en busca de aceptación, experimentará la "
                + "traición y descubrirá un mundo de robots gladiadores.");
        astroBoy.setProductora("Imagi Crystal");
        astroBoy.setCategoria("Acción");
        astroBoy.setDisponible(true);
        astroBoy.setAny(2009);
        astroBoy.setDuracio(83);

        Pelicula fullmetalAlchemistConquistadorDeShambala = new Pelicula();

        fullmetalAlchemistConquistadorDeShambala.setNom("Fullmetal Alchemist: Conquistador de Shambala");
        fullmetalAlchemistConquistadorDeShambala.setSinopsis("Es el año 1923, en Munich. Han pasado dos años desde el episodio final de "
                + "la serie \"Fullmetal Alchemist\", dos años desde que Edward se sacrificara para poder resucitar a su hermano Alphonse "
                + "y que llegara nuestro mundo. Hasta entonces, Edo ha estado intentando volver a su mundo, estudiando sobre cohetes y el "
                + "viaje al espacio, creyendo que así podrá regresar. Mientras, Al viaja por su mundo buscando la manera de poder recuperar"
                + " a su hermano. Lo que ellos no saben es que una organizacion oculta prepara un plan que podría poner en peligro ambos "
                + "mundos...");
        fullmetalAlchemistConquistadorDeShambala.setProductora("Shochiku Company");
        fullmetalAlchemistConquistadorDeShambala.setCategoria("Acción");
        fullmetalAlchemistConquistadorDeShambala.setDisponible(true);
        fullmetalAlchemistConquistadorDeShambala.setAny(2005);
        fullmetalAlchemistConquistadorDeShambala.setDuracio(104);

        Pelicula cincocCentimetrosPorSegundo = new Pelicula();

        cincocCentimetrosPorSegundo.setNom("Cinco centimetros por segundo");
        cincocCentimetrosPorSegundo.setSinopsis("¿Cuándo empecé a escribir mensajes que nunca envío? ¿A qué velocidad debo vivir para "
                + "volverte a ver? Después de graduarse en escuela primaria, Takaki Tono y Akari Shinohara fueron por caminos separados a "
                + "pesar de lo que sentían uno por el otro. Lo unico que pasó entre ellos fue el tiempo. Un día, en medio de una tormenta de"
                + " nieve, Takaki finalmente fue a ver a Akari... La película consta de 3 historias que narran varias etapas desde distintos"
                + " puntos de vista: \"Extracto de Flor de Cerezo\", \"Cosmonauta\" y \"5 centímetros por segundo\". ");
        cincocCentimetrosPorSegundo.setProductora("CoMix Wave");
        cincocCentimetrosPorSegundo.setCategoria("Drama");
        cincocCentimetrosPorSegundo.setDisponible(true);
        cincocCentimetrosPorSegundo.setAny(2007);
        cincocCentimetrosPorSegundo.setDuracio(63);

        Pelicula haruEnElReinoDeLosGatos = new Pelicula();

        haruEnElReinoDeLosGatos.setNom("Haru en el reino de los gatos");
        haruEnElReinoDeLosGatos.setSinopsis("Esta es la historia de Haru, una joven cuya suerte cambiará cuando un día, al volver del "
                + "instituto, salva a un gato de ser atropellado por un camión. Pero no es un gato común, es Lune, el Príncipe del Reino "
                + "de los Gatos. En recompensa por su acción, Haru es invitada a pasar un tiempo en el reino de Lune.");
        haruEnElReinoDeLosGatos.setProductora("Studio Ghibli");
        haruEnElReinoDeLosGatos.setCategoria("Fantastico");
        haruEnElReinoDeLosGatos.setDisponible(true);
        haruEnElReinoDeLosGatos.setAny(2002);
        haruEnElReinoDeLosGatos.setDuracio(72);

        Pelicula bayonettaBloodyFate = new Pelicula();

        bayonettaBloodyFate.setNom("Bayonetta: bloody fate");
        bayonettaBloodyFate.setSinopsis("Hace mucho tiempo en una ciudad llamada Vigrid, los sabios (seres de la luz) y las brujas "
                + "(seres de la oscuridad) vivían en armonía. El mundo de los hombres, el infierno y el paraíso estaban en orden, hasta"
                + " que se desató odio entre estos clanes, provocando una guerra sangrienta que terminó con la existencia de las brujas "
                + "en Europa durante la Edad Media. Todas murieron, excepto Bayonetta, que despertó después de 500 años de sueño y se "
                + "encuentra en una zona desconocida sin recuerdos de quién o qué es. Adaptación anime del videojuego homónimo.");
        bayonettaBloodyFate.setProductora("Gonzo");
        bayonettaBloodyFate.setCategoria("Acción");
        bayonettaBloodyFate.setDisponible(true);
        bayonettaBloodyFate.setAny(2013);
        bayonettaBloodyFate.setDuracio(91);

        Pelicula bloodElUltimoVampiro = new Pelicula();

        bloodElUltimoVampiro.setNom("Blood: el último vampiro");
        bloodElUltimoVampiro.setSinopsis("Una nueva raza de vampiros ha surgido de la oscuridad. Están entre nosotros, acechando, sedientos "
                + "de sangre en busca de nuevas víctimas. Una guerra silenciosa entre vampiros y humanos ha estallado. Una organización"
                + " secreta ha sido designada para limpiar el mundo de esta amenaza. Entre sus mejores agentes se encuentra una misteriosa"
                + " muchacha llamada Saya, cuyo carácter frío y calculador la convierten en la mejor cazadora de vampiros. Por todo ello ha"
                + " sido escogida para llevar a cabo una peligrosa misión: infiltrarse en una base militar estadounidense situada en Japón"
                + " e investigar si la serie de misteriosas muertes ocurridas recientemente tienen relación con los vampiros.");
        bloodElUltimoVampiro.setProductora("Production I.G.");
        bloodElUltimoVampiro.setCategoria("Terror");
        bloodElUltimoVampiro.setDisponible(true);
        bloodElUltimoVampiro.setAny(2001);
        bloodElUltimoVampiro.setDuracio(48);

        Pelicula losNiñosLobo = new Pelicula();

        losNiñosLobo.setNom("Los niños lobo");
        losNiñosLobo.setSinopsis("Cuando era poco más que una adolescente, Hana se enamoró de un Hombre Lobo. Puede parecer extraño, pero"
                + " durante años fueron inmensamente felices, y tuvieron dos hijos: Yuki y Ame, que nacieron también con la capacidad de "
                + "convertirse en lobos. Tras la repentina muerte de su compañero, Hana decide mudarse al campo para así criar a sus hijos"
                + " en un entorno tranquilo, donde sus extraordinarias facultades no sean descubiertas. Sin embargo, al crecer, Yuki y Ame "
                + "deberán decidir si quieren vivir como humanos o como lobos. Un hermoso cuento salido de la imaginación de Mamoru Hosoda,"
                + " que ya nos maravilló con \"La chica que saltaba a través del tiempo\" y \"Summer Wars\".");
        losNiñosLobo.setProductora("Madhouse");
        losNiñosLobo.setCategoria("Drama");
        losNiñosLobo.setDisponible(true);
        losNiñosLobo.setAny(2012);
        losNiñosLobo.setDuracio(117);

        Pelicula elJardínDeLasPalabras = new Pelicula();

        elJardínDeLasPalabras.setNom("El jardín de las palabras");
        elJardínDeLasPalabras.setSinopsis("Takao Akizuki es un estudiante de 15 años que desea convertirse en diseñador de zapatos. Le gustan"
                + " los días lluviosos, por lo que cuando llueve prefiere caminar que tomar el tren a la escuela. En una de sus caminatas "
                + "bajo la lluvia, encuentra a una misteriosa mujer bajo el gazebo de un parque, la cual pasa el tiempo bebiendo cerveza y "
                + "comiendo chocolates. Así Takao comenzará a tener una relación más estrecha con la mujer, encontrándose los dos en el mismo"
                + " lugar en días lluviosos para hablar, mientras Takao dibuja zapatos y la misteriosa mujer bebe cerveza y come chocolates."
                + " Pero todo cambia cuando la temporada de lluvias termina y Takao no encuentre tal pretexto de faltar a la escuela y la "
                + "mujer comience a asistir a su trabajo, lo cual hará que Takao descubra la verdadera identidad de su misteriosa "
                + "interlocutora.");
        elJardínDeLasPalabras.setProductora("CoMix Wave Films");
        elJardínDeLasPalabras.setCategoria("Romantica");
        elJardínDeLasPalabras.setDisponible(true);
        elJardínDeLasPalabras.setAny(2013);
        elJardínDeLasPalabras.setDuracio(46);

        /*
         *   ArrayList de Pelicula
         */
        ArrayList<Pelicula> pelicules = new ArrayList<>();

        pelicules.add(dragonBallZBattleOfGods);
        pelicules.add(onePieceBattleOfZ);
        pelicules.add(thePlacePromisedinOurEarlyDays);
        pelicules.add(narutoTheLast);
        pelicules.add(elViajeDeChihiro);
        pelicules.add(miVecinoTotoro);
        pelicules.add(laTumbaDeLasLuciernagas);
        pelicules.add(bleachMemoriesOfNobody);
        pelicules.add(fairyTailLaSacerdotisaDelFenix);
        pelicules.add(pokemonArceusYLaJoyaDeLaVida);
        pelicules.add(karukenbo);
        pelicules.add(perfectBlue);
        pelicules.add(astroBoy);
        pelicules.add(fullmetalAlchemistConquistadorDeShambala);
        pelicules.add(cincocCentimetrosPorSegundo);
        pelicules.add(haruEnElReinoDeLosGatos);
        pelicules.add(bayonettaBloodyFate);
        pelicules.add(bloodElUltimoVampiro);
        pelicules.add(losNiñosLobo);
        pelicules.add(elJardínDeLasPalabras);

        ArrayList<Pelicula> peliculas = new ArrayList<>();


        /*
         *   Objectes de Serie
         */
        Serie shingekiNoKyojin = new Serie();
        Serie boBoBo = new Serie();
        Serie onePiece = new Serie();
        Serie fairyTail = new Serie();
        Serie dragonBall = new Serie();
        Serie dragonBallZ = new Serie();
        Serie deathNote = new Serie();
        Serie noGameNoLife = new Serie();
        Serie swordArtOnline = new Serie();
        Serie logHorizon = new Serie();
        Serie elfenLied = new Serie();
        Serie loveHina = new Serie();
        Serie detectiveConan = new Serie();

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

        onePiece.setNom("One Piece");
        onePiece.setSinopsis("Una historia épica de piratas, donde narra la historia de \"Monkey D. Luffy\" quien cuando tenia 7 años, "
                + "comió accidentalmente una \"Akuma no mi\"(Fruta del diablo) la cual le convirtió en un hombre de goma. Por otra parte"
                + " \"Gol D. Roger\" conocido como \"El rey de los Piratas\" quien fuera ejecutado por la Marine, habló antes de morir,"
                + " acerca de su mayor tesoro,el \"One Piece\" escondido en la \"Gran line\". Esta noticia desató la gran era de los piratas"
                + " lanzando a incontables piratas a ese lugar, en busca del \"One Piece\" el tesoro perdido. Diez años después, Luffy "
                + "inspirado en \"Gol D. Roger\" y un pirata de nombre Akagami no Shanks (Shanks el pelirrojo) se convierte en pirata deseando"
                + " ser el próximo \"Rey de los Piratas\" y zarpar para conocer amigos y tener aventuras con ellos, teniendo como meta "
                + "encontrar el \"One Piece\".");
        onePiece.setProductora("Toei Animation");
        onePiece.setCategoria("Aventuras");
        onePiece.setAny(1999);
        onePiece.setEmissio(true);
        onePiece.setTotalTemporades(11);
        onePiece.setDisponible(true);

        fairyTail.setNom("Fairy Tail");
        fairyTail.setSinopsis("Fairy Tail cuenta la historia de un joven mago llamado Natsu en la búsqueda de su maestro y padre adoptivo"
                + "Igneel que resulta ser un dragón. Por ello se unió a Fairy Tail, un gremio de magos que es famoso por los destrozos y"
                + " daños que provocan en diversas ciudades (lo cual no debería ser así). El mundo de Fairy Tail gira alrededor de los magos "
                + "(los cuales poco tienen que ver con la idea general del mago común) que realizan encargos a cambio de dinero, similar a un"
                + " cazarecompensas. Natsu conoce a Lucy, una guapa muchacha cuyo sueño era ingresar a un gremio de magos, específicamente,"
                + " a Fairy Tail, lo cual consigue gracias a la ayuda de Natsu. De ahí en adelante, la historia sigue los movimientos de esta"
                + " pareja de magos los cuales se ven envueltos en un sin número de aventuras antes de conseguir la meta final de encontrar "
                + "a Igneel. Fairy Tail Tail");
        fairyTail.setProductora("A-1 Pictures");
        fairyTail.setCategoria("Aventura");
        fairyTail.setAny(2006);
        fairyTail.setEmissio(true);
        fairyTail.setTotalTemporades(2);
        fairyTail.setDisponible(true);

        dragonBall.setNom("Dragon Ball");
        dragonBall.setSinopsis("La serie trata de un niño llamado Son Goku, el cuál un día se encuentra a una chica llamada Bulma. Ésta le "
                + "cuenta la existencia de unas bolas de dragón que pueden conceder cualquier deseo a quien reúna las 7. Goku y Bulma vivirán"
                + " un montón de aventuras para encontrarlas.");
        dragonBall.setProductora("Toei Animation");
        dragonBall.setCategoria("Aventuras");
        dragonBall.setAny(1986);
        dragonBall.setEmissio(false);
        dragonBall.setTotalTemporades(7);
        dragonBall.setDisponible(true);

        dragonBallZ.setNom("Dragon Ball Z");
        dragonBallZ.setSinopsis("Dragon Ball Z es la continuación de la vida adulta que lleva Goku, paralelamente narra la madurez de su hijo,"
                + " Gohan. Entre Goku y todos sus amigos intentarán proteger la Tierra de las diferentes amenazas que irán surgiendo. ");
        dragonBallZ.setProductora("Toei Animation");
        dragonBallZ.setCategoria("Acción");
        dragonBallZ.setAny(1989);
        dragonBallZ.setEmissio(false);
        dragonBallZ.setTotalTemporades(8);
        dragonBallZ.setDisponible(true);

        deathNote.setNom("Death Note");
        deathNote.setSinopsis("Death Note cuenta la historia sobre un joven llamado Yagami Light. Un aburrido día de clase ve caer un cuaderno "
                + "negro en el patio de su escuela, titulado Death Note. Según las instrucciones escritas en el mismo cuaderno, aquella persona "
                + "cuyo nombre sea escrito en dicho cuaderno, morirá. En un principio se cree que es una de esas estúpidas cadenas... pero “Kira”,"
                + " como será reconocido por las masas, prueba el Death Note... y efectivamente, funciona.");
        deathNote.setProductora("Shueisha");
        deathNote.setCategoria("Fantastico");
        deathNote.setAny(2006);
        deathNote.setEmissio(false);
        deathNote.setTotalTemporades(2);
        deathNote.setDisponible(true);

        noGameNoLife.setNom("No game no life");
        noGameNoLife.setSinopsis("No Game, No Life se centra en Sora y Shiro, unos hermanos cuya reputación de NEETs hikikomoris y gamers han hecho"
                + " que comiencen a extenderse leyendas urbanas suyas por todo internet.\n Estos dos gamers consideran que el mundo real no es más que"
                + " “un juego de mierda”. Un día, un chico llamado “Dios” les invoca en un mundo alternativo. En este mundo, Dios ha prohibido la guerra"
                + " y declarado que todo se decide en base a los juegos, incluso las fronteras de los países. La humanidad vive ahora en una ciudad por "
                + "culpa del resto de razas. ¿Se convertirán Sora y Shiro, hermano y hermana, en los salvadores de este mundo alternativo?");
        noGameNoLife.setProductora("Madhouse");
        noGameNoLife.setCategoria("Fantasia");
        noGameNoLife.setAny(2014);
        noGameNoLife.setEmissio(false);
        noGameNoLife.setTotalTemporades(1);
        noGameNoLife.setDisponible(true);

        swordArtOnline.setNom("Sword Art Online");
        swordArtOnline.setSinopsis("Escapar es imposible hasta terminar el juego; un game over significaría una verdadera \"muerte\". Sin saber la "
                + "\"verdad\" de la siguiente generación del Multijugador Masivo Online, 'Sword Art Online(SAO)', con 10 mil usuarios unidos juntos "
                + "abriendo las cortinas para esta cruel batalla a muerte. Participando solo en SAO, el protagonista Kirito ha aceptado inmediatamente"
                + " la \"verdad\" de este MMO. Y, en el mundo del juego, un gigante castillo flotante llamado 'Aincrad', Kirito se distinguió a si "
                + "mismo como un jugador solitario. Apuntando a terminar el juego al alcanzar la planta mas alta el solo continua avanzando "
                + "arriesgadamente hasta que recibe una invitación a la fuerza de una guerrera y esgrimista experta, Asuna, con la cual tendra "
                + "que hacer equipo.");
        swordArtOnline.setProductora("A-1 Pictures");
        swordArtOnline.setCategoria("Aventuras");
        swordArtOnline.setAny(2012);
        swordArtOnline.setEmissio(false);
        swordArtOnline.setTotalTemporades(4);
        swordArtOnline.setDisponible(true);

        logHorizon.setNom("Log Horizon");
        logHorizon.setSinopsis("Elder Tale es un juego online de relidad virtual de mucho éxito entre los jugadores Japoneses, pero el día en que"
                + " se lanzó el décimo segundo pack de expansión, 30.000 usuarios se vieron encerrados en el mundo fantástico de Elder Tale. El "
                + "juego consigue fusionar el mundo virtual con el mundo real, donde Shiroe comienza su lucha junto a sus compañeros Naotsugu y "
                + "la bella asesina Akatsuki desde la ciudad de Akiba Io.");
        logHorizon.setProductora("NHK");
        logHorizon.setCategoria("Aventuras");
        logHorizon.setAny(2013);
        logHorizon.setEmissio(false);
        logHorizon.setTotalTemporades(2);
        logHorizon.setDisponible(true);

        elfenLied.setNom("Elfen Lied");
        elfenLied.setSinopsis("Los diclonius (humanos con dos pequeños cuernos) son unos mutantes creados por el hombre con un don que se le podría"
                + " denominar como un sexto sentido. Estos seres tienen el poder necesario como para eliminar toda la humanidad. La humanidad está "
                + "preocupada, y comienza a estudiarlos para buscar un remedio. Lucy, uno de los diclonius, se escapa de su cámara de contención, "
                + "matando a todo aquél que se interpone en su camino, hasta caer al mar... Al día siguiente acaba en una playa, donde Kouta y Yuka "
                + "la encuentran y la alojan en su finca con el nombre de Nyu...");
        elfenLied.setProductora("GENCO");
        elfenLied.setCategoria("Gore");
        elfenLied.setAny(2004);
        elfenLied.setEmissio(false);
        elfenLied.setTotalTemporades(1);
        elfenLied.setDisponible(true);

        loveHina.setNom("Love Hina");
        loveHina.setSinopsis("Love Hina cuenta la historia de un joven llamado Keitaro Urashima que a los 5 años le prometió a una chica que irían "
                + "juntos a la todai (universidad de Tokyo), donde vivirían juntos. 15 años después, sin recordar el nombre o la cara de la niña y "
                + "tras dos intentos fallidos de entrar en la todai, Keitaro va a trabajar en una residencia femenina mientras sigue estudiando para "
                + "entrar en la todai. En la residencia, Hinata tendrá que convivir con las chicas con personalidades muy diferentes mientras se "
                + "enfrenta a problemas domésticos y sentimentales. ");
        loveHina.setProductora("TV Tokyo");
        loveHina.setCategoria("Humor");
        loveHina.setAny(2000);
        loveHina.setEmissio(false);
        loveHina.setTotalTemporades(2);
        loveHina.setDisponible(true);

        detectiveConan.setNom("Detective Conan");
        detectiveConan.setSinopsis("Shinichi Kudo es un joven detective que consigue esclarecer cualquier misterio, por difícil que sea. Un día,"
                + " nuestro protagonista descubre los maléficos planes de una peligrosa organización criminal y es envenenado. Sin embargo, el veneno no"
                + " lo mata, sino que por accidente, lo encoge y lo convierte en un niño de apenas 6 años. Atrapado en este cuerpo, Shinichi, bajo el "
                + "seudónimo de Conan Edogawa, deberá resolver los casos más difíciles mientras intenta encontrar un antídoto que lo devuelva a la normalidad "
                + "y hacer lo posible para que su amiga, Ran Mouri, no sospeche quién es realmente el sabiondo Conan...");
        detectiveConan.setProductora("Tokyo Movie Shinsha ");
        detectiveConan.setCategoria("Intriga");
        detectiveConan.setAny(1996);
        detectiveConan.setEmissio(true);
        detectiveConan.setTotalTemporades(24);
        detectiveConan.setDisponible(true);

        /*
         *   ArrayList de Series per a desar informació de Temporades.
         *  L'array definitiu estarà baix del for.
         */
        ArrayList<Serie> series = new ArrayList<>();
        series.add(boBoBo);
        series.add(shingekiNoKyojin);
        series.add(onePiece);
        series.add(fairyTail);
        series.add(dragonBall);
        series.add(dragonBallZ);
        series.add(deathNote);
        series.add(noGameNoLife);
        series.add(swordArtOnline);
        series.add(logHorizon);
        series.add(elfenLied);
        series.add(loveHina);
        series.add(detectiveConan);

        /*
         *   D'Objectes i ArrayList de Temporades
         */

        /*
         *  Codi per a crear temporades. Necesita que l'arraylist estigui incialitzada.
         *  Preguntarà a l'última temporada si està en emisió o no, si está ho desa tal cual,
         *  si està acabada ens deixa desar els capítols.
         */
        int i, j;

        for (j = 0; j < series.size(); j++) {
            
            Serie serie = series.get(j);
            
            
            for (i = 1; i <= serie.getTotalTemporades(); i++) {

                Temporada tempora = new Temporada();
                tempora.setNumeroTemporada(i);
                tempora.setNom("Temporada " + i);
                if (i == serie.getTotalTemporades()) { // Aixó si es l'última
                    System.out.println("\nLa " + tempora.getNom() + " de " + serie.getNom() + " está en emisióbn? (true o false)\n");
                    String string;
                    Scanner e = new Scanner(System.in);
                    string = e.nextLine();
                    boolean si = Boolean.valueOf(string);
                    tempora.setEmissio(si);
                    if (si) { // Aixó si está en emissio
                        serie.afegirTemporada(tempora);
                    } else { // Aixó si está acabada
                        System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + serie.getNom() + ": \n");
                        string = e.nextLine();
                        int y = Integer.parseInt(string);
                        tempora.setTotalCapitols(y);
                        serie.afegirTemporada(tempora);  // Afegim Temporada a la Serie
                    }//endif
                } else { // Aixó si está acabada
                    tempora.setEmissio(false);
                    System.out.println("\nCapítulos de la " + tempora.getNom() + " de " + serie.getNom() + ": \n");
                    String string;
                    Scanner e = new Scanner(System.in);
                    string = e.nextLine();
                    int y = Integer.parseInt(string);
                    tempora.setTotalCapitols(y);
                    serie.afegirTemporada(tempora);  // Afegim Temporada a la Serie
                } //endif  

            } //end2nfor
        } //end1rfor
        
        /*
         *  ArrayList definitiva de Serie
        */
        ArrayList<Serie> seriesly = new ArrayList<>();
        seriesly.add(boBoBo);
        seriesly.add(shingekiNoKyojin);
        seriesly.add(onePiece);
        seriesly.add(fairyTail);
        seriesly.add(dragonBall);
        seriesly.add(dragonBallZ);
        seriesly.add(deathNote);
        seriesly.add(noGameNoLife);
        seriesly.add(swordArtOnline);
        seriesly.add(logHorizon);
        seriesly.add(elfenLied);
        seriesly.add(loveHina);
        seriesly.add(detectiveConan);

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
//        ArrayList<Temporada> temp = boBoBo.getTemporadas();
//        Temporada tempo = temp.get(0);
//        
//        System.out.println(tempo.getNumeroTemporada());
//        System.out.println(tempo.getNom());
//        System.out.println(tempo.getTotalCapitols());
        //desarBD(usuaris, pelicules, series);
        //carregarBD(usuarios, peliculas, serios);
        //System.out.println(shingekiNoKyojin.getSinopsis());
    } //endmain

} //endclass
