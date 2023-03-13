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
                  [1] - Įvesti įrašą
                  [2] - Atspausdinti bendrą sąrašą
                  [3] - Ištrinti įrašą
                  [4] - Balansas
                  [5] - Atspausdinti pajamas
                  [6] - Atspausdinti išlaidas
                  [7] - Pakeisti įrašą
                  [8] - Baigti programa
                  Iveskite pasirinkta Nr.:\s""");
            pasirinkimas = in.nextInt();

            switch (pasirinkimas){
                case 1 -> Biudzetas.pridetiIrasas(b1.irasas);
                case 2 -> Biudzetas.gautiPajIsl(b1.irasas);
                case 3 -> Biudzetas.istrintiIrasa(b1.irasas);
                case 4 -> Biudzetas.balansas(b1.irasas);
                case 5 -> Biudzetas.gautipaj(b1.irasas);
                case 6 -> Biudzetas.gautiIsl(b1.irasas);
                case 7 -> Biudzetas.changeIrasas(b1.irasas);
                case 8 -> runnig = false;
                default -> System.out.println("Blogas pasirinkimas");
            }
        }
        System.out.println("Programa baigia darba");
        in.close();
    }
}
