import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biudzetas b1 = new Biudzetas();

        Scanner in = new Scanner(System.in);
        int i = 0;
        int pasirinkimas;
        boolean runnig = true;
        while (runnig){
            System.out.println("""
                  [1] - ivesti pajamas
                  [2] - ivesti išlaidas
                  [3] - atspausdinti pajamas
                  [4] - atspausdinti islaidas
                  [5] - baigti programa
                  Iveskite pasirinkta Nr.:\s""");
            pasirinkimas = in.nextInt();

            Object pridetiPajamuIrasas;
            switch (pasirinkimas){
                case 1 -> Biudzetas.pridetiPajamuIrasas(b1.pajamas, i);
                case 2 -> Biudzetas.pridetiIslaiduIrasas(b1.islaidos, i);
                case 3 -> Biudzetas.gautiPajamuIrasas(b1.pajamas, i);
                case 4 -> Biudzetas.gautiIslauIrasas(b1.islaidos, i);
                case 5 -> runnig = false;
                default -> System.out.println("Blogas pasirinkimas");
            }
        }
        System.out.println("Programa baigia darba");
        in.close();

    }

}
