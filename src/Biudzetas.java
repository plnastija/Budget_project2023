import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public  class Biudzetas {
    static Scanner sk = new Scanner(System.in);
    ArrayList<PajamuIrasas> pajamas = new ArrayList<>();
    ArrayList<Islaiduirasas> islaidos = new ArrayList<>();

    static Set<String > katpajiv = Set.of("A001", "A002", "D1", "MK1", "MON", "SR1", "PR"); // sąrašas naudojamas tikrinimui, tikrina vartotojo įvestus parametrus su Enum reikšmė
    static Set<String > atsiskiv = Set.of("A1", "A2", "A3"); // sąrašas naudojamas tikrinimui, tikrina vartotojo įvestus parametrus su Enum reikšmė
    static Set<String > katisliv = Set.of("A001SAV", "A002SAV", "TR", "D1SAV", "MK1SAV", "SR1SAV", "SUB"); // sąrašas naudojamas tikrinimui, tikrina vartotojo įvestus parametrus su Enum reikšmė


    public static void pajamuKategorijaPasirinkimas() { // metodas iskeltas atskirai nes naudosime keliose vietose;
        System.out.println("Įveskite pajamų kategoriją (įveskite tik kodą, kuris skliausteliuose):");
        System.out.printf("""
                        // Pasirinkite iš sarašo: 
                        * (%s) Akumuliatorius100 
                        * (%s) Akumuliatorius200 
                        * (%s) Judesio daviklis
                        * (%s) Lipnus magnetinis kontaktas
                        * (%s) Sirena MR300RL
                        * (%s) Montavimo darbas
                        * (%s) Projektavimas \n""", KategorijaPaj.a001, KategorijaPaj.a002,
                KategorijaPaj.d1, KategorijaPaj.mk1, KategorijaPaj.mon, KategorijaPaj.sr1, KategorijaPaj.pr);
    }

    public static void islaiduKategorijaPasirinkimas() { // metodas iskeltas atskirai nes naudosime keliose vietose;
        System.out.println("Iveskite islaidu kategorija (iveskite tik koda kuris skliausteliuose):");
        System.out.printf("""
                            // Pasirinkite is saraso: 
                            * (%s) Akumuliatorius100 savikaina 
                            * (%s) Akumuliatorius200 savikaina 
                            * (%s) Pristatimas
                            * (%s) Judesio daviklis savikaina
                            * (%s) Lipnus magnetinis kontaktas savikaina
                            * (%s) Sirena MR300RL savikaina
                            * (%s) Subranga darbas\n""", KategorijaIsl.a001sav, KategorijaIsl.a002sav,
                KategorijaIsl.tr, KategorijaIsl.d1sav, KategorijaIsl.mk1sav, KategorijaIsl.sr1sav, KategorijaIsl.sub);
    }
    public static void atsiskaitimasPasirinkimas() { // metodas iskeltas atskirai nes naudosime keliose vietose;
        System.out.println("Iveskite pajamu atsiskaitimo buda:");
        System.out.printf("""
                // (iveskite tik koda kuris skliausteliuose): 
                *  (%s) Grynais
                *  (%s) Banko kortele
                *  (%s) Kliento kortele
                \n""", Atsiskaitimas.a1, Atsiskaitimas.a2, Atsiskaitimas.a3);
    }

    public static PajamuIrasas makePajamas() { // metodas kuris priima parametrus(pajamas) iš vartotojo ir sukuria pajamų irašą (suma, kotegorija, apmokėjimo būdas, komentaras)
        System.out.println("Iveskite pajamu suma (PVZ 20,05):");
        double sumap = sk.nextDouble();

        pajamuKategorijaPasirinkimas();
        String kategorijastring = sk.next().toUpperCase();

        while (!katpajiv.contains(kategorijastring)) {
            System.out.println("Kategorija įvesta neteisingai");
            pajamuKategorijaPasirinkimas();
            kategorijastring = sk.next().toUpperCase();
        }
        String  kategorijastringenum = kategorijastring.toLowerCase();
        KategorijaPaj kategorijap = KategorijaPaj.valueOf(kategorijastringenum);
        System.out.println("Pasirinkta kategorija :" + kategorijap.getPajPavadinimas());

        atsiskaitimasPasirinkimas();
        String atsiskaitimasstring = sk.next().toUpperCase();
        while (!atsiskiv.contains(atsiskaitimasstring)) {
            System.out.println("Atsiskaitimas įvestas neteisingai");
            atsiskaitimasPasirinkimas();
            atsiskaitimasstring = sk.next().toUpperCase();
        }
        String atsiskaitimasstringenum = atsiskaitimasstring.toLowerCase();
        Atsiskaitimas atsiskaitimasp = Atsiskaitimas.valueOf(atsiskaitimasstringenum);

        System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
        String komentarasp = sk.next();
        while (komentarasp.length() >= 10) {
            System.out.println("Komentaras per ilgas");
            System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
            komentarasp = sk.next();
        }
        return new PajamuIrasas(sumap, kategorijap.getPajPavadinimas(), atsiskaitimasp.getPav(), komentarasp);
    }
    public static Islaiduirasas makeIslaidas() { // metodas kuris priima parametrus (islaidus) iš vartotojo ir ir sukuria išlaidų irašą(suma, kotegorija, apmokėjimo būdas, komentaras)
        System.out.println("Iveskite islaidu suma (PVZ 18,03):");
        double sumais = sk.nextDouble();

        islaiduKategorijaPasirinkimas();
        String kategorijastringis = sk.next().toUpperCase();
        while (!katisliv.contains(kategorijastringis)) {
            System.out.println("Kategorija įvesta neteisingai");
            islaiduKategorijaPasirinkimas();
            kategorijastringis = sk.next().toUpperCase();
        }
        String kategorijastringisenum = kategorijastringis.toLowerCase();
        KategorijaIsl kategorijais = KategorijaIsl.valueOf(kategorijastringisenum);
        System.out.println("Pasirinkta kategorija:" + kategorijais.getIslpavadinimas());

        atsiskaitimasPasirinkimas();
        String atsiskaitimasstringis = sk.next().toUpperCase();
        while (!atsiskiv.contains(atsiskaitimasstringis)) {
            System.out.println("Atsiskaitimas įvestas neteisingai");
            atsiskaitimasPasirinkimas();
            atsiskaitimasstringis = sk.next().toUpperCase();
        }
        String atsiskaitimasstringisenum =  atsiskaitimasstringis.toLowerCase();
        Atsiskaitimas atsiskaitimasis = Atsiskaitimas.valueOf(atsiskaitimasstringisenum);
        System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
        String komentarasis = sk.next();
        while (komentarasis.length() >= 10) {
            System.out.println("Komentaras per ilgas");
            System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
            komentarasis = sk.next();
        }
        return new Islaiduirasas(sumais, kategorijais.getIslpavadinimas(), atsiskaitimasis.getPav(), komentarasis);

    }
    public  static void pridetiPajamuIrasas(ArrayList<PajamuIrasas> pajamas){ // metodas įtraukia sukurtas pajamas į Arrylist
        pajamas.add(makePajamas());
        System.out.println("Pajamas įtrauktos");

    }
    public  static void pridetiIslaiduIrasas(ArrayList<Islaiduirasas> islaidos){ // metodas įtraukia sukurtas išlaidas į Arrylist
        islaidos.add(makeIslaidas());
        System.out.println("Išlaidos įtrauktos");

    }
    public static void istrintiPajamas(ArrayList<PajamuIrasas> pajamas) { //metodas naudojamas norint vartotojui ištrinti pajamas iš sukurto sąrašo
        gautiPajamuIrasas(pajamas);
        System.out.println("Psirinkite pajamų id Nr. kuri norite pašalinti");
        int id = sk.nextInt();
        for (int i = 0; i < pajamas.size(); i++) {
            if (pajamas.get(i).getPajId() == id) {
                pajamas.remove(i);
                System.out.println("Pajamas su " + i + " id ištrintos");
                return;
            }
        }
        System.out.println("Įvestas pajamų id nerastas");
    }
    public static void istrintiIslaidas(ArrayList<Islaiduirasas> islaidas) { //metodas naudojamas norint vartotojui ištrinti išlaidas iš sukurto sąrašo
        gautiIslauIrasas(islaidas);
        System.out.println("Psirinkite išlaidų id Nr. kuri norite pašalinti");
        int id = sk.nextInt();
        for (int i = 0; i < islaidas.size(); i++) {
            if (islaidas.get(i).getIslId() == id) {
                islaidas.remove(i);
                System.out.println("Išlaidos su" + i + "id ištrintos");
                return;
            }
        }
        System.out.println("Įvestos išlaidos id nerastas");
    }

    public static double pajamassuma(ArrayList<PajamuIrasas> pajamas) { // metodas apskaičiuoja bendrą pajamų sumą.
        double pajambalansas = 0;
        for (PajamuIrasas elenentaipaj : pajamas) {
            for (int i = 0; i < 1; i++) {
                pajambalansas += elenentaipaj.getSumaPaj();
            }
        }
        System.out.println("Visu pajamų suma " + pajambalansas+"Eur");
        return pajambalansas;
    }
    public static double islaidsuma(ArrayList<Islaiduirasas> islaidas) { // metodas apskaičiuoja bendrą išlaidų sumą.
        double islbalansas = 0;
        for (Islaiduirasas elementaiis : islaidas) {
            for (int i = 0; i < 1; i++) {
                islbalansas += elementaiis.getSumaIsl();
            }
        }
        System.out.println("Visu islaidu suma " + islbalansas+"Eur");
        return islbalansas;
    }
    public static double balansas(ArrayList<PajamuIrasas> pajamas,ArrayList<Islaiduirasas> islaidas ) { // metodas skaičiuoja bendra pajamų išlaidų balansą
        double balansassum;
        balansassum = pajamassuma(pajamas) - islaidsuma(islaidas);
        System.out.println("Balansas: " + balansassum +" Eur");
        return balansassum;
    }

    public static void gautiPajamuIrasas (ArrayList<PajamuIrasas> pajamas){ // metodas spausdinti pajamų įvestą informaciją
        if(pajamas.isEmpty()){
            System.out.println("Nera įvestu vartotoju");
            return;
        }
        for (PajamuIrasas pajam : pajamas){
            System.out.println(pajam);
        }
    }

    public static void gautiIslauIrasas(ArrayList<Islaiduirasas> islaidos){ // metodas spausdinti išlaidų įvestą informaciją
        if(islaidos.isEmpty()){
            System.out.println("Nera įvestu vartotoju");
            return;
        }
        for (Islaiduirasas isld : islaidos){
            System.out.println(isld);
        }
    }
}




















