package avanzato.gestioneOrdini;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> ordini = new ArrayList<>();

    public void creaOrdine(LocalDate dataOrdine){
        Order nuovoOrdine = new Order(dataOrdine);

        ordini.add(nuovoOrdine);
        System.out.println("Ordine creato con successo");
    }

    public void visualizzaOrdini() {
        if (ordini.isEmpty()) {
            System.out.println("Nessun ordine disponibile.");
        } else {
            for(Order ordine : ordini){
                System.out.println(ordine); //stampa i dettagli di ogni ordine
            }
        }
    }

}
