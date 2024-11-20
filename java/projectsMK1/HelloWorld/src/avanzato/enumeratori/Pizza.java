package avanzato.enumeratori;

public enum Pizza {
    MARGHERITA("pomodoro", "mozzarella"),
    MARINARA("pomodoro", "aglio", "origano"),
    QUATTRO_STAGIONI("pomodoro", "mozzarella", "funghi", "carciofi", "prosciutto cotto"),
    FOCACCIA("olio", "sale", "pepe");

    //definire il tipo dato dell'argomento dell'enumeratore
    private final String[] ingredienti;

    //costruttore dell'enum
    Pizza(String...ingredienti){
        this.ingredienti = ingredienti;
    }

    public String[] getIngredienti() {
        return ingredienti;
    }
}
