package gestioneDate;

import java.time.LocalDate;  //libreria per gestire le info sulle date
import java.time.format.DateTimeFormatter; //per gestire la formattazione delle date
import java.time.temporal.ChronoUnit; //per fare calcoli sulle date
import java.util.Scanner;

public class ClassData {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //assegnazione di una data ad una variabile
        LocalDate data = LocalDate.of(2024, 12, 25); //2024-12-25
        System.out.println("La data di Natale e': "+data);

        //data corrente
        LocalDate oggi = LocalDate.now();
        System.out.println("La data di oggi e': "+oggi);

        //data corrente + 7 giorni. "plus" prende 2 parametri: la quantita
        //da sommare e "cosa" (giorni, settimane, mesi, anni, secoli, secondi, minuti, ore, ecc...)
        LocalDate nuovaData = oggi.plus(7, ChronoUnit.DAYS);
        System.out.println("Data tra una settimana: "+nuovaData);

        //formattazione di una data in formato specifico
        //Comunichiamo in che formato vogliamo la data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //cio' che e' importante sono l'ordine in cui sono "dd", "MM" e "yyyy", non come sono divisi tra loro

        String dataFormattata = oggi.format(formatter);
        System.out.println("Data formattata: "+dataFormattata);

        //Parsing di una data (trasformazione da stringa a data su cui poter fare calcoli)
        String stringaData = "18/11/2024";
        LocalDate dataParsata = LocalDate.parse(stringaData, formatter);
        //L'oggetto formatter e' necessario per far comprendere al calcolatore qual e' il giorno e il mese
        System.out.println("Data parsata: "+dataParsata);
        String dataParsataItaliana = dataParsata.format(formatter);
        System.out.println("La data leggibile per noi e' invece: "+dataParsataItaliana);

        //aggiungo 5 giorni alla nostra data col nostro formato
        dataParsata = dataParsata.plus(5, ChronoUnit.DAYS); //dataParsata adesso e' nel formato standard
        System.out.println("La data a cui sono stati sommati 5 giorni in formato standard e': "+dataParsata);
        dataParsataItaliana = dataParsata.format(formatter);
        System.out.println("La data a cui sono stati sommati 5 giorni nel formato italiano e': "+dataParsataItaliana);

    }
}
