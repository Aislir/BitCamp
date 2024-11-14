package avanzato;

public class TestStudente {

    public static void main(String[] args) {

        Studente s1 = new Studente("Riccardo", "Rossi", 1234);
        s1.assegnaVoto(0, 10);
        s1.assegnaVoto(1, 8);
        s1.assegnaVoto(2, 9);
        s1.assegnaVoto(3, 10);
        s1.assegnaVoto(4, 9);

        double media = s1.mediaVoti();
        System.out.println("La media voti di "+s1.getNome()+ " " +s1.getCognome() +" e' " +media);
    }
}
