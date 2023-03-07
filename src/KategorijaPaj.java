public enum KategorijaPaj {
    a001 ("Akumuliatorius100"),
    a002 ("Akumuliatorius200"),
    d1 ("judesio daviklis"),
    mk1 ("Lipnus magnetinis kontaktas"),
    sr1 ("Sirena MR300RL"),
    mon ("Montavimo darbas"),
    pr("Projektavimas");


    private  String pajPavadinimas;
    KategorijaPaj ( String pajPavadinimass ) {
        this.pajPavadinimas = pajPavadinimass;
    }

    public String getPajPavadinimas(){

        return pajPavadinimas;
    }

}
