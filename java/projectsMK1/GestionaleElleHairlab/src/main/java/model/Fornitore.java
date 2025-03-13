package model;

public enum Fornitore {
    NULL(""),
    OREAL("L'Oreal"),
    DAVINES("Davines");

    private final String descrizione;
    Fornitore(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getDescrizione() {
        return descrizione;
    }
}
