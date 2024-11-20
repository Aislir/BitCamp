package avanzato.gestioneOrdini;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Order {

    //contatore ordini per fornire id unici
    private static int contatoreId = 1;

    private int idOrdine;
    private LocalDate dataOrdine;
    private LocalDate dataDiSpedizione;
    private LocalDate dataConsegna;

    public Order(LocalDate dataOrdine){
        this.idOrdine = contatoreId++;
        this.dataOrdine = dataOrdine;
        this.dataDiSpedizione = calcolaDataSpedizione(dataOrdine);
        this.dataConsegna = calcolaDataConsegna(dataDiSpedizione);
    }

    //Metodi personalizzati

    //metodo per il calcolo della spedizione
    private LocalDate calcolaDataSpedizione(LocalDate dataOrdine){
        return dataOrdine.plusDays(2); //spedizione avviene 2 giorni dopo l'ordine
    }
    //metodo per il calcolo della consegna
    private LocalDate calcolaDataConsegna(LocalDate dataDiSpedizione){
        return dataConsegna.plusDays(3); //consegna avviene 3 giorni dalla spedizione
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public LocalDate getDataOrdine(){
        return dataOrdine;
    }

    public LocalDate getDataDiSpedizione(){
        return dataDiSpedizione;
    }

    public LocalDate getDataConsegna(){
        return dataConsegna;
    }

}
