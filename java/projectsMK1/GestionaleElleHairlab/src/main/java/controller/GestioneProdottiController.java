package controller;

import model.*;
import view.GestioneProdottiFrame;
import view.TableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GestioneProdottiController {
    String[] colVisProdotto = {"", "Prodotto", "Codice", "Tipo", "Contenuto", "Marca", "Fornitore"};
    ProdottoDAO prodottoDAO = new ProdottoDAO();
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
        modificaProdotto();
        disableModificaRimuoviBtn();
    }

    private void aggiungiProdottoPanel() {
        gestioneProdottiFrame.getAggiungi().addActionListener(e -> {
            puliziaPannello();
            //aggiunta pannello con elementi per aggiunta prodotto e rimozione pannello modifica se presente
            gestioneProdottiFrame.getUpperPanel().remove(gestioneProdottiFrame.getModificaPanel());
            gestioneProdottiFrame.getUpperPanel().add(gestioneProdottiFrame.getAggiungiPanel(), BorderLayout.CENTER);
            repaintPanel();

        });
    }

    private void modificaProdottoPanel() {
        GestioneProdottiFrame.getModificaProdotto().addActionListener(e -> {
            System.out.println("Sono dentro al modifica prodotto");
            //acquisizione model per poter capire quali prodotti sono stati selezionati
            TableModel model = (TableModel) gestioneProdottiFrame.getVisualizzaTable().getModel();
            List<Prodotto> retrieveList = (List<Prodotto>) model.getData();
            List<Prodotto> prodottiSelezionati = new ArrayList<>();
            for (Prodotto prodotto : retrieveList) {
               if (prodotto.getIsSelected()){
                   prodottiSelezionati.add(prodotto);
               }
            }
            //prendo solamente un elemento tra quelli selezionati
            Prodotto prodotto = prodottiSelezionati.getFirst();
            puliziaPannello();
            gestioneProdottiFrame.getUpperPanel().remove(gestioneProdottiFrame.getAggiungiPanel());
            gestioneProdottiFrame.getUpperPanel().add(gestioneProdottiFrame.getModificaPanel(), BorderLayout.CENTER);

            repaintPanel();
            passaggioValoriProdottoAiFieldPerModifica(prodotto);
        });
    }

    private void rimuoviProdottoPanel() {
        GestioneProdottiFrame.getRimuovi().addActionListener(e -> {
            TableModel model = (TableModel) gestioneProdottiFrame.getVisualizzaTable().getModel();
            List<Prodotto> eliminaList = new ArrayList<>();
            try {
                List<Prodotto> retrieveList = (List<Prodotto>) model.getData();
                for (Prodotto prodotto : retrieveList) {
                    if (prodotto.getIsSelected()){
                        eliminaList.add(prodotto);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Errore durante il retrieval degli elementi selezionati");
            }
            for (Prodotto prodotto : eliminaList) {
                System.out.println(prodotto.getNome());
            }
            prodottoDAO.deleteProdotto(eliminaList);
            ricaricaRisultati();
            disableModificaRimuoviBtn();
        });
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
            Fornitore fornitore = (Fornitore) gestioneProdottiFrame.getFornitoreProdotto().getSelectedItem();

            prodottoDAO.addProdotto(nome, tipoProdotto, codice, contenuto, marca, fornitore);

            puliziaCampi();
            ricaricaRisultati();
        });
    }

    private void modificaProdotto() {
        gestioneProdottiFrame.getSalvaModificheBtn().addActionListener(e -> {
            //prendo i valori nei campi modificati dall'utente
            int id = Integer.parseInt(gestioneProdottiFrame.getIdModificaProdottoField().getText());
            String nome = gestioneProdottiFrame.getModificaNomeField().getText();
            String codice = gestioneProdottiFrame.getModificaCodiceField().getText();
            TipoProdotto tipoProdotto = (TipoProdotto) gestioneProdottiFrame.getModificaTipoBox().getSelectedItem();
            double contenuto = Double.parseDouble(gestioneProdottiFrame.getModificaContenutoField().getText());
            Marca marca = (Marca) gestioneProdottiFrame.getModificaMarcaBox().getSelectedItem();
            String fornitore = (String) gestioneProdottiFrame.getModificaFornitoreBox().getSelectedItem();

            prodottoDAO.updateProdotto(id, nome, codice, tipoProdotto, contenuto, marca, fornitore);
            ricaricaRisultati();
            puliziaCampi();
            disableModificaRimuoviBtn();
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
        //pulizia campi aggiungi panel
        gestioneProdottiFrame.getNomeProdottoField().setText("");
        gestioneProdottiFrame.getCodiceProdottoField().setText("");
        gestioneProdottiFrame.getContenutoProdottoField().setText("");
        gestioneProdottiFrame.getTipoProdotto().setSelectedItem(TipoProdotto.NULL);
        gestioneProdottiFrame.getMarcaProdotto().setSelectedItem(Marca.NULL);
        gestioneProdottiFrame.getFornitoreProdotto().setSelectedItem(Fornitore.NULL);

        //pulizia campi modifica panel
        gestioneProdottiFrame.getIdModificaProdottoField().setText("");
        gestioneProdottiFrame.getModificaNomeField().setText("");
        gestioneProdottiFrame.getModificaCodiceField().setText("");
        gestioneProdottiFrame.getModificaContenutoField().setText("");
        gestioneProdottiFrame.getModificaMarcaBox().setSelectedItem(Marca.NULL);
        gestioneProdottiFrame.getModificaTipoBox().setSelectedItem(Marca.NULL);
        gestioneProdottiFrame.getModificaFornitoreBox().setSelectedItem(Fornitore.NULL);
    }

    private void passaggioValoriProdottoAiFieldPerModifica(Prodotto prodotto){
        gestioneProdottiFrame.getIdModificaProdottoField().setText(String.valueOf(prodotto.getId()));
        gestioneProdottiFrame.getModificaNomeField().setText(prodotto.getNome());
        gestioneProdottiFrame.getModificaCodiceField().setText(prodotto.getCodice());
        gestioneProdottiFrame.getModificaTipoBox().setSelectedItem(prodotto.getTipo());
        gestioneProdottiFrame.getModificaContenutoField().setText(String.valueOf(prodotto.getContenuto()));
        gestioneProdottiFrame.getModificaMarcaBox().setSelectedItem(prodotto.getMarca());
        gestioneProdottiFrame.getModificaFornitoreBox().setSelectedItem(prodotto.getFornitore());

    }

    public void disableModificaRimuoviBtn(){
        GestioneProdottiFrame.getModificaProdotto().setEnabled(false);
        GestioneProdottiFrame.getRimuovi().setEnabled(false);
    }
}
