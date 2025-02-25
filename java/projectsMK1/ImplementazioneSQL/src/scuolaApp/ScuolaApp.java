package scuolaApp;

import javax.swing.*; //tutta la parte grafica.
import javax.swing.table.DefaultTableModel;
import java.awt.*; //tutta la parte di interazione con l'utente, l'asterisco * tutte le classi ma non le sue sottoclassi.
import java.awt.event.*; //Importiamo tutto oppure solo quelli che ci interessano ActionEvent ActionListener per risparmiare memoria.
import java.sql.*;
import java.util.ArrayList;

public class ScuolaApp {
    //attributi
    private JFrame frame; //finestra principale
    private CardLayout cardLayout; //layout per cambiare i pannelli
    private JPanel mainPanel; //pannello principale per contenere i diversi pannelle dell'applicazione gestiti con CardLayout
    private JTable table; // tabella per visualizzare i dati estratti dal database.

    //metodi classe
    public static void main(String[] args) {
        //Esecuzione dell'istanza dell'applicativo
        SwingUtilities.invokeLater(ScuolaApp::new);

    }



    //costruttore della classe
    public ScuolaApp() {
        frame = new JFrame("Gestione Scuola"); //Creazione della finestra principale
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //chiusura dell'applicazione alla chiusura della finestra
        frame.setSize(800,600);//Dimensione della finestra


        JMenuBar menuBar = new JMenuBar(); //barra dei menu (contenitore)
        JMenu menu = new JMenu("Menu"); //menu principale dell'applicativo
        JMenuItem viewItem = new JMenuItem ("Visualizza"); //elemento del menu per le operazioni di select
        JMenuItem insertItem = new JMenuItem ("Inserisci"); //elemento del menu per le operazioni di insert
        JMenuItem updateItem = new JMenuItem ("Modifica"); //elemento del menu per le operazioni di update
        JMenuItem deleteItem = new JMenuItem ("Elimina"); //elemento del menu per le operazioni di delete

        menu.add(viewItem);
        menu.add(insertItem);
        menu.add(updateItem);
        menu.add(deleteItem); //singole voci aggiunte al menu (menu)
        menuBar.add(menu);//aggiunta della voe menu alla barra
        frame.setJMenuBar(menuBar);//aggiunta della barra alla finestra

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);//Pannello principale con visualizzazione a schede separate.

        mainPanel.add(createViewPanel(),"Visualizza"); //Aggiunta del pannello di visualizzazione
        mainPanel.add(createInsertPanel(), "Inserisci"); //Aggiunta del pannello di insert
        mainPanel.add(createUpdatePanel(), "Modifica"); //Aggiunta del pannello di update
        mainPanel.add(createDeletePanel(), "Elimina"); //Aggiunta del pannello di delete

        viewItem.addActionListener(e -> cardLayout.show(mainPanel, "Visualizza"));// e la funzione di Action Event -- questa è la versione abbreviata. azione per aprire il pannello visualizza
        insertItem.addActionListener(e -> cardLayout.show(mainPanel, "Inserisci"));//Azione per il pannello di insert
        updateItem.addActionListener(e -> cardLayout.show(mainPanel, "Modifica"));//azione per il pannello update
        deleteItem.addActionListener(e -> cardLayout.show(mainPanel, "Elimina"));//Azione per il pannello delete

        frame.add(mainPanel);//aggiungiamo il pannello principale alla finestra
        frame.setVisible(true);

    }//fine costruttore

    //definizione dei pannelli per il cardLayout
    private JPanel createViewPanel() {
        JPanel panel = new JPanel(new BorderLayout());//pannello per la visualizzazione (SELECT)
        table = new JTable();//tabella per la visualizzazione dei record
        panel.add(new JScrollPane(table), BorderLayout.CENTER);//aggiunta della tabella ad uno scoll al centro
        loadTableData();//metodo per il caricamento dei dati sulla tabella
        return panel;//ritorno dell'oggetto di tipo panel al main panel per la visualizzazione
    }

    private JPanel createInsertPanel() {
        JPanel panel = new JPanel(new GridLayout(7,2)); //pannello per l'inserimento dei dati (INSERT INTO)prima le righe e poi le colonne
        JTextField nomeStudenteField = new JTextField();//Campo di testo per il nome dello studente
        JTextField cognomeStudenteField = new JTextField();//Campo di testo per il cognome dello studente
        JTextField matricolaField = new JTextField();//Campo di testo per la matricola dello studente
        JTextField nomeCorsoField = new JTextField();//campo di testo per il nome del corso
        JTextField docenteField = new JTextField();//campo di testo per inserire il nome del docente
        JButton insertButton = new JButton ("Inserisci");
        //aggiunta degli elementi al panel
        panel.add(new JLabel ("Nome Studente: "));//etichetta il nome dello studente
        panel.add(nomeStudenteField);//campo per l'inserimento del testo
        panel.add(new JLabel("Cognome Studente:"));
        panel.add(cognomeStudenteField);
        panel.add(new JLabel("Matricola:"));
        panel.add(matricolaField);
        panel.add(new JLabel("Corso:"));
        panel.add(nomeCorsoField);
        panel.add(new JLabel("Docente:"));
        panel.add(docenteField);
        panel.add(new JLabel());//spazio vuoto per gestire l'allineamento del bottone a destra
        panel.add(insertButton);

        insertButton.addActionListener(e -> {
            //Esegue le azioni necessarie per inserire dei dati nel database
            String nomeStudente = nomeStudenteField.getText();//recupera il nome dello studente
            String cognomeStudente = cognomeStudenteField.getText();
            String matricola = matricolaField.getText();
            String nomeCorso = nomeCorsoField.getText();
            String docente = docenteField.getText();
            //inserimento dati nel database
            insertStudentAndCourse(nomeStudente, cognomeStudente, matricola, nomeCorso, docente);
            //aggiorniamo i dati nella tabella
            loadTableData();
        });
        return panel;

    }

    private JPanel createUpdatePanel() {
        JPanel panel = new JPanel(new GridLayout(8,2)); //pannello per la modifica
        JTextField idField = new JTextField();
        JTextField nomeStudenteField = new JTextField();//Campo di testo per il nome dello studente
        JTextField cognomeStudenteField = new JTextField();//Campo di testo per il cognome dello studente
        JTextField matricolaField = new JTextField();//Campo di testo per la matricola dello studente
        JTextField nomeCorsoField = new JTextField();//campo di testo per il nome del corso
        JTextField docenteField = new JTextField();//campo di testo per inserire il nome del docente
        JButton updateButton = new JButton ("Modifica");
        //aggiunta degli elementi al pannello
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel ("Nome Studente: "));//etichetta il nome dello studente
        panel.add(nomeStudenteField);//campo per l'inserimento del testo
        panel.add(new JLabel("Cognome Studente:"));
        panel.add(cognomeStudenteField);
        panel.add(new JLabel("Matricola:"));
        panel.add(matricolaField);
        panel.add(new JLabel("Corso:"));
        panel.add(nomeCorsoField);
        panel.add(new JLabel("Docente:"));
        panel.add(docenteField);
        panel.add(new JLabel());//spazio vuoto per gestire l'allineamento del bottone a destra
        panel.add(updateButton);

        updateButton.addActionListener(e -> {
            //esecuzione dei comandi relativi alla modifica dei dati
            int id = Integer.parseInt(idField.getText());
            String nomeStudente = nomeStudenteField.getText();//recupera il nome dello studente
            String cognomeStudente = cognomeStudenteField.getText();
            String matricola = matricolaField.getText();
            String nomeCorso = nomeCorsoField.getText();
            String docente = docenteField.getText();
            //chiamata al metodo (crud) per la modifica dei dati nel database ovvero dei dati già presenti o che sono stati già archiviati precedentemente
            updateStudentAndCourse(id, nomeStudente, cognomeStudente, matricola, nomeCorso, docente);
            //chiamata del metodo per aggiornare la visualizzazione della tabella
            loadTableData();
        });
        return panel;
    }

    private JPanel createDeletePanel() {
        JPanel panel = new JPanel(new GridLayout(3,2));// pannello per l'eliminazione dei recordo (delete)
        JTextField idField = new JTextField();
        JButton deleteButton = new JButton("Elimina");
        //aggiunta degli elementi al pannello
        panel.add(new JLabel ("ID da eliminare:"));
        panel.add(idField);
        panel.add(new JLabel());
        panel.add(deleteButton);
        //gestione l'azione relativa al bottone per eliminare un record
        deleteButton.addActionListener(e -> {
            //gestione delle azioni dal compiere (blocco di codice)
            int id = Integer.parseInt(idField.getText());
            deleteStudentAndCourse(id);//chiamata del metodo crud per delete
            loadTableData();//chiamata del metodo select per view
        });
        return panel;
    }

    //metodi CRUD
    private void loadTableData() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolaApp","root","0104");//connessione
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT studenti.id, studenti.nome, studenti.cognome, studenti.matricola, corsi.nome AS corso, corsi.docente "
                    + "FROM iscrizioni "
                    + "JOIN studenti ON iscrizioni.id_studente = studenti.id "
                    + "JOIN corsi ON iscrizioni.id_corso = corsi.id "
            );
            //CREAZIONE dell'array per la memorizzazione dei dati ricevuti nel result set
            ArrayList<String[]> data = new ArrayList<>();//lista per memorizzare tutto quanto
            while(rs.next()) {
                int id = rs.getInt("id");
                String nomeStudente = rs.getString("nome");
                String cognomeStudente = rs.getString("cognome");
                String matricola = rs.getString("matricola");
                String nomeCorso = rs.getString("corso");
                String docente = rs.getString("docente");
                //aggiunta dei valori all'array data
                data.add(new String[]{String.valueOf(id), nomeStudente, cognomeStudente, matricola, nomeCorso, docente});
            }
            String [][] dataArr = new String [data.size()][6];//Array per i dati della tabella di swing il numero di elementi presenti {String.valueOf(id), nomeStudente, cognomeStudente, matricola, nomeCorso, docente}
            data.toArray(dataArr);//conversione del nostr arraylist in array matrice
            //intestazioni
            String[] columnNames = {"ID", "Nome Studente", "Cognome Studente", "Matricola", "Nome Corso", "Docente"};
            //popoliamo la tabella con le informazioni
            table.setModel(new javax.swing.table.DefaultTableModel(dataArr, columnNames));

        }catch(SQLException e) {
            e.printStackTrace();

        }
    }

    private void insertStudentAndCourse(String nomeStudente, String cognomeStudente, String matricola, String nomeCorso, String docente) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolaApp","root","0104")){
            conn.setAutoCommit(false);//poniamo in attesa il server di un nostro comando per eseguire la transazione
            //secondo costrutto try catch nidificato per la gestione delle query crud
            try (
                    //Preparazione della query di scrittura su tabella Studenti con ritorno della chiave ID generata prima di effettuarne l'effettivo invio
                    PreparedStatement pstmtStudente = conn.prepareStatement("INSERT INTO studenti (nome, cognome, matricola) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    //Preparazione della query di scrittura sulla corsi con ritorno della chiave ID
                    PreparedStatement pstmtCorso = conn.prepareStatement ("INSERT INTO corsi(nome, docente) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
                    //Preparazione della query di scrittura sulla tabella iscrizioni con i valori ricevuti dalle query precedenti
                    PreparedStatement pstmtIscrizione= conn.prepareStatement("INSERT INTO iscrizioni(id_studente, id_corso) VALUES(?,?)")
            ){
                //avviene la valorizzazione dei placeholder degli statement
                //Inserimento Studente
                pstmtStudente.setString(1, nomeStudente);
                pstmtStudente.setString(2, cognomeStudente);
                pstmtStudente.setString(3, matricola);
                pstmtStudente.executeUpdate();

                //immagazziniamo l'id rdel record appena scritto sulla tabella studenti
                ResultSet rsStudente = pstmtStudente.getGeneratedKeys();

                rsStudente.next();
                int studenteId = rsStudente.getInt(1);

                //inserimento del corso
                pstmtCorso.setString(1, nomeCorso);
                pstmtCorso.setString(2, docente);
                pstmtCorso.executeUpdate();

                //catturiamo l'id del corso appena inserito
                ResultSet rsCorso = pstmtCorso.getGeneratedKeys();

                rsCorso.next();
                int corsoId = rsCorso.getInt(1);

                //Inserimento dei dati per l'iscrizione
                pstmtIscrizione.setInt(1, studenteId);
                pstmtIscrizione.setInt(2, corsoId);
                pstmtIscrizione.executeUpdate();

                //comando per attivare finalmente la transazione
                conn.commit();


            }catch(SQLException ex) {
                //gestione delle eccezzioni sulle transazioni
                conn.rollback();//eliminiamo record parzialmente scritti
                ex.printStackTrace();
            }finally {
                conn.setAutoCommit(true);//ripristina il comportamento predefinito del server
            }
        }catch(SQLException e) {
            //gestione della eccezzione sulla connessione
            e.printStackTrace();
        }
    }

    //metodo per l'aggiornamento dei record delle tabelle
    private void updateStudentAndCourse(int id, String nomeStudente, String cognomeStudente, String matricola, String nomeCorso, String docente) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolaApp","root","0104")){
            conn.setAutoCommit(false);
            try (
                    PreparedStatement pstmtStudente = conn.prepareStatement("UPDATE studenti SET nome=?,cognome=?,matricola=? WHERE id=?");
                    PreparedStatement pstmtCorso = conn.prepareStatement("UPDATE corsi SET nome=?, docente=? WHERE id=(SELECT id_corso FROM iscrizioni WHERE id_studente =?)");
                    PreparedStatement pstmtIscrizioni = conn.prepareStatement("UPDATE iscrizioni SET id_corso=(SELECT id FROM corsi WHERE nome=? AND docente=?)");
            ){
                //valorizzazione dei placeholder e esecuzione degli stessi
                pstmtStudente.setString(1, nomeStudente);
                pstmtStudente.setString(2, cognomeStudente);
                pstmtStudente.setString(3, matricola);
                pstmtStudente.setInt(4, id);
                pstmtStudente.executeUpdate();

                pstmtCorso.setString(1, nomeCorso);
                pstmtCorso.setString(2, docente);
                pstmtCorso.setInt(3, id);
                pstmtCorso.executeUpdate();

                pstmtIscrizioni.setString(1, nomeCorso);
                pstmtIscrizioni.setString(2, docente);
                pstmtIscrizioni.executeUpdate();

                //inviamo la transazione
                conn.commit();


            }catch(SQLException e) {
                //ripristina le condizioni iniziali del database
                conn.rollback();
                e.printStackTrace();
            }finally {
                conn.setAutoCommit(true);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    //metodo per l'eliminazione
    private void deleteStudentAndCourse(int id) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scuolaApp","root","0104")){
            conn.setAutoCommit(false);
            try (
                    PreparedStatement pstmtStudente = conn.prepareStatement("DELETE FROM iscrizioni WHERE id_studente=?");
                    PreparedStatement pstmtCorso = conn.prepareStatement("DELETE FROM studenti WHERE id=?");
                    PreparedStatement pstmtIscrizioni = conn.prepareStatement("DELETE FROM corsi WHERE id=(SELECT id_corso FROM iscrizioni WHERE id_studente=?)");
            ){
                //valorizzazione dei placeholder e esecuzione degli stessi

                pstmtIscrizioni.setInt(1,id);
                pstmtIscrizioni.executeUpdate();

                pstmtStudente.setInt(1, id);
                pstmtStudente.executeUpdate();

                pstmtCorso.setInt(1, id);
                pstmtCorso.executeUpdate();

                //inviamo la transazione
                conn.commit();


            }catch(SQLException e) {
                //ripristina le condizioni iniziali del database
                conn.rollback();
                e.printStackTrace();
            }finally {
                conn.setAutoCommit(true);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }


}