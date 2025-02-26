package controller;

import model.ContattoFornitore;
import model.Fornitore;
import model.FornitoreDAO;
import view.GestioneFornitoriFrame;
import view.TableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class FornitoriController {
    String[] colVisFornitore = {"", "Nome", "Rappresentante", "Telefono", "Email"};
    GestioneFornitoriFrame gestioneFornitoriFrame = new GestioneFornitoriFrame();
    Fornitore fornitore = new Fornitore();
    FornitoreDAO fornitoreDAO = new FornitoreDAO();
    public FornitoriController() {
        initializeBtn();
    }

    private void initializeBtn() {
        //metodi per menubar principale
        aggiungiFornitorePanel();
        modificaFornitorePanel();
        rimuoviFornitorePanel();
        visualizzaFornitorePanel();

        //metodi per aggiungiPanel
        addFornitore();
        modificaFornitore();
        disableModificaRimuoviBtn();
    }

    private void aggiungiFornitorePanel() {
        gestioneFornitoriFrame.getAggiungi().addActionListener(e -> {

            puliziaPannello();
            gestioneFornitoriFrame.getUpperPanel().remove(gestioneFornitoriFrame.getModificaPanel());
            gestioneFornitoriFrame.getUpperPanel().add(gestioneFornitoriFrame.getAggiungiPanel(), BorderLayout.CENTER);
            repaintPannello();
            if (gestioneFornitoriFrame.getAggiungiPanel().isVisible()){
                gestioneFornitoriFrame.getAggiungi().setEnabled(false);
            }
        });
    }

    private void modificaFornitorePanel() {
        GestioneFornitoriFrame.getModifica().addActionListener(e -> {
            TableModel model = (TableModel) gestioneFornitoriFrame.getRisultatiTable().getModel();
            List<Fornitore> retrieveList = (List<Fornitore>) model.getData();
            List<Fornitore> fornitoriSelezionati = new ArrayList<>();
            for(Fornitore fornitoreSelezionato : retrieveList) {
                if (fornitoreSelezionato.getSelected()){
                    fornitoriSelezionati.add(fornitoreSelezionato);
                }
            }
            fornitore = fornitoriSelezionati.getFirst();

            gestioneFornitoriFrame.getUpperPanel().remove(gestioneFornitoriFrame.getAggiungiPanel());
            gestioneFornitoriFrame.getUpperPanel().add(gestioneFornitoriFrame.getModificaPanel(), BorderLayout.CENTER);

            repaintPannello();

            gestioneFornitoriFrame.getModificaNomeField().setText(fornitore.getNome());
            gestioneFornitoriFrame.getModificaRappresentanteField().setText(fornitore.getRappresentante());
            gestioneFornitoriFrame.getModificaContattoField().setText(fornitore.getContatti().getFirst().getContatti());
            gestioneFornitoriFrame.getModificaEmailField().setText(fornitore.getContatti().getFirst().getEmail());
            gestioneFornitoriFrame.getIdFornitoreField().setText(String.valueOf(fornitore.getId()));

            //isShowing() permette di capire se il pannello sia visibile
            if (gestioneFornitoriFrame.getAggiungiPanel().isShowing()){
                gestioneFornitoriFrame.getAggiungi().setEnabled(false);
            } else {
                gestioneFornitoriFrame.getAggiungi().setEnabled(true);
            }
        });
    }

    private void rimuoviFornitorePanel() {
        GestioneFornitoriFrame.getRimuovi().addActionListener(e -> {
            TableModel model = (TableModel) gestioneFornitoriFrame.getRisultatiTable().getModel();
            List<Fornitore> eliminaList = new ArrayList<>();
            try {
                List<Fornitore> retrieveList = (List<Fornitore>) model.getData();
                for (Fornitore fornitore : retrieveList) {
                    if (fornitore.getSelected()){
                        eliminaList.add(fornitore);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Errore durante il retrieval degli elementi selezionati");
            }
            fornitoreDAO.deleteFornitore(eliminaList);
            ricaricaRisultati();
            disableModificaRimuoviBtn();
        });
    }

    private void visualizzaFornitorePanel() {
        gestioneFornitoriFrame.getVisualizza().addActionListener(e -> {
            ricaricaRisultati();
            puliziaPannello();
            repaintPannello();
            if(gestioneFornitoriFrame.getRisultatiPanel().isVisible()){
                gestioneFornitoriFrame.getVisualizza().setEnabled(false);
            }
        });
    }

    private void addFornitore() {
        gestioneFornitoriFrame.getAggiungiBtn().addActionListener(e -> {
            //prende i valori inseriti nei campi
            String nomeFornitore = gestioneFornitoriFrame.getNomeNuovoFornitoreField().getText();
            String nomeRappresentante = gestioneFornitoriFrame.getRappresentanteNuovoField().getText();
            String contattoTel = gestioneFornitoriFrame.getContattoNuovoField().getText();
            String email = gestioneFornitoriFrame.getEmailNuovoField().getText();

            puliziaCampi();

            //creazione istanze delle due classi
            Fornitore fornitore = new Fornitore(nomeFornitore, nomeRappresentante);
            ContattoFornitore contattoFornitore = new ContattoFornitore(contattoTel, email);

            //richiamo funzione DAO per registrazione nel DB
            fornitoreDAO.addFornitore(fornitore, contattoFornitore);
            ricaricaRisultati();
        });
    }

    private void modificaFornitore() {
        gestioneFornitoriFrame.getSalvaModificheBtn().addActionListener(e -> {

            int idModificaFornitore = Integer.parseInt(gestioneFornitoriFrame.getIdFornitoreField().getText());
            String fornitore = gestioneFornitoriFrame.getModificaNomeField().getText();
            String rappresentante = gestioneFornitoriFrame.getModificaRappresentanteField().getText();
            String email = gestioneFornitoriFrame.getModificaEmailField().getText();
            String contatto = gestioneFornitoriFrame.getModificaContattoField().getText();

            fornitoreDAO.updateFornitore(idModificaFornitore, fornitore, rappresentante, email, contatto);
            ricaricaRisultati();
            puliziaCampi();
            disableModificaRimuoviBtn();
        });
    }

    private void puliziaPannello(){
        //ridimensiona l'immagine e aggiunge il pannello per visualizzazione
        gestioneFornitoriFrame.getImageIcon().setImage(gestioneFornitoriFrame.getImageIcon().getImage().getScaledInstance(2000, 500, Image.SCALE_DEFAULT));
        gestioneFornitoriFrame.getImageLabel().setIcon(gestioneFornitoriFrame.getImageIcon());
        gestioneFornitoriFrame.add(gestioneFornitoriFrame.getRisultatiPanel(), BorderLayout.CENTER);
    }

    private void repaintPannello(){
        //assicura che le modifiche effettuate sui pannelli siano visibili
        gestioneFornitoriFrame.getRisultatiPanel().revalidate();
        gestioneFornitoriFrame.getRisultatiPanel().repaint();
        gestioneFornitoriFrame.getContentPanel().revalidate();
        gestioneFornitoriFrame.getContentPanel().repaint();
        gestioneFornitoriFrame.revalidate();
        gestioneFornitoriFrame.repaint();

    }

    private void ricaricaRisultati(){
        TableModel model = new TableModel(fornitoreDAO.getAllFornitore(), colVisFornitore);
        gestioneFornitoriFrame.getRisultatiTable().setModel(model);
        TableColumn column0 = gestioneFornitoriFrame.getRisultatiTable().getColumnModel().getColumn(0);
        column0.setPreferredWidth(10);
        column0.setMaxWidth(20);
        gestioneFornitoriFrame.getRisultatiTable().getColumnModel().getColumn(0).setCellRenderer(new TableModel.CheckBoxRenderer());
        gestioneFornitoriFrame.getRisultatiTable().getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
    }

    private void puliziaCampi(){
        gestioneFornitoriFrame.getNomeNuovoFornitoreField().setText("");
        gestioneFornitoriFrame.getRappresentanteNuovoField().setText("");
        gestioneFornitoriFrame.getContattoNuovoField().setText("");
        gestioneFornitoriFrame.getEmailNuovoField().setText("");
        gestioneFornitoriFrame.getIdFornitoreField().setText("");
    }

    public void disableModificaRimuoviBtn(){
        GestioneFornitoriFrame.getModifica().setEnabled(false);
        GestioneFornitoriFrame.getRimuovi().setEnabled(false);
    }

}
