import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

class Islaiduirasas extends Irasas {

    private String kategorijaIsl;

    public Islaiduirasas (double suma, String kategorijaIsl, String atsiskaitimas, String papildomaInfo){
        super(suma, atsiskaitimas, papildomaInfo);
        this. kategorijaIsl = kategorijaIsl;

    }
    public  String getKategorijaIsl(){ return kategorijaIsl;}

    public void setKategorijaIsl(String kategorijaIsl){
        this.kategorijaIsl = kategorijaIsl;
    }

    @Override
    public String toString(){
        return String.format("""
                        Išlaidos: kategorija: %s, %s 
                        """,kategorijaIsl, super.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Islaiduirasas that = (Islaiduirasas) o;
        return Objects.equals(kategorijaIsl, that.kategorijaIsl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kategorijaIsl);
    }
}
