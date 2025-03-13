package model;

public enum TipoMovimento {
    NULL(""),
    ENTRATA("Entrata"),
    USCITA("Uscita");

    private final String descrizione;
    TipoMovimento(String descrizione) {
        this.descrizione = descrizione;
    }
    public String getDescrizione() {
        return descrizione;
    }
}
