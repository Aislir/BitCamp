package gestioneDate;

import java.time.LocalDate;  //libreria per gestire le info sulle date
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter; //per gestire la formattazione delle date
import java.time.temporal.ChronoUnit; //per fare calcoli sulle date
import java.util.Scanner;

public class ClassDataEOra {

    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2024, 11, 18, 12, 45, 00);
        System.out.println("Data e ora specifiche: "+dateTime);

        LocalDateTime adesso = LocalDateTime.now();
        System.out.println("Data e ora corrente: "+adesso);

        //settiamo il format con cui vogliamo visualizzate data e ora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String adessoFormattato = adesso.format(formatter);
        System.out.println("Data e ora formattata: "+adessoFormattato);

        //parsing di data e ora
        String inputData = "22/07/2023 14:30:15";
        LocalDateTime dataParsata = LocalDateTime.parse(inputData, formatter);
        System.out.println("La data e ora parsate sono: "+dataParsata);


    }
}
