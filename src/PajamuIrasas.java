import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class PajamuIrasas {
    private  double sumaPaj;
    private final LocalDateTime timePaj;
    private  String kategorijaPaj;
    private  String atsiskaitimasPaj;

    private String papildomaInfoPaj;

    public PajamuIrasas (double sumaPaj,  String kategorijaPaj, String atsiskaitimas, String papildomaInfoPaj) {
        this.sumaPaj = sumaPaj;
        this. timePaj = LocalDateTime.now();
        this.kategorijaPaj = kategorijaPaj;
        this.atsiskaitimasPaj = atsiskaitimas;
        this.papildomaInfoPaj = papildomaInfoPaj;


    }
    public double getSumaPaj(){
        return sumaPaj;
    }
    public LocalDateTime getTimePaj(){
        return timePaj;
    }
    public String getKategorijaPaj(){ return kategorijaPaj;}
    public String getAtsiskaitimas() {return atsiskaitimasPaj;}
    public String getPapildomaInfoPaj(){
        return papildomaInfoPaj;
    }

    public  double setSumaPaj(double sumaPaj) {
        this.sumaPaj = sumaPaj;
        return sumaPaj;
    }
    public void setKategorijaPaj(String kategorijaPaj){
        this.kategorijaPaj = kategorijaPaj;
    }
    public void setAtsiskaitimas(String atsiskaitimas){
        this.atsiskaitimasPaj = atsiskaitimasPaj;
    }
    public void setPapildomaInfoPaj(String papildomaInfoPaj){
        this.papildomaInfoPaj = papildomaInfoPaj;
    }

    @Override
    public String toString(){
        return String.format("""
                 Pajamu suma: %.2f Eur|
                 Pajamu kategorija %s|
                 Pajamu atsiskaitimas %s|
                 Papildoma informacija %s|
                 Ivedimo laikas %s""", sumaPaj, kategorijaPaj,atsiskaitimasPaj,papildomaInfoPaj, timePaj.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}

