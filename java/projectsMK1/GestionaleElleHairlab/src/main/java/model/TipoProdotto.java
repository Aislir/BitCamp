package model;



public enum TipoProdotto {
    NULL(""),
    SHAMPOO("Shampoo"),
    OLIO("Olio"),
    CREMA("Crema"),
    SCHIUMA("Schiuma");

    private final String[] descrizione;

    public static TipoProdotto getTipoProdotto(String tipo) {
        return TipoProdotto.valueOf(tipo.toUpperCase());
    }

    public String[] getDescrizione() {
        return descrizione;
    }

    @Override
            public String toString() {
        return this.descrizione[0];
    }

    TipoProdotto(String descrizione) {this.descrizione = new String[]{descrizione};}
}
