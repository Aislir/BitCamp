package gestioneDate;

import java.time.*;
import java.time.format.DateTimeFormatter; //per gestire la formattazione delle date
import java.time.temporal.ChronoUnit; //per fare calcoli sulle date
import java.util.Scanner;

public class ClassFusiOrari {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2023, 7, 22, 14, 30, 15, 0, ZoneId.of("Europe/Rome"));
        System.out.println("Data e ora con fuso orario: "+zonedDateTime);


        ZonedDateTime adesso = zonedDateTime.now();
        System.out.println("Oggi: "+adesso);

        ZonedDateTime newYorkTime = adesso.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Data e ora corrente a New York: "+newYorkTime);

        ZonedDateTime tokyoTime = adesso.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println("Data e ora corrente a Tokyo: "+tokyoTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");
        System.out.println("");
    }
}
