package it.learningHibernate;

import model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FermataDAO fermataDAO = new FermataDAO();
        BigliettoDAO bigliettoDAO = new BigliettoDAO();

        while(true){

            System.out.println("Inizio Prova");
            System.out.println("Menu:");
            System.out.println("1. Aggiungi biglietto");
            System.out.println("2. Aggiungi fermata");
            System.out.println("3. Modifica luogo biglietto");

            int scelta = scanner.nextInt();

            switch (scelta){
                case 1:
                    System.out.println();
                    System.out.print("Inserisci codice biglietto: ");
                    String codice = scanner.next();
                    scanner.nextLine();
                    /*
                    System.out.println("Inserisci orario nel formato YYYY-MM-DD HH:MM:SS : ");
                    String orario = scanner.nextLine();
                    LocalDateTime data = stringToLocalDateTime(orario);
                    Biglietto biglietto = new Biglietto(codice, data);
                     */
                    Tipo tipo = Tipo.ARRIVO;
                    Biglietto biglietto = new Biglietto(codice, tipo);
                    bigliettoDAO.addBiglietto(biglietto);
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Inserisci luogo stazione: ");
                    String luogo = scanner.next();
                    Fermata fermata = new Fermata(luogo);
                    fermataDAO.addFermata(fermata);
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Inserisci Id biglietto: ");
                    int id = scanner.nextInt();
                    biglietto = bigliettoDAO.getBigliettoById(id);
                    System.out.println("Inserisci Id fermata: ");
                    int idFermata = scanner.nextInt();
                    //bigliettoDAO.setLuogoBiglietto(biglietto, idFermata);
                    break;
            }

        }

    }

    public static LocalDateTime stringToLocalDateTime(String string){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(string, formatter);
    }

}