import java.util.Scanner;

public class Biudzetas {

    PajamuIrasas[] pajamas = new PajamuIrasas[100];
    Islaiduirasas[] islaidos = new Islaiduirasas[100];
    int i = 0;
    static Scanner sk = new Scanner(System.in);
    public static int pridetiPajamuIrasas(PajamuIrasas[] pajamas, int i) {
        if (i >= 100) {
            System.out.println("Nebegalima daugiau itraukti elementu!");
            return 0;
        }
        System.out.println("Iveskite pajamu suma (PVZ 20,05):");
        double sumap = sk.nextDouble();


        System.out.println("Iveskite pajamu kategorija (iveskite tik koda kuris skliausteliuose):");
        System.out.printf("""
                        // Pasirinkite is saraso: 
                        * (%s) Akumuliatorius100 
                        * (%s) Akumuliatorius200 
                        * (%s) judesio daviklis
                        * (%s) Lipnus magnetinis kontaktas
                        * (%s) Sirena MR300RL
                        * (%s) Montavimo darbas
                        * (%s) Projektavimas \n""", KategorijaPaj.a001, KategorijaPaj.a002,
                KategorijaPaj.d1, KategorijaPaj.mk1, KategorijaPaj.mon,KategorijaPaj.sr1,KategorijaPaj.pr);
        String kategorijastring = sk.next();
        KategorijaPaj kategorijap = KategorijaPaj.valueOf(kategorijastring);
        System.out.println("Pasirinkta kategorija :"+ kategorijap.getPajPavadinimas());
        System.out.println("Iveskite pajamu atsiskaitimo buda:");
        System.out.printf("""
                        // (iveskite tik koda kuris skliausteliuose): 
                        *  (%s) Grynais
                        *  (%s) Banko kortele
                        *  (%s) Kliento kortele
                        \n""", Atsiskaitimas.a1, Atsiskaitimas.a2, Atsiskaitimas.a3);
        String atsiskaitimasstring = sk.next();
        Atsiskaitimas atsiskaitimasp = Atsiskaitimas.valueOf(atsiskaitimasstring);
        System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
        String komentarasp = sk.next();
        while (komentarasp.length() >=10){
            System.out.println("Komentaras per ilgas");
            System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
            komentarasp = sk.next();
        }
        pajamas[i] = new PajamuIrasas(sumap, kategorijap.getPajPavadinimas(), atsiskaitimasp.getPav(), komentarasp);
        return 1;
    }

    public static int pridetiIslaiduIrasas(Islaiduirasas[] islaidos, int i) {
        if (i >= 100) {
            System.out.println("Nebegalima daugiau itraukti elementu!");
            return 0;
        }
        System.out.println("Iveskite islaidu suma (PVZ 18,03):");
        double sumais = sk.nextDouble();


        System.out.println("Iveskite islaidu kategorija (iveskite tik koda kuris skliausteliuose):");
        System.out.printf("""
                        // Pasirinkite is saraso: 
                        * (%s) Akumuliatorius100 savikaina 
                        * (%s) Akumuliatorius200 savikaina 
                        * (%s) Pristatimas
                        * (%s) Judesio daviklis savikaina
                        * (%s) Lipnus magnetinis kontaktas savikaina
                        * (%s) Sirena MR300RL savikaina
                        * (%s) Subranga darbas\n""", KategorijaIsl.a002sav, KategorijaIsl.a001sav,
                KategorijaIsl.tr,KategorijaIsl.d1sav, KategorijaIsl.mk1sav,KategorijaIsl.sr1sav,KategorijaIsl.sub);
        String kategorijastringis = sk.next();
        KategorijaIsl kategorijais = KategorijaIsl.valueOf(kategorijastringis);
        System.out.println("Pasirinkta kategorija:" + kategorijais.getIslpavadinimas());


        System.out.println("Iveskite islaidu atsiskaitimo buda:");
        System.out.printf("""
                        // (iveskite tik koda kuris skliausteliuose):: 
                        *  (%s) Grynais
                        *  (%s) Banko kortele
                        *  (%s) Kliento kortele
                        \n""", Atsiskaitimas.a1, Atsiskaitimas.a2, Atsiskaitimas.a3);
        String atsiskaitimasstringis = sk.next();
        Atsiskaitimas atsiskaitimasis = Atsiskaitimas.valueOf(atsiskaitimasstringis);
        System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
        String komentarasis = sk.next();
        while (komentarasis.length() >=10){
            System.out.println("Komentaras per ilgas");
            System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
            komentarasis = sk.next();
        }
        islaidos[i] = new Islaiduirasas(sumais, kategorijais.getIslpavadinimas(), atsiskaitimasis.getPav(), komentarasis);
        return 1;
    }
    public static void gautiPajamuIrasas (PajamuIrasas[]pajamas,int i){
        System.out.println(pajamas[i]);
    }
    public static void gautiIslauIrasas ( Islaiduirasas[] islaidos,int i){
        System.out.println(islaidos[i]);
    }
}




















