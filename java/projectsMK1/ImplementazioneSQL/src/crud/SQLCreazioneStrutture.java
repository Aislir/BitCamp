package crud;

import java.sql.*;

public class SQLCreazioneStrutture {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/scuola";
        String username = "root";
        String password = "0104";

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione avvenuta con successo");

            //creazione stringa SQL per nuova tabella
            String sqlCreazioneTabella = "CREATE TABLE IF NOT EXISTS esami("
                                        +"id INT AUTO_INCREMENT PRIMARY KEY,"
                                        +"nome VARCHAR(50) NOT NULL,"
                                        +"voto INT NOT NULL"
                                        +")";

            //esecuzione query
            Statement stmtCreazioneTabella = connection.createStatement();
            stmtCreazioneTabella.executeUpdate(sqlCreazioneTabella);
            System.out.println("Nuova tabella creata con successo.");

            stmtCreazioneTabella.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Non e' stato possibile connettersi al database.");
        }
    }
}
