package crud;

import java.sql.*; //importiamo la libreria per poter utilizzare SQL

public class SQLInserimento {
    public static void main(String[] args) {

        //Dati del DB a cui ci vogliamo connettere
        String url = "jdbc:mysql://localhost/scuola";
        String username = "root";
        String password = "0104";

        //Proviamo ad accedere al database
        try{
            //Connection e' una delle classi della libreria sql che abbiamo importato
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione al database avvenuta con successo.");

            //Inserimento nuovo studente
            String nomeNuovoStudente = "Mario";
            String cognomeNuovoStudente = "Rossi";
            int etaNuovoStudente = 30;

            //preparazione query di inserimento //NB: i punti interrogativi sono dei placeholders
            //in cui in seguito inseriremo i valori effettivi
            String querySQLInserimento = "INSERT INTO studenti(nome, cognome, eta) VALUES ( ?, ?, ?)";

            //libreria per valorizzare i placeholder per gestire le
            //query parametriche (query che richiedono passaggio di dati)
            PreparedStatement pstmt = connection.prepareStatement(querySQLInserimento);

            //valorizzazione dei placeholder
            pstmt.setString(1, nomeNuovoStudente);
            pstmt.setString(2, cognomeNuovoStudente);
            pstmt.setInt(3, etaNuovoStudente);

            //invio della query al database //l'int ci e' utile per capire quanti record sono stati aggiunti
            int recordInseriti = pstmt.executeUpdate();
            System.out.println("Record aggiunto con successo. Righe inserite: "+recordInseriti);


        }catch (SQLException e){
            //specifichiamo il tipo di errore che potrebbe esserci
            System.out.println("Errore nella connessione al database.");
            //Stampa l'errore
            e.printStackTrace();


        }

    }
}
