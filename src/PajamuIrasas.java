import java.util.Objects;

class PajamuIrasas extends Irasas {

    private  String kategorijaPaj;

    public PajamuIrasas (double suma, String kategorijaPaj, String atsiskaitimas, String papildomaInfo) {
        super(suma, atsiskaitimas, papildomaInfo);
        this.kategorijaPaj = kategorijaPaj;

    }

    public String getKategorijaPaj(){ return kategorijaPaj;}


    public void setKategorijaPaj(String kategorijaPaj){
        this.kategorijaPaj = kategorijaPaj;
    }

    @Override
    public String toString(){
        return String.format("""
                        Pajamas: kategorija: %s, %s 
                        """,kategorijaPaj, super.toString());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PajamuIrasas that = (PajamuIrasas) o;
        return Objects.equals(kategorijaPaj, that.kategorijaPaj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kategorijaPaj);
    }
}


