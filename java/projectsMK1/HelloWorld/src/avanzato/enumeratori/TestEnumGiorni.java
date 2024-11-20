package avanzato.enumeratori;

public class TestEnumGiorni {

    public static void main(String[] args) {

        GiorniSettimana oggi = GiorniSettimana.MARTEDI;
        System.out.println("Oggi e': "+oggi);

        for(GiorniSettimana giorno : GiorniSettimana.values()){
            System.out.println(giorno + " e' il giorno: " + (giorno.ordinal() + 1) + " della settimana");
        }
    }
}
