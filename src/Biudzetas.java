import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Biudzetas {
    static Scanner sk = new Scanner(System.in);

    ArrayList<Irasas> irasas = new ArrayList<>();

    static Set<String> katpajiv = Set.of("A001", "A002", "D1", "MK1", "MON", "SR1", "PR"); // sąrašas naudojamas tikrinimui, tikrina vartotojo įvestus parametrus su Enum reikšmė
    static Set<String> atsiskiv = Set.of("A1", "A2", "A3"); // sąrašas naudojamas tikrinimui, tikrina vartotojo įvestus parametrus su Enum reikšmė
    static Set<String> katisliv = Set.of("A001SAV", "A002SAV", "TR", "D1SAV", "MK1SAV", "SR1SAV", "SUB"); // sąrašas naudojamas tikrinimui, tikrina vartotojo įvestus parametrus su Enum reikšmė

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

    public static double makesuma() {
        System.out.println("Iveskite pajamu suma (PVZ 20,05):");
        double msuma = sk.nextDouble();
        return msuma;
    }

    public static KategorijaPaj makeKategorijaPaj() {
        pajamuKategorijaPasirinkimas();
        String kategorijastring = sk.next().toUpperCase();

        while (!katpajiv.contains(kategorijastring)) {
            System.out.println("Kategorija įvesta neteisingai");
            pajamuKategorijaPasirinkimas();
            kategorijastring = sk.next().toUpperCase();
        }
        String kategorijastringenum = kategorijastring.toLowerCase();
        KategorijaPaj kategorijap = KategorijaPaj.valueOf(kategorijastringenum);
        System.out.println("Pasirinkta kategorija :" + kategorijap.getPajPavadinimas());
        return kategorijap;
    }

    public static KategorijaIsl makeKategorijaIsl() {
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
        return kategorijais;
    }

    public static Atsiskaitimas makeAtsiskaitimas() {
        atsiskaitimasPasirinkimas();
        String atsiskaitimasstring = sk.next().toUpperCase();
        while (!atsiskiv.contains(atsiskaitimasstring)) {
            System.out.println("Atsiskaitimas įvestas neteisingai");
            atsiskaitimasPasirinkimas();
            atsiskaitimasstring = sk.next().toUpperCase();
        }
        String atsiskaitimasstringenum = atsiskaitimasstring.toLowerCase();
        Atsiskaitimas atsiskaitimasp = Atsiskaitimas.valueOf(atsiskaitimasstringenum);
        return atsiskaitimasp;
    }

    public static String makeKomentaras() {
        System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
        String komentarasp = sk.next();
        while (komentarasp.length() >= 10) {
            System.out.println("Komentaras per ilgas");
            System.out.println("Iveskite komentara ( komentaras negali buti ilgiasnis nei 10 raidz");
            komentarasp = sk.next();
        }
        return komentarasp;
    }

    public static PajamuIrasas makePajamas() { // metodas kuris priima parametrus(pajamas) iš vartotojo ir sukuria pajamų irašą (suma, kotegorija, apmokėjimo būdas, komentaras)
        double sumaP = makesuma();

        KategorijaPaj kategorijaP = makeKategorijaPaj();

        Atsiskaitimas atsiskaitimasP = makeAtsiskaitimas();

        String komentarijP = makeKomentaras();

        return new PajamuIrasas(sumaP, kategorijaP.getPajPavadinimas(), atsiskaitimasP.getPav(), komentarijP);
    }

    public static Islaiduirasas makeIslaidas() { // metodas kuris priima parametrus (islaidus) iš vartotojo ir ir sukuria išlaidų irašą(suma, kotegorija, apmokėjimo būdas, komentaras)
        double sumaIsl = makesuma();

        KategorijaIsl kategorijaI = makeKategorijaIsl();

        Atsiskaitimas atsiskaitimasI = makeAtsiskaitimas();

        String komentarijI = makeKomentaras();

        return new Islaiduirasas(sumaIsl, kategorijaI.getIslpavadinimas(), atsiskaitimasI.getPav(), komentarijI);
    }

    public static void pridetiIrasas(ArrayList<Irasas> irasas) {
        int num;
        boolean ivedimas = true;
        while (ivedimas) {
            System.out.println("""
                    Pasirinkite ką norite įvesti :
                    [1] - Įvesti pajamas
                    [2] - Įvesti išlaidas
                    [3] - Baigti įvedimus
                    Iveskite pasirinkta Nr.:\s""");
            num = sk.nextInt();
            switch (num) {
                case 1 -> irasas.add(makePajamas());
                case 2 -> irasas.add((makeIslaidas()));
                case 3 -> ivedimas = false;
                default -> System.out.println("Blogas pasirinkimas");
            }
        }
    }

    public static void gautiPajIsl(ArrayList<Irasas> irasas) {
        if (irasas.isEmpty()) {
            System.out.println("Nera įvestu vartotoju");
            return;
        }
        for (Irasas iras : irasas) {
            System.out.println(iras);
        }
    }

    public static void istrintiIrasa(ArrayList<Irasas> irasas) { //metodas naudojamas norint vartotojui ištrinti irašą iš bendro sarašo
        gautiPajIsl(irasas);
        System.out.println("Psirinkite pajamų/išlaidų id Nr. kuri norite pašalinti: ");
        int id = sk.nextInt();
        for (int i = 0; i < irasas.size(); i++) {
            if (irasas.get(i).getID() == id) {
                irasas.remove(i);
                System.out.println("Pajamas su " + i + " id ištrintos");
                return;
            }
        }
        System.out.println("Įvestas pajamų/išlaidų ID nerastas");
    }


    public static void changeIrasas(ArrayList<Irasas> irasas) {
        String choice;
        System.out.println("Psirinkite pajamų/išlaidų id Nr. kuri norite redaguoti: ");
        gautiPajIsl(irasas);
        int id = sk.nextInt();
        for (int i = 0; i < irasas.size(); i++) {
            if (irasas.get(i).getID() == id) {
                System.out.println("""
                        Ar norite keisti įrašo sumą?
                        Jeigu taip - paspauskyte : y
                        Jeigu ne - paspauskyte : n
                        """);
                choice = sk.next();
                if (choice.equalsIgnoreCase("y")) {
                    System.out.printf("Dabartinė suma yra: %f\n", irasas.get(id).getSuma());
                    double newSuma = makesuma();
                    irasas.get(id).setSuma(newSuma);
                    System.out.println("Įrašo suma sekmingai pakeista į: " + newSuma);
                }

                System.out.println("""
                        Ar norite keisti kategorija?
                        Jeigu taip - paspauskyte : y
                        Jeigu ne - paspauskyte : n
                        """);
                choice = sk.next();
                if (choice.equalsIgnoreCase("y")) {
                    // System.out.printf("Dabartinis atsiskaitimas yra: %s\n", ((PajamuIrasas) irasas.get(id)).getKategorijaPaj());
                    int numk;
                    System.out.println("""
                            Pasirinkite ką norite įvesti :
                            [1] - Įvesti pajamų kategorija
                            [2] - Įvesti išlaidų kategorija
                            Iveskite pasirinkta Nr.:\s""");
                    numk = sk.nextInt();
                    switch (numk) {
                        case 1 -> {
                            KategorijaPaj newKatPaj = makeKategorijaPaj();
                            String newKatPajString = String.valueOf(newKatPaj);
                            ((PajamuIrasas) irasas.get(id)).setKategorijaPaj(newKatPajString);
                            System.out.println("Kategorija sekmingai pakeista į: " + newKatPajString);
                        }
                        case 2 -> {
                            KategorijaIsl newkatIs = makeKategorijaIsl();
                            String newKatIsString = String.valueOf(newkatIs);
                            ((Islaiduirasas) irasas.get(id)).setKategorijaIsl(newKatIsString);
                            System.out.println("Kategorija sekmingai pakeista į: " + newKatIsString);
                        }
                        default -> System.out.println("Blogas pasirinkimas");
                    }

                    System.out.println("""
                            Ar norite keisti atsiskaitimą?
                            Jeigu taip - paspauskyte : y
                            Jeigu ne - paspauskyte : n
                            """);
                    choice = sk.next();
                    if (choice.equalsIgnoreCase("y")) {
                        System.out.printf("Dabartinis atsiskaitimas yra: %s\n", irasas.get(id).getAtsiskaitimas());
                        Atsiskaitimas newatsiskaitimas = makeAtsiskaitimas();
                        irasas.get(id).setAtsiskaitimas(String.valueOf(newatsiskaitimas));
                        System.out.println("Įrašas atsiskaitimas sekmingai pakeista į: " + newatsiskaitimas);
                    }
                    System.out.println("""
                            Ar norite keisti komentara?
                            Jeigu taip - paspauskyte : y
                            Jeigu ne - paspauskyte : n
                            """);
                    choice = sk.next();
                    if (choice.equalsIgnoreCase("y")) {
                        System.out.printf("Dabartinis komentaras yra: %s\n", irasas.get(id).getPapildomaInfo());
                        String newkomentar = makeKomentaras();
                        irasas.get(id).setPapildomaInfo(newkomentar);
                        System.out.println("Įrašas komentarij sekmingai pakeista į: " + newkomentar);

                    }

                } else {
                    System.out.println("Irašas su tokiu ID nerastas");
                }
            }
        }
    }
    public static void gautiPaj(ArrayList<Irasas> irasas) {
        int i;
        //(PajamuIrasas) irasas;

        for (i = 0; irasas.size() > i; i++){



            //System.out.println(irasas.get(i).);
            //if(((Islaiduirasas) irasas.get(i)).getKategorijaIsl().equals(KategorijaIsl.sub))
            //continue;
            for (Irasas elenentaipaj : irasas){
                System.out.println();

            }
            //if(katpajiv.equals(((PajamuIrasas) irasas.get(i)).getKategorijaPaj())){

            //  System.out.println(((PajamuIrasas) irasas.get(i)).getKategorijaPaj());

            //((PajamuIrasas) irasas.get()).getKategorijaPaj();
            // ((Islaiduirasas) irasas.get(i)).getKategorijaIsl();
        }


        //String a = ((PajamuIrasas) irasas.get(i)).getKategorijaPaj();
        //String x = ((Islaiduirasas) irasas.get(i)).getKategorijaIsl();

        //if ( (katpajiv.contains(a.toUpperCase()))&&(!katpajiv.contains(x.toUpperCase()))) {


    }
}

//}
            /*if (irasas.isEmpty()) {
                System.out.println("Nera įvestu vartotoju");
                return;
            }*/
//}
// }















