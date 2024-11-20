package avanzato.gestioneOrdini;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OrderManager gestoreOrdini = new OrderManager();

        boolean uscita = false;

        while (!uscita){
            System.out.println("1. Crea Ordine");
            System.out.println("2. Visualizza Ordini");
            System.out.println("3. Esci");
            System.out.println("");
            System.out.print("Inserisci la tua scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta){
                case 1:
                    LocalDate dataOrdine = LocalDate.now();
                    gestoreOrdini.creaOrdine(dataOrdine); //creazione ordine con data corrente
                    break;
                case 2:
                    gestoreOrdini.visualizzaOrdini(); //stampa ordini presenti
                    break;
                case 3:
                    uscita = true;
                    break;
                default:
                    break;
            }
        }

    }
}
