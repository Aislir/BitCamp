package crud;

import java.sql.*;

public class SQLAggiornamento {
    public static void main(String[] args) {

        //jdbc e' l'interprete, mysql e' il programma utilizzato per il DB
        //localhost e' il nome della macchina su cui viene fatto girare il server
        //scuola e' il nome del DB
        String url = "jdbc:mysql://localhost/scuola";
        String username = "root";
        String password = "1234";

        //connessione al DB
        try{
            Connection connection = DriverManager.getConnection(url, username, password);

            int idStudenteDaAggiornare = 1;
            String nuovoNome = "Luigi";
            String nuovoCognome = "Verdi";
            int nuovaEta = 22;

            //I ? sono dei placeholders
            String sqlAggiornamento = "UPDATE studenti SET nome=?, cognome=?, eta=?, WHERE id=?";
            PreparedStatement pstmtAggiornamento = connection.prepareStatement(sqlAggiornamento);
            //valorizzazione dei placeholder
            pstmtAggiornamento.setString(1, nuovoNome);
            pstmtAggiornamento.setString(2, nuovoCognome);
            pstmtAggiornamento.setInt(3, nuovaEta);
            pstmtAggiornamento.setInt(4, idStudenteDaAggiornare);

            int righeAggiornate = pstmtAggiornamento.executeUpdate();
            System.out.println(righeAggiornate+ " record aggiornati con successo.");

            pstmtAggiornamento.close();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Non e' stato possibile connettersi al database.");
        }


    }
}
