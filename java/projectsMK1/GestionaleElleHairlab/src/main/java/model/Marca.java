package model;

public enum Marca {
    NULL(""),
    OREAL("L'Oreal"),
    ALTEREGO("Alterego"),
    GHD("GHD"),
    DAVINES("Davines"),
    MATRIX("Matrix");

    private final String[] descrizione;

    public static Marca getMarca(String tipo) {
        return Marca.valueOf(tipo.toUpperCase());
    }

    public String[] getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return this.descrizione[0];
    }

    Marca(String descrizione) {this.descrizione = new String[]{descrizione};}
}
