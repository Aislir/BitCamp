package sqlRistoranteManager;

import java.sql.*;
import java.util.Scanner;

public class RistoranteManager {
    //dichiarazione attributi static della classe
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ristorante";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0104";

    //dichiarazione dei comandi SQL, static e final. Questo permette che non vengano modificati
    //e che siano visibili da tutti i metodi
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS menu ("
                                                    +"id INT AUTO_INCREMENT PRIMARY KEY,"
                                                    +"nome VARCHAR(100) NOT NULL,"
                                                    +"prezzo DECIMAL(10,2) NOT NULL"
                                                    +")";

    private static final String INSERT_QUERY = "INSERT INTO menu(nome, prezzo) VALUES(?,?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM menu";
    private static final String UPDATE_QUERY = "UPDATE menu SET nome=?, prezzo=? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM menu WHERE id=?";


    public static void main(String[] args) {

        //creazione tabella nel DB all'avvio se non gia' esistente
        createTableIfNotExists();

        Scanner scanner = new Scanner(System.in);
        int scelta = -1;

        while (scelta != 0){
            System.out.println("Ristorante Manager by BitCamp\n");
            System.out.println("-----------------------------\n");
            System.out.println("1. Aggiungi piatto al menu");
            System.out.println("2. Visualizza il menu");
            System.out.println("3. Modifica un piatto");
            System.out.println("4. Elimina un piatto");
            System.out.println("0. Esci");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta){
                case 1:
                    System.out.print("Inserisci il nome del piatto: ");
                    String nomePiatto = scanner.nextLine();
                    System.out.print("Inserisci il prezzo del piatto: ");
                    double prezzoPiatto = scanner.nextDouble();
                    insertPiatto(nomePiatto, prezzoPiatto);
                    System.out.println("Piatto aggiunto con successo");
                    break;
                case 2:
                    System.out.println("Menu': \n");
                    printMenu();
                    break;
                case 3:
                    System.out.print("Inserisci l'ID del piatto da modificare: ");
                    int idModifica = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Inserisci il nuovo nome del piatto: ");
                    nomePiatto = scanner.nextLine();
                    System.out.print("Inserisci il nuovo prezzo del piatto: ");
                    prezzoPiatto = scanner.nextDouble();
                    updatePiatto(idModifica, nomePiatto, prezzoPiatto);
                    System.out.println("Il piatto e' stato aggiornato");
                    break;
                case 4:
                    System.out.print("Per favore, inserisci l'ID del piatto da eliminare: ");
                    int id = scanner.nextInt();
                    deletePiatto(id);
                    System.out.println("Piatto rimosso dal menu con successo");
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

    private static void insertPiatto(String nome, double prezzo){

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

    private static void printMenu(){

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

    private static void updatePiatto(int id, String nome, double prezzo){

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

    private static void deletePiatto(int id){

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
