package controller;

import model.Fornitore;
import model.Marche;
import model.ProdottoDAO;
import model.TipoProdotto;
import view.GestioneFornitoriFrame;
import view.GestioneProdottiFrame;

import javax.swing.*;
import java.awt.*;

public class GestioneProdottiController {

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
            //opzione 'aggiungi' nel menu non piu' selezionabile
            enableBtn(gestioneProdottiFrame.getAggiungi());
            //rimozione pannello di destra
            gestioneProdottiFrame.getContentPanel().remove(gestioneProdottiFrame.getElementiPanel());
            //gestioneProdottiFrame.getRisultatiPanel().setBackground(Color.BLACK);
            //aggiunta pannello con elementi per aggiunta prodotto
            gestioneProdottiFrame.getRisultatiPanel().add(gestioneProdottiFrame.getAggiungiPanel(), BorderLayout.NORTH);
            gestioneProdottiFrame.getRisultatiPanel().revalidate();
            gestioneProdottiFrame.getRisultatiPanel().repaint();
            gestioneProdottiFrame.getContentPanel().revalidate();
            gestioneProdottiFrame.getContentPanel().repaint();
        });
    }

    private void modificaProdottoPanel() {

    }

    private void rimuoviProdottoPanel() {

    }

    private void visualizzaProdottoPanel() {

    }

    private void addProdotto() {
        gestioneProdottiFrame.getAggiungiBtn().addActionListener(e -> {
            ProdottoDAO prodottoDAO = new ProdottoDAO();
            //prendiamo tutti gli elementi che ci servono
            String nome = gestioneProdottiFrame.getNomeProdottoField().getText();
            TipoProdotto tipoProdotto = (TipoProdotto) gestioneProdottiFrame.getTipoProdotto().getSelectedItem();
            String codice = gestioneProdottiFrame.getCodiceProdottoField().getText();
            double contenuto = Double.parseDouble(gestioneProdottiFrame.getContenutoProdottoField().getText());
            Marche marche = (Marche) gestioneProdottiFrame.getMarcaProdotto().getSelectedItem();
            Fornitore fornitore = (Fornitore) gestioneProdottiFrame.getFornitoreProdotto().getSelectedItem();

            //prodottoDAO.addProdotto(nome, tipoProdotto, codice, contenuto, marche, fornitore);


        });


    }




    private void enableBtn(JMenuItem menuItem) {
        JMenuItem[] bottoniMenu = {gestioneProdottiFrame.getAggiungi(), gestioneProdottiFrame.getRimuovi(), gestioneProdottiFrame.getModifica(), gestioneProdottiFrame.getVisualizza()};
        for (JMenuItem bottoniMenuItem : bottoniMenu) {
            if (bottoniMenuItem.equals(menuItem)) {
                bottoniMenuItem.setEnabled(false);
            } else {
                bottoniMenuItem.setEnabled(true);
            }
        }
    }
}
