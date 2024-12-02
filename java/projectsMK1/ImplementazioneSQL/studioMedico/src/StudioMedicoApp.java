import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudioMedicoApp extends JFrame {

    //attributi classe
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studioMedico";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0104";

    private Connection connection;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement pstmt;

    private JTextArea outputTextArea;
    private JTextField txtData;
    private JTextField txtOra;
    private JTextField txtNomeDottore;
    private JTextField txtSpecializzazione;
    private JTextField txtNomeCliente;
    private JTextField txtCognomeCliente;
    private JTextField txtId;

    public StudioMedicoApp(){
        setTitle("Studio Medico - Gestione Appuntamenti");

        //gestiamo la connessione al DB all'avvio del programma
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Impossibile connettersi al Database.", "Errore", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        outputTextArea = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        JPanel btnPanel = new JPanel(new GridLayout(6,2));

        JButton btnAppuntamenti = new JButton("Visualizza Appuntamenti");
        btnAppuntamenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAppuntamenti();
            }
        });
        btnPanel.add(btnAppuntamenti);

        JButton btnInserisciAppuntamento = new JButton("Inserisci appuntamento");
        btnInserisciAppuntamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserisciAppuntamento();
            }
        });
        btnPanel.add(btnInserisciAppuntamento);

        JButton btnModificaAppuntamenti = new JButton("Modifica Appuntamenti");
        btnModificaAppuntamenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificaAppuntamenti();
            }
        });
        btnPanel.add(btnModificaAppuntamenti);

        JButton btnEliminaAppuntamenti = new JButton("Elimina Appuntamenti");
        btnEliminaAppuntamenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminaAppuntamenti();
            }
        });
        btnPanel.add(btnEliminaAppuntamenti);

        JButton btnDottori = new JButton("Visualizza Dottori");
        btnDottori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDottori();
            }
        });
        btnPanel.add(btnDottori);

        JButton btnInserisciDottore = new JButton("Inserisci dottore");
        btnInserisciDottore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserisciDottore();
            }
        });
        btnPanel.add(btnInserisciDottore);

        JButton btnModificaDottore = new JButton("Modifica Dottore");
        btnModificaDottore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificaDottore();
            }
        });
        btnPanel.add(btnModificaDottore);

        JButton btnEliminaDottore = new JButton("Elimina Dottore");
        btnEliminaDottore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminaDottore();
            }
        });
        btnPanel.add(btnEliminaDottore);

        JButton btnClienti = new JButton("Visualizza clienti");
        btnClienti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showClienti();
            }
        });
        btnPanel.add(btnClienti);

        JButton btnInserisciCliente = new JButton("Inserisci Cliente");
        btnInserisciCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserisciCliente();
            }
        });
        btnPanel.add(btnInserisciCliente);

        JButton btnModificaCliente = new JButton("Modifica Cliente");
        btnModificaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificaCliente();
            }
        });
        btnPanel.add(btnModificaCliente);

        JButton btnEliminaCliente = new JButton("Elimina Cliente");
        btnEliminaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminaCliente();
            }
        });
        btnPanel.add(btnEliminaCliente);

        //pannello per gestione input
        JPanel inputPanel = new JPanel(new GridLayout(12,1));
        txtData = new JTextField(20);
        txtOra = new JTextField(20);
        txtNomeDottore = new JTextField(20);
        txtSpecializzazione = new JTextField(20);
        txtNomeCliente = new JTextField(20);
        txtCognomeCliente = new JTextField(20);
        txtId = new JTextField(20);

        //inseriamo gli elementi nel pannello
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(txtData);
        inputPanel.add(new JLabel("Ora:"));
        inputPanel.add(txtOra);
        inputPanel.add(new JLabel("Nome Dottore:"));
        inputPanel.add(txtNomeDottore);
        inputPanel.add(new JLabel("Specializzazione:"));
        inputPanel.add(txtSpecializzazione);
        inputPanel.add(new JLabel("Nome Cliente:"));
        inputPanel.add(txtNomeCliente);
        inputPanel.add(new JLabel("Cognome Cliente:"));
        inputPanel.add(txtCognomeCliente);
        inputPanel.add(new JLabel("Id elemento:"));
        inputPanel.add(txtId);

        //creiamo un pannello base per inserire i nostri 3 pannelli
        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.EAST);
        getContentPane().add(inputPanel, BorderLayout.WEST);

        //gestione caratteristiche frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); //permette di far adeguare le dimensioni della finestra in base ai contenuti presenti
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void showAppuntamenti(){
        outputTextArea.setText("");

        try{
            rs = stmt.executeQuery("SELECT * FROM appuntamenti");
            while(rs.next()){
                outputTextArea.append("Id: " + rs.getString("id")+ " - " + "data: " + rs.getString("data") + " - ora: " + rs.getString("ora") + " - dottore: " + rs.getString("dottore") + " - cliente: " + rs.getString("cliente") + "\n");
            }
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante il recupero degli Appuntamenti", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }





    //metodo per visualizzare i dottori
    private void showDottori() {
        outputTextArea.setText("");
        try {
            rs = stmt.executeQuery("SELECT * FROM dottori");
            while(rs.next()) {
                outputTextArea.append(rs.getString("id") + " - " + rs.getString("nome") + " - " + rs.getString("specializzazione") + "\n");
            }

        }catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante il recupero degli Dottori", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo per visualizzare i clienti
    private void showClienti() {
        outputTextArea.setText("");
        try {
            rs = stmt.executeQuery("SELECT * FROM clienti");
            while(rs.next()) {
                outputTextArea.append(rs.getString("id") + " - " + rs.getString("nome") + " - " + rs.getString("cognome") + "\n");
            }

        }catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante il recupero dei Clienti", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodo per l'inserimento di un appuntamento
    private void inserisciAppuntamento() {
        //preleviamo i campi necessari
        String data = txtData.getText();
        String ora = txtOra.getText();
        String dottore = txtNomeDottore.getText();
        String cliente = txtNomeCliente.getText() + " " + txtCognomeCliente.getText();

        //preparazione della query di insert
        try {
            pstmt = connection.prepareStatement("INSERT INTO appuntamenti(data, ora, dottore, cliente) VALUES(?,?,?,?)");
            pstmt.setString(1, data);
            pstmt.setString(2, ora);
            pstmt.setString(3, dottore);
            pstmt.setString(4, cliente);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Appuntamento inserito con successo");
        }catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante l'inserimento dell'Appuntamento", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inserisciDottore(){

        String nome = txtNomeDottore.getText();
        String specializzazione = txtSpecializzazione.getText();

        try {
            pstmt = connection.prepareStatement("INSERT INTO dottori(nome, specializzazione) VALUES(?,?)");
            pstmt.setString(1, nome);
            pstmt.setString(2, specializzazione);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Dottore inserito con successo.");

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante l'inserimento dell'Appuntamento", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void inserisciCliente(){

        String nome = txtNomeCliente.getText();
        String cognome = txtCognomeCliente.getText();

        try {
            pstmt = connection.prepareStatement("INSERT INTO clienti(nome, cognome) VALUES(?,?)");
            pstmt.setString(1, nome);
            pstmt.setString(2, cognome);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cliente inserito con successo.");

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante l'inserimento dell'Appuntamento", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificaAppuntamenti(){

        int id = 0;
        try {
            id = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore. Inserisci un valore valido", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        String data = txtData.getText();
        String ora = txtOra.getText();
        String dottore = txtNomeDottore.getText();
        String cliente = txtNomeCliente.getText() + " " + txtCognomeCliente.getText();

        try {
            pstmt = connection.prepareStatement("UPDATE appuntamenti SET data=?, ora=?, dottore=?, cliente=? WHERE id=?");
            pstmt.setString(1, data);
            pstmt.setString(2, ora);
            pstmt.setString(3, dottore);
            pstmt.setString(4, cliente);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Appuntamento modificato con successo.");

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante la modifica dell'Appuntamento", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminaAppuntamenti(){

        int id = 0;
        try {
            id = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore. Inserisci un valore valido", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        try {
            pstmt = connection.prepareStatement("DELETE FROM appuntamenti WHERE id=?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Appuntamento eliminato con successo.");

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante l'eliminazione dell'Appuntamento", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificaDottore(){

        int id = 0;
        try {
            id = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore. Inserisci un valore valido", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        String dottore = txtNomeDottore.getText();
        String specializzazione = txtSpecializzazione.getText();

        try {
            pstmt = connection.prepareStatement("UPDATE dottori SET nome=?, specializzazione=? WHERE id=?");

            pstmt.setString(1, dottore);
            pstmt.setString(2, specializzazione);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Dottore modificato con successo.");

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante la modifica del Dottore", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminaDottore(){

        int id = 0;
        try {
            id = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore. Inserisci un valore valido", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        try {
            pstmt = connection.prepareStatement("DELETE FROM dottori WHERE id=?");

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Dottore eliminato con successo.");

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante l'eliminazione del Dottore", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificaCliente(){

        int id = 0;
        try {
            id = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore. Inserisci un valore valido", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        String nome = txtNomeCliente.getText();
        String cognome= txtCognomeCliente.getText();

        try {
            pstmt = connection.prepareStatement("UPDATE clienti SET nome=?, cognome=? WHERE id=?");

            pstmt.setString(1, nome);
            pstmt.setString(2, cognome);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cliente modificato con successo.");

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante la modifica del Cliente", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminaCliente(){

        int id = 0;
        try {
            id = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore. Inserisci un valore valido", "Errore", JOptionPane.ERROR_MESSAGE);
        }

        try {
            pstmt = connection.prepareStatement("DELETE FROM clienti WHERE id=?");

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cliente eliminato con successo.");

        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante l'eliminazione del Cliente", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }







    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudioMedicoApp();
            }
        });
    }

}
