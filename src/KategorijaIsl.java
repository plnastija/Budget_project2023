public enum KategorijaIsl {
    tr ("pristatimas"),
    a001sav ("Akumuliatorius100 savikaina"),
    a002sav ("Akumuliatorius200 savikaina"),
    d1sav ("judesio daviklis savikaina"),
    mk1sav ("Lipnus magnetinis kontaktas savikaina"),
    sr1sav ("Sirena MR300RL savikaina"),
    sub ("Subranga darbas");


    private  String islpavadinimas;
    KategorijaIsl ( String islpavadinimas ){

        this.islpavadinimas = islpavadinimas;
    }
    public String getIslpavadinimas(){
        return islpavadinimas;
    }

}






