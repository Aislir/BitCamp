package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLEliminazione {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/scuola";
        String username = "root";
        String password = "1234";

        //connessione al DB
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione avvenuta con successo");

            //definiamo record da eliminare
            int idStudenteDaEliminare = 1;

            //query per eliminare
            String sqlEliminazione = "DELETE FROM studenti WHERE id = ?";

            //creazione query parametrica di jdbc
            PreparedStatement pstmtEliminazione = connection.prepareStatement(sqlEliminazione);

            //valorizzazione placeholder
            pstmtEliminazione.setInt(1, idStudenteDaEliminare);

            //eseguiamo la query
            int righeEliminate = pstmtEliminazione.executeUpdate();
            if (righeEliminate == 0){
                System.out.println("Nessun record eliminato");
            } else {
                System.out.println("Eliminazione del record avvenuta con successo");
            }

            pstmtEliminazione.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Non e' stato possibile connettersi al database.");
        }
    }
}
