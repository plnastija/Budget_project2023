import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biudzetas b1 = new Biudzetas();


        Scanner in = new Scanner(System.in);
        int pasirinkimas;
        boolean runnig = true;
        while (runnig){
            System.out.println("""
                  
                  [3] - Atspausdinti pajamas (nesigauna)
                  
                  [5] - Prideti Pajamas/Islaidas
                  [6] - Ištrinti išlaidas
                  
                  [8] - Baigti programa
                  [9] - Gauti Pajamas/Islaidas
                  [10] - Pakeisti irasa
                  Iveskite pasirinkta Nr.:\s""");
            pasirinkimas = in.nextInt();

            switch (pasirinkimas){
                //case 1 -> Biudzetas.pridetiPajamuIrasas(b1.pajamas);
                //case 2 -> Biudzetas.pridetiIslaiduIrasas(b1.islaidos);
                case 3 -> Biudzetas.gautiPaj(b1.irasas);
                //case 4 -> Biudzetas.gautiIslauIrasas(b1.islaidos);
                case 5 -> Biudzetas.pridetiIrasas(b1.irasas);
                case 6 -> Biudzetas.istrintiIrasa(b1.irasas);
                // case 6 -> Biudzetas.istrintiIslaidas(b1.islaidos);
                // case 7 -> Biudzetas.balansas(b1.pajamas,b1.islaidos);
                case 9 -> Biudzetas.gautiPajIsl(b1.irasas);
                case 10 -> Biudzetas.changeIrasas(b1.irasas);
                case 8 -> runnig = false;
                default -> System.out.println("Blogas pasirinkimas");
            }
        }
        System.out.println("Programa baigia darba");
        in.close();
    }
}
