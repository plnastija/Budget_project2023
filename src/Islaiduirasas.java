import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Islaiduirasas {
    private double sumaIsl;
    private final LocalDateTime  timeIsl;
    private String kategorijaIsl;
    private String atsiskaitimasIsl;
    private String papildomaIsl;

    public Islaiduirasas (double sumaIsl,  String kategorijaIsl, String atsiskaitimas, String papildomaIsl){
        this.sumaIsl = sumaIsl;
        this. timeIsl =  LocalDateTime.now();
        this. kategorijaIsl = kategorijaIsl;
        this.atsiskaitimasIsl = atsiskaitimas;
        this. papildomaIsl = papildomaIsl;
    }


    public double getSumaIsl(){
        return sumaIsl;
    }
    public LocalDateTime getTimeIsl() {
        return timeIsl;
    }

    public  String getKategorijaIsl(){ return kategorijaIsl;}
    public String getAtsiskaitimas(){return atsiskaitimasIsl;}
    public String getPapildomaInfoIsl(){
        return papildomaIsl;
    }

    public  double setSumaIsl(double sumaIsl) {
        this.sumaIsl = sumaIsl;
        return sumaIsl;
    }

    public void setKategorijaIsl(String kategorijaIsl){
        this.kategorijaIsl = kategorijaIsl;
    }
    public void setAtsiskaitimas(String atsiskaitimas){
        this.atsiskaitimasIsl = atsiskaitimas;
    }
    public  void setPapildomaInfoIsl(String papildomaIsl){
        this.papildomaIsl = papildomaIsl;

    }
    @Override
    public String toString(){
        return String.format("""
                 Islaidu suma: %.2f Eur|
                 Islaidu kategorija %s|
                 Islaidu atsiskaitimas %s|
                 Islaidu informacija %s|
                 islaidu laikas %s""", sumaIsl, kategorijaIsl,atsiskaitimasIsl,papildomaIsl, timeIsl.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}
