public enum Atsiskaitimas {
    a1("Grynais"),
    a2("BankoKortele"),
    a3("KlientoKortele");
    private  String pav;
    Atsiskaitimas ( String pav ){

        this.pav = pav;
    }
    public String getPav(){

        return pav;
    }

}

