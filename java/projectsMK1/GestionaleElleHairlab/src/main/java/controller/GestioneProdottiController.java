package controller;

import model.*;
import view.GestioneProdottiFrame;
import view.TableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

public class GestioneProdottiController {
    String[] colVisProdotto = {"", "Prodotto", "Codice", "Tipo", "Contenuto", "Marca", "Fornitore"};
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    FornitoreDAO fornitoreDAO = new FornitoreDAO();
    GestioneProdottiFrame gestioneProdottiFrame = new GestioneProdottiFrame();
    public GestioneProdottiController() {
        initializeBtn();
    }

    private void initializeBtn() {
        //metodi per menubar principale
        aggiungiProdottoPanel();
        modificaProdottoPanel();
        rimuoviProdottoPanel();
        visualizzaProdottoPanel();

        //metodi per aggiungiPanel
        addProdotto();
    }

    private void aggiungiProdottoPanel() {
        gestioneProdottiFrame.getAggiungi().addActionListener(e -> {
            puliziaPannello();
            List<Fornitore> fornitoreList = fornitoreDAO.getAllFornitore();
            for (Fornitore fornitore : fornitoreList) {
                gestioneProdottiFrame.getFornitoreProdotto().addItem(fornitore.getNome());
            }

            //opzione 'aggiungi' nel menu non piu' selezionabile
            enableBtn(gestioneProdottiFrame.getAggiungi());

            //aggiunta pannello con elementi per aggiunta prodotto
            gestioneProdottiFrame.getRisultatiPanel().add(gestioneProdottiFrame.getAggiungiPanel(), BorderLayout.NORTH);
            repaintPanel();
        });
    }

    private void modificaProdottoPanel() {

    }

    private void rimuoviProdottoPanel() {

    }

    private void visualizzaProdottoPanel() {
        gestioneProdottiFrame.getVisualizza().addActionListener(e -> {
            ricaricaRisultati();
            puliziaPannello();
            repaintPanel();
        });
    }

    private void addProdotto() {
        gestioneProdottiFrame.getAggiungiBtn().addActionListener(e -> {
            //prendiamo tutti gli elementi che ci servono
            String nome = gestioneProdottiFrame.getNomeProdottoField().getText();
            TipoProdotto tipoProdotto = (TipoProdotto) gestioneProdottiFrame.getTipoProdotto().getSelectedItem();
            String codice = gestioneProdottiFrame.getCodiceProdottoField().getText();
            double contenuto = Double.parseDouble(gestioneProdottiFrame.getContenutoProdottoField().getText());
            Marca marca = (Marca) gestioneProdottiFrame.getMarcaProdotto().getSelectedItem();
            String nomeFornitore = (String) gestioneProdottiFrame.getFornitoreProdotto().getSelectedItem();
            Prodotto prodotto = new Prodotto(nome, codice, tipoProdotto, contenuto, marca);
            prodottoDAO.addProdotto(prodotto, nomeFornitore);

            puliziaCampi();
            ricaricaRisultati();
        });
    }

    private void puliziaPannello(){
        //ridimensiona l'immagine e aggiunge il pannello per visualizzazione
        gestioneProdottiFrame.getImageIcon().setImage(gestioneProdottiFrame.getImageIcon().getImage().getScaledInstance(2000, 500, Image.SCALE_DEFAULT));
        gestioneProdottiFrame.getImageLabel().setIcon(gestioneProdottiFrame.getImageIcon());
        gestioneProdottiFrame.add(gestioneProdottiFrame.getRisultatiPanel(), BorderLayout.CENTER);
    }

    private void ricaricaRisultati(){
        TableModel model = new TableModel(prodottoDAO.getAllProdotti(), colVisProdotto);
        gestioneProdottiFrame.getVisualizzaTable().setModel(model);
        TableColumn column0 = gestioneProdottiFrame.getVisualizzaTable().getColumnModel().getColumn(0);
        column0.setPreferredWidth(10);
        column0.setMaxWidth(20);
        gestioneProdottiFrame.getVisualizzaTable().getColumnModel().getColumn(0).setCellRenderer(new TableModel.CheckBoxRenderer());
        gestioneProdottiFrame.getVisualizzaTable().getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
    }

    private void repaintPanel(){
        gestioneProdottiFrame.getRisultatiPanel().revalidate();
        gestioneProdottiFrame.getRisultatiPanel().repaint();
        gestioneProdottiFrame.getContentPanel().revalidate();
        gestioneProdottiFrame.getContentPanel().repaint();
        gestioneProdottiFrame.revalidate();
        gestioneProdottiFrame.repaint();
    }

    private void puliziaCampi(){
        gestioneProdottiFrame.getNomeProdottoField().setText("");
        gestioneProdottiFrame.getCodiceProdottoField().setText("");
        gestioneProdottiFrame.getContenutoProdottoField().setText("");
    }

    private void enableBtn(JMenuItem menuItem) {
        JMenuItem[] bottoniMenu = {gestioneProdottiFrame.getAggiungi(), GestioneProdottiFrame.getRimuovi(), GestioneProdottiFrame.getModifica(), gestioneProdottiFrame.getVisualizza()};
        for (JMenuItem bottoniMenuItem : bottoniMenu) {
            if (bottoniMenuItem.equals(menuItem)) {
                bottoniMenuItem.setEnabled(false);
            } else {
                bottoniMenuItem.setEnabled(true);
            }
        }
    }
}
