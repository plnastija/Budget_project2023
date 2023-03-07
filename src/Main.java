import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biudzetas b1 = new Biudzetas();

        Scanner in = new Scanner(System.in);
        int pasirinkimas;
        boolean runnig = true;
        while (runnig){
            System.out.println("""
                  [1] - Įvesti pajamas
                  [2] - Įvesti išlaidas
                  [3] - Atspausdinti pajamas
                  [4] - Atspausdinti išlaidas
                  [5] - Ištrinti pajamas
                  [6] - Ištrinti išlaidas
                  [7] - Balansas
                  [8] - Baigti programa
                  Iveskite pasirinkta Nr.:\s""");
            pasirinkimas = in.nextInt();

            switch (pasirinkimas){
                case 1 -> Biudzetas.pridetiPajamuIrasas(b1.pajamas);
                case 2 -> Biudzetas.pridetiIslaiduIrasas(b1.islaidos);
                case 3 -> Biudzetas.gautiPajamuIrasas(b1.pajamas);
                case 4 -> Biudzetas.gautiIslauIrasas(b1.islaidos);
                case 5 -> Biudzetas.istrintiPajamas(b1.pajamas);
                case 6 -> Biudzetas.istrintiIslaidas(b1.islaidos);
                case 7 -> Biudzetas.balansas(b1.pajamas,b1.islaidos);
                case 8 -> runnig = false;
                default -> System.out.println("Blogas pasirinkimas");
            }
        }
        System.out.println("Programa baigia darba");
        in.close();
    }
}
