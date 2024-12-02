package crud;

import java.sql.*;

public class SQLVisualizzazione {
    public static void main(String[] args) {

        //Dati nostro DB per connessione
        String url = "jdbc:mysql://localhost/scuola";
        String username = "root";
        String password = "0104";

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione al database avvenuta con successo");

            //query di estrazione
            Statement stmt = connection.createStatement();
            //catturiamo i record presenti nella tabella
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM studenti");
            //stampa ed iterazione sui risultati della query
            while(resultSet.next()){ //ritorna true fintanto che ci sono record in tabella su cui iterare
                int id = resultSet.getInt("id"); //tra parentesi o l'indice della colonna della
                //tabella (partendo da 0, o il nome del campo come stringa
                String nome = resultSet.getString("nome");
                String cognome = resultSet.getString("cognome");
                int eta = resultSet.getInt("eta");

                //stampa del singolo record ad ogni loop
                System.out.println("ID: " + id + " - Nome: "+nome+" - Cognome: "+cognome+" - Eta': "+eta);


            }
            //chiudere la connessione al DB
            resultSet.close();
            stmt.close();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Non e' stato possibile connettersi al database.");
        }
    }
}
