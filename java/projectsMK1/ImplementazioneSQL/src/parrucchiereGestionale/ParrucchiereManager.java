package parrucchiereGestionale;

import java.sql.*;
import java.util.Scanner;

public class ParrucchiereManager {
    //definizione attributi statici della classe
    private static final String DB_URL = "jdbc:mysql://localhost:3306/parrucchiere";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0104";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS servizi ("
            +"id INT AUTO_INCREMENT PRIMARY KEY,"
            +"nome VARCHAR(100) NOT NULL,"
            +"prezzo DECIMAL(10,2) NOT NULL"
            +")";

    private static final String INSERT_QUERY = "INSERT INTO servizi(nome, prezzo) VALUES(?,?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM servizi";
    private static final String UPDATE_QUERY = "UPDATE servizi SET nome=?, prezzo=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM servizi WHERE id=?";

    public static void main(String[] args) {
        createTableIfNotExists();
        Scanner scanner = new Scanner(System.in);
        int scelta = -1;

        while (scelta != 0){
            System.out.println("Gestionale Parrucchieri\n");
            System.out.println("-----------------------------\n");
            System.out.println("1. Visualizza i servizi");
            System.out.println("2. Aggiungi servizio");
            System.out.println("3. Modifica un servizio");
            System.out.println("4. Elimina un servizio");
            System.out.println("0. Esci");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta){
                case 1:
                    System.out.println("Servizi: \n");
                    printServizi();
                    break;
                case 2:
                    System.out.print("Inserisci il nome del servizio: ");
                    String nomeServizio = scanner.nextLine();
                    System.out.print("Inserisci il prezzo del servizio: ");
                    double prezzoServizio = scanner.nextDouble();
                    insertServizio(nomeServizio, prezzoServizio);
                    System.out.println("Servizio aggiunto con successo");
                    break;
                case 3:
                    System.out.print("Inserisci l'ID del servizio da modificare: ");
                    int idModifica = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Inserisci il nuovo nome del servizio: ");
                    nomeServizio = scanner.nextLine();
                    System.out.print("Inserisci il nuovo prezzo del servizio: ");
                    prezzoServizio = scanner.nextDouble();
                    updateServizio(idModifica, nomeServizio, prezzoServizio);
                    System.out.println("Il servizio e' stato aggiornato");
                    break;
                case 4:
                    System.out.print("Per favore, inserisci l'ID del servizio da eliminare: ");
                    int id = scanner.nextInt();
                    deleteServizio(id);
                    System.out.println("servizio rimosso dal menu con successo");
                    break;
                default:
                    break;
            }
        }
    }

    private static void createTableIfNotExists(){

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(CREATE_TABLE_QUERY);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore. Non e' stato possibile connettersi al database.");
        }
    }

    private static void printServizi(){

        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Double prezzo = rs.getDouble("prezzo");

                System.out.println(id + ") Piatto: "+nome+" - Prezzo: "+prezzo+ " €");
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void insertServizio(String nome, double prezzo){

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);
            pstmt.setString(1, nome);
            pstmt.setDouble(2, prezzo);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void updateServizio(int id, String nome, double prezzo){

        try{
            //connessione al DB
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //impostazione query parametrica
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY);
            //valorizzazione placeholders
            pstmt.setString(1, nome);
            pstmt.setDouble(2, prezzo);
            pstmt.setInt(3, id);
            //invio comando per esecuzione query
            pstmt.executeUpdate();

            //chiusura connessione
            pstmt.close();
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void deleteServizio(int id){

        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
