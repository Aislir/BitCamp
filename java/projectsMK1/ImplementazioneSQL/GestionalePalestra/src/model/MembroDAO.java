package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//classe DAO (Data Access Object) per gestire le operazioni CRUD sui membri
public class MembroDAO {

    public List<Membro> getAllMembri() throws SQLException{
        List<Membro> membri = new ArrayList<>();
        String query = "SELECT * FROM membri";

        try(
                Connection connection = DatabaseConnection.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
                ){
            while(rs.next()){
                membri.add(new Membro(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("email"),
                        rs.getString("data_iscrizione")
                ));
            }
        }
        return membri;
    }

    public void addMembro(Membro membro) throws SQLException{
        String query = "INSERT INTO membri(nome, cognome, email, data_iscrizione) VALUES(?,?,?,?)";

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query)
                ){
            pstmt.setString(1, membro.getNome());
            pstmt.setString(2, membro.getCognome());
            pstmt.setString(3, membro.getEmail());
            pstmt.setString(4, membro.getDataIscrizione());

            pstmt.executeUpdate();
        }
    }
    public void updateMembro(int id, String nome, String cognome, String email) throws SQLException{
        String query = "UPDATE membri SET nome=?, cognome=?, email=? WHERE id=?";

        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query);
                ){
            pstmt.setString(1, nome);
            pstmt.setString(2, cognome);
            pstmt.setString(3, email);
            //pstmt.setString(4, dataIscrizione);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
        }
    }
    //throws SQLException rimpiazza il catch quando utilizziamo try
    public void deleteMembro(int id) throws SQLException{
        String query = "DELETE FROM membri WHERE id=?";
        try(
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query);
                ){
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
        }
    }

}
