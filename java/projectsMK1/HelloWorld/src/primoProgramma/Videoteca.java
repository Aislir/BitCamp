package primoProgramma;

public class Videoteca {

    public static void main(String[] args) {

        //dichiarazione variabili
        byte filmDisponibili = 10;
        byte filmInPrestito = 2;
        boolean tesseraValida = true;
        String titoloFilm = "Pirati dei Caraibi";

        //operazioni matematiche per definire un secondo giro di variabili
        int filmTotali = filmDisponibili + filmInPrestito;
        double prezzoNoleggio = 3.50*1.22; //prezzo con IVA al 22%

        //variabili booleane utili alla gestione logica del programma
        boolean disponibile = filmDisponibili > 0;
        boolean inPrestito = filmInPrestito > 0;
        boolean abbonamentoPagato = tesseraValida == true;
        boolean filmRichiesto = titoloFilm.equals("Pirati dei Caraibi"); //ritorna true
        //equals e' necessario per il confronto di Stringhe in Java dato che non sono
        //un tipo di dato ma oggetti (array di caratteri)

        System.out.println(filmRichiesto);

        //corpo relativo alla logica
        if (disponibile && abbonamentoPagato){
            System.out.println("Puoi noleggiare il film.");
        } else if(!disponibile){
            System.out.println("Ci dispiace. Al momento non ci sono film disponibili");
        } else {
            System.out.print("Nessun abbonamento attivo");
        }

        switch (titoloFilm){
            case "Pirati dei Caraibi":
                System.out.println("Il film richiesto e' Pirati dei Caraibi");
                break;
            case "Star Wars":
                System.out.println("Il film richiesto e' Star Wars");
                break;
            default:
                System.out.println("Il film richiesto non e' disponibile.");
        }

        //stampa riepilogo variabili logica
        System.out.println();
        System.out.println("Film disponibili: "+filmDisponibili);
        System.out.println("film in prestito: "+filmInPrestito);
        System.out.println("Film totali: "+filmTotali);
        System.out.println("Prezzo noleggio: " +prezzoNoleggio);
        System.out.println("Il film e' disponibile: "+disponibile);
        System.out.println("Il film e' in prestito: "+inPrestito);
        System.out.println("L'abbonamento e' pagato: "+abbonamentoPagato);
        System.out.println("Il film richiesto e' disponibile: "+filmRichiesto);
    }
}
