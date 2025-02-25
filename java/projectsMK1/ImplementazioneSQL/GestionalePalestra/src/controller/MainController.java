package controller;

//classi che importiamo dagli altri package da poter utilizzare
import model.Membro;
import model.MembroDAO;
import view.MainFrame;
import view.MembroForm;
import view.RimuoviMembroForm;
import view.ModificaMembroForm;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;


//Classe per gestione interazione tra View e Model
public class MainController {
    private MainFrame mainFrame;
    private MembroDAO membroDAO;

     public MainController(){
         membroDAO = new MembroDAO();
         mainFrame = new MainFrame();

         //funzione per inizializzare eventi e gestione tabella
         initialize();
         mainFrame.setVisible(true);

     }

     public void initialize(){

         //caricamento e visualizzazione tabella nel mainframe
         try{
             updateTable();
         }catch (SQLException e){
             e.printStackTrace();
             //System.out.println("Non e' stato possibile connettersi al DB");
         }

         mainFrame.getAggiungiButton().addActionListener(e -> openMembroForm());
         mainFrame.getRimuoviButton().addActionListener(e -> rimuoviMembroForm());
         mainFrame.getModificaButton().addActionListener(e -> modificaMembroForm());
     }

     //metodo per aggiornare la tabella con i dati del DB
     public void updateTable() throws SQLException{
         DefaultTableModel model = new DefaultTableModel(new String[] {"ID", "Nome", "Cognome", "Email", "Data Iscrizione"}, 0);

         for(Membro membro : membroDAO.getAllMembri()){
             model.addRow(new Object[] {
                     membro.getId(),
                     membro.getNome(),
                     membro.getCognome(),
                     membro.getEmail(),
                     membro.getDataIscrizione(),
             });
         }
         mainFrame.getMembriTable().setModel(model);
     }

     //metodo per avviare la finestra di aggiunta
     public void openMembroForm(){
         //creazione istanza finestra di inserimento
        MembroForm membroForm = new MembroForm();
        membroForm.setVisible(true);

        membroForm.getSalvaButton().addActionListener(e -> {
            try{
                Membro nuovoMembro = new Membro(
                        0, //id non sara' necessario per l'inserimento
                        membroForm.getNomeField().getText(),
                        membroForm.getCognomeField().getText(),
                        membroForm.getEmailField().getText(),
                        java.time.LocalDate.now().toString()
                );

                membroDAO.addMembro(nuovoMembro); //aggiunge record al database
                updateTable(); //aggiorna la tabella
                membroForm.dispose(); //chiude la finestra di aggiunta
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        });
     }

    public void rimuoviMembroForm(){
        RimuoviMembroForm rimuoviMembroForm = new RimuoviMembroForm();
        rimuoviMembroForm.setVisible(true);

        rimuoviMembroForm.getRimuoviMembroButton().addActionListener(e -> {
            try {
                int id = Integer.parseInt(rimuoviMembroForm.getIdMembroField().getText());
                membroDAO.deleteMembro(id);
                updateTable(); //aggiorna la tabella
                rimuoviMembroForm.dispose();
            } catch (SQLException ex){
                ex.printStackTrace();
            }

        });
    }

    public void modificaMembroForm(){
        ModificaMembroForm modificaMembroForm = new ModificaMembroForm();
        modificaMembroForm.setVisible(true);

        modificaMembroForm.getModificaMembroButton().addActionListener(e -> {

            try {
                int id = Integer.parseInt(modificaMembroForm.getIdMembroField().getText());
                String nome = modificaMembroForm.getNomeField().getText();
                String cognome = modificaMembroForm.getCognomeField().getText();
                String email = modificaMembroForm.getEmailField().getText();

                membroDAO.updateMembro(id, nome, cognome, email);
                updateTable();
                modificaMembroForm.dispose();

            } catch (SQLException ex){
                ex.printStackTrace();
            }
        });

    }

}
