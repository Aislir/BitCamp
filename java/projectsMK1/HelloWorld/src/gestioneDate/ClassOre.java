package gestioneDate;

import java.time.LocalDate;  //libreria per gestire le info sulle date
import java.time.LocalTime;
import java.time.format.DateTimeFormatter; //per gestire la formattazione delle date
import java.time.temporal.ChronoUnit; //per fare calcoli sulle date
import java.util.Scanner;

public class ClassOre {

    public static void main(String[] args) {
        //istanza di un oggetto con ora e minuti
        LocalTime ora = LocalTime.of(11, 30);
        //istanza di un oggetto con ore, minuti e secondi
        LocalTime ora2 = LocalTime.of(11, 30, 20);

        //NB: questa capacita' di avere metodi con parametri differenti e stesso nome e' detta "Overloading"

        //ora corrente
        LocalTime oraCorrente = LocalTime.now();
        System.out.println("Ora corrente: "+oraCorrente);

        //aggiunta tempo a ora corrente
        LocalTime oraModificata = oraCorrente.plus(45, ChronoUnit.MINUTES);
        System.out.println("L'ora corrente tra 45 minuti e': "+oraModificata);

    }



}
