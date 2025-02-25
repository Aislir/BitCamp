package view;

import controller.MagazzinoController;
import controller.MainController;

import javax.swing.*;
import java.awt.*;


public class MagazzinoFrame extends JPanel {

    JPanel filtriPanel = new JPanel();
    JPanel upperFiltri = new JPanel();
    JPanel lowerFiltri = new JPanel();
    JPanel risultatiPanel = new JPanel();
    JPanel elementiPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu Magazzino");
    JMenuItem visualizza = new JMenuItem("Visualizza l'intero magazzino");
    JMenuItem aggiungi = new JMenuItem("Aggiungi");
    JMenuItem rimuovi = new JMenuItem("Rimuovi");
    JButton cercaPerNomeBtn = new JButton("Cerca");
    JButton cercaPerTipoBtn = new JButton("Cerca");
    JButton cercaPerCodiceBtn = new JButton("Cerca");
    JButton cercaConFiltriBtn = new JButton("Cerca con filtri inseriti");
    JButton salvaModificheBtn = new JButton("Salva modifiche");
    JPanel upperPanel = new JPanel();
    JTable risultatiTable = new JTable();
    JScrollPane risultatiScrollPane = new JScrollPane(risultatiTable);

    public MagazzinoFrame() {
        setLayout(new BorderLayout());
        upperPanel.setLayout(new BorderLayout());
        contentPanel.setLayout(new GridLayout(1, 2));
        risultatiPanel.setLayout(new BorderLayout());
        risultatiPanel.add(risultatiScrollPane, BorderLayout.CENTER);
        //aggiunta elementi MenuBar
        menu.add(visualizza);
        menu.add(aggiungi);
        menu.add(rimuovi);
        menuBar.add(menu);

        //creazione elementi pannello filtri
        JLabel nomeProdotto = new JLabel("Nome Prodotto:");
        JTextField nomeCampo = new JTextField(25);
        JLabel tipoProdotto = new JLabel("Tipo Prodotto:");
        JTextField tipoCampo = new JTextField(25);
        JLabel codiceProdotto = new JLabel("Codice Prodotto:");
        JTextField codiceCampo = new JTextField(25);
        filtriPanel.setLayout(new BorderLayout(5, 5));
        upperFiltri.setLayout(new FlowLayout());
        //aggiunta elementi a pannello filtri
        upperFiltri.add(nomeProdotto);
        upperFiltri.add(nomeCampo);
        upperFiltri.add(cercaPerNomeBtn);
        upperFiltri.add(tipoProdotto);
        upperFiltri.add(tipoCampo);
        upperFiltri.add(cercaPerTipoBtn);
        upperFiltri.add(codiceProdotto);
        upperFiltri.add(codiceCampo);
        upperFiltri.add(cercaPerCodiceBtn);

        cercaConFiltriBtn.setPreferredSize(new Dimension(200, 25));
        lowerFiltri.add(cercaConFiltriBtn);


        filtriPanel.add(upperFiltri, BorderLayout.NORTH);
        filtriPanel.add(lowerFiltri, BorderLayout.SOUTH);

        //sezione visualizzazione pannelli tramite colore background
        //risultatiPanel.setBackground(Color.BLUE);
        elementiPanel.setBackground(Color.LIGHT_GRAY);

        upperPanel.add(menuBar, BorderLayout.NORTH);
        upperPanel.add(filtriPanel, BorderLayout.SOUTH);
        contentPanel.add(risultatiPanel);
        //contentPanel.add(elementiPanel);
        add(upperPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        //nasconde un pannello
        //elementiPanel.setVisible(false);

        //rimuove completamente il pannello e permette agli altri pannelli di adattarsi
        //contentPanel.remove(elementiPanel);


    }

    public JTable getRisultatiTable() {return risultatiTable;}
    public JButton getCercaPerNomeBtn() {return cercaPerNomeBtn;}
    public JMenuItem getVisualizza() {return visualizza;}
    public JMenuItem getAggiungi() {return aggiungi;}
    public JMenuItem getRimuovi() {return rimuovi;}
    public JButton getSalvaModificheBtn() {return salvaModificheBtn;}
    public JPanel getElementiPanel() {return elementiPanel;}
    public JButton getCercaPerTipoBtn() {return cercaPerTipoBtn;}
    public JPanel getContentPanel() {return contentPanel;}
}
