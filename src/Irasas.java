import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Irasas {
    private static int Count = 0;
    private final int ID;
    private double suma;
    private final LocalDateTime time;

    private String atsiskaitimas;

    private String papildomaInfo;

    public Irasas(double suma, String atsiskaitimas, String papildomaInfo) {
        this.ID = Count++;
        this.suma = suma;
        this.time = LocalDateTime.now();

        this.atsiskaitimas = atsiskaitimas;
        this.papildomaInfo = papildomaInfo;
    }

    public static int getCount() {
        return Count;
    }
    public int getID() {
        return ID;
    }

    public double getSuma() {
        return suma;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getAtsiskaitimas() {
        return atsiskaitimas;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setAtsiskaitimas(String atsiskaitimas){
        this.atsiskaitimas = atsiskaitimas;
    }
    public void setPapildomaInfo(String papildomaInfo){
        this.papildomaInfo = papildomaInfo;
    }

    public String toString(){
        return String.format("""
                 ID: %d ,
                 Suma: %.2f Eur,
                 Atsiskaitimas: %s,
                 Papildoma informacija: %s,
                 Ivedimo laikas: %s""".replaceAll("\n", ""),
                ID, suma, atsiskaitimas, papildomaInfo, time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Irasas irasas = (Irasas) o;
        return ID == irasas.ID && Double.compare(irasas.suma, suma) == 0 && time.equals(irasas.time) && atsiskaitimas.equals(irasas.atsiskaitimas) && papildomaInfo.equals(irasas.papildomaInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, suma, time, atsiskaitimas, papildomaInfo);
    }
}



