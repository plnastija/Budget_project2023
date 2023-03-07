import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class PajamuIrasas {
    private static int pajCount = 0;
    private final int pajId;
    private  double sumaPaj;
    private final LocalDateTime timePaj;
    private  String kategorijaPaj;
    private  String atsiskaitimasPaj;

    private String papildomaInfoPaj;

    public PajamuIrasas (double sumaPaj,  String kategorijaPaj, String atsiskaitimas, String papildomaInfoPaj) {
        this.pajId = pajCount++;
        this.sumaPaj = sumaPaj;
        this. timePaj = LocalDateTime.now();
        this.kategorijaPaj = kategorijaPaj;
        this.atsiskaitimasPaj = atsiskaitimas;
        this.papildomaInfoPaj = papildomaInfoPaj;
    }
    public static int getPajCount(){
        return pajCount;
    }

    public int getPajId() {
        return pajId;
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
                 Pajamų id: %d |
                 Pajamų suma: %.2f Eur|
                 Pajamų kategorija %s|
                 Pajamų atsiskaitimas %s|
                 Papildoma informacija %s|
                 Ivedimo laikas %s""".replaceAll("\n", " "),
                pajId, sumaPaj, kategorijaPaj,atsiskaitimasPaj,papildomaInfoPaj, timePaj.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}

