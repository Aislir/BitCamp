package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/palestra";
    private static final String USER = "root";
    private static final String PASSWORD = "0104";

    //metodo che viene chiamato ogni volta che vogliamo provare a connetterci al DB
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //Gestione connessione altri utenti
    private static final String URL_FRONT = "jdbc:mysql://localhost:3306/palestra";
    private static final String USER_FRONT = "frontUser";
    private static final String PASSWORD_FRONT = "frontpassword";

    public static Connection getConnectionFront() throws SQLException{
        return DriverManager.getConnection(URL_FRONT, USER_FRONT, PASSWORD_FRONT);
    }
}
