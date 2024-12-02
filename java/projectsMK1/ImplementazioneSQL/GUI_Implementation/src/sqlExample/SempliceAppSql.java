package sqlExample;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SempliceAppSql extends JFrame {
    //attributi di classe
    private static final String DB_URL = "jdbc:mysql://localhost:3306/scuola";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0104";

    private JLabel lblNome, lblCognome, lblEta;
    private JTextField txtNome, txtCognome, txtEta;
    private JButton btnSalva;

    //costruttore della classe
    public SempliceAppSql() {
        setTitle("Studenti App");

        //inizializzazione dei componenti per l'interfaccia grafica
        lblNome = new JLabel("Nome:");
        lblCognome = new JLabel("Cognome:");
        lblEta = new JLabel("Eta:");
        txtNome = new JTextField(5);
        txtCognome = new JTextField(5);
        txtEta = new JTextField(5);
        btnSalva = new JButton("Salva");

        //aggiunta dei componenti all'interfaccia grafica
        JPanel panel = new JPanel(new GridLayout());
        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblNome);
        panel.add(lblCognome);
        panel.add(txtCognome);
        panel.add(lblEta);
        panel.add(txtEta);
        panel.add(new JLabel());
        panel.add(btnSalva);

        add(panel);

        //Aggiunta dell'eventListener per il pulsante salva
        btnSalva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cognome = txtCognome.getText();
                int eta = 0;
                try {
                    eta = Integer.parseInt(txtEta.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Inserisci un valore valido.");
                }

                Connection connection = null;
                PreparedStatement pstmt = null;

                try {
                    connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                    String insertSql = "INSERT INTO studenti(nome, cognome, eta) VALUES(?,?,?)";

                    //preparazione della query e successivo riempimento parametri
                    pstmt = connection.prepareStatement(insertSql);
                    pstmt.setString(1, nome);
                    pstmt.setString(2, cognome);
                    pstmt.setInt(3, eta);

                    int righeInserite = pstmt.executeUpdate();

                    if (righeInserite > 0) {
                        JOptionPane.showMessageDialog(null, "Studente inserito con successo.");

                    }

                } catch (SQLException ex){
                    ex.printStackTrace();
                } finally {
                    try{
                        if (pstmt != null) pstmt.close();
                        if (connection != null) connection.close();
                    } catch (SQLException ex2){
                        ex2.printStackTrace();
                    }
                }

                //resettiamo i campi di input
                txtNome.setText("");
                txtCognome.setText("");
                txtEta.setText("");
            }
        }); //fine event listener

        //impostiamo le carattereistiche della finestra
        setSize(500,150);
        setLocationRelativeTo(null); //parte da (0,0) da in alto a sinistra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new SempliceAppSql();
    }

}
