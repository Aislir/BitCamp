package view;

import model.TipoProdotto;

import javax.swing.*;
import java.awt.*;

//classe per aggiunta, modifica, rimozione (dal database) e visualizzazione dei prodotti
public class GestioneProdottiFrame extends JPanel{

    //elementi per pannello per visualizzare, modificare e rimuovere
    JPanel filtriPanel = new JPanel();
    JPanel upperFiltri = new JPanel();
    JPanel lowerFiltri = new JPanel();
    JPanel risultatiPanel = new JPanel();
    JPanel elementiPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu Gestione Prodotti");
    JMenuItem visualizza = new JMenuItem("Visualizza tutti i prodotti");
    JMenuItem modifica = new JMenuItem("Modifica prodotto");
    JMenuItem aggiungi = new JMenuItem("Aggiungi nuovo prodotto");
    JMenuItem rimuovi = new JMenuItem("Rimuovi prodotto permanentemente");
    JButton cercaPerNomeBtn = new JButton("Cerca");
    JButton cercaPerTipoBtn = new JButton("Cerca");
    JButton cercaPerCodiceBtn = new JButton("Cerca");
    JButton cercaConFiltriBtn = new JButton("Cerca con filtri inseriti");
    JButton salvaModificheBtn = new JButton("Salva modifiche");
    JPanel upperPanel = new JPanel();
    JTable risultatiTable = new JTable();
    JScrollPane risultatiScrollPane = new JScrollPane(risultatiTable);
    TipoProdotto tipoProdotto;
    //ComboBox per tipo, marca e fornitore
    JComboBox<TipoProdotto> tipoBox = new JComboBox<>(TipoProdotto.values());
    JComboBox marcaBox = new JComboBox();
    JComboBox fornitoreBox = new JComboBox();

    //elementi per pannello per aggiunta elementi
    JPanel aggiungiPanel = new JPanel();
    JPanel upperAggiungiPanel = new JPanel();
    JPanel lowerAggiungiPanel = new JPanel();
    JLabel nomeNuovoProdotto = new JLabel("Nome:");
    JLabel tipoNuovoProdotto = new JLabel("Tipo:");
    JLabel codiceNuovoProdotto = new JLabel("Codice:");
    JLabel contenutoNuovoProdotto = new JLabel("Contenuto:");
    JLabel marcaNuovoProdotto = new JLabel("Marca:");
    JLabel fornitoreNuovoProdotto = new JLabel("Fornitore:");
    JTextField nomeProdottoField = new JTextField(25);
    JTextField tipoProdottoField = new JTextField(15);
    JTextField codiceProdottoField = new JTextField(25);
    JTextField contenutoProdottoField = new JTextField(15);
    JTextField marcaProdottoField = new JTextField(15);
    JTextField fornitoreProdottoField = new JTextField(15);
    JButton aggiungiBtn = new JButton("Aggiungi");

    public GestioneProdottiFrame() {

        setLayout(new BorderLayout());
        upperPanel.setLayout(new BorderLayout());
        contentPanel.setLayout(new GridLayout(1, 2));
        risultatiPanel.setLayout(new BorderLayout());
        //risultatiPanel.add(risultatiScrollPane, BorderLayout.CENTER);
        //aggiunta elementi MenuBar
        menu.add(visualizza);
        menu.add(modifica);
        menu.add(aggiungi);
        menu.add(rimuovi);
        menuBar.add(menu);

        //creazione elementi pannello filtri
        JLabel nomeProdotto = new JLabel("Nome Prodotto:");
        JTextField nomeCampo = new JTextField(20);
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
        contentPanel.add(elementiPanel);
        add(upperPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);


        //-----------------------------------------//
        //sezione per aggiunta elementi al pannello AGGIUNGI PRODOTTO
        tipoBox.setPreferredSize(new Dimension(200, 25));
        marcaBox.setPreferredSize(new Dimension(200, 25));
        fornitoreBox.setPreferredSize(new Dimension(200, 25));

        aggiungiPanel.setLayout(new BorderLayout(5, 5));
        upperAggiungiPanel.setBorder(BorderFactory.createTitledBorder("Aggiungi un prodotto"));
        upperAggiungiPanel.add(nomeNuovoProdotto);
        upperAggiungiPanel.add(nomeProdottoField);
        upperAggiungiPanel.add(tipoNuovoProdotto);
        upperAggiungiPanel.add(tipoBox);
        upperAggiungiPanel.add(codiceNuovoProdotto);
        upperAggiungiPanel.add(codiceProdottoField);
        upperAggiungiPanel.add(contenutoNuovoProdotto);
        upperAggiungiPanel.add(contenutoProdottoField);
        upperAggiungiPanel.add(marcaNuovoProdotto);
        upperAggiungiPanel.add(marcaBox);
        upperAggiungiPanel.add(fornitoreNuovoProdotto);
        upperAggiungiPanel.add(fornitoreBox);
        aggiungiBtn.setPreferredSize(new Dimension(200, 25));
        lowerAggiungiPanel.add(aggiungiBtn);
        aggiungiPanel.add(upperAggiungiPanel, BorderLayout.NORTH);
        aggiungiPanel.add(lowerAggiungiPanel, BorderLayout.SOUTH);

    }

    //metodi get
    public JTable getRisultatiTable() {return risultatiTable;}
    public JButton getCercaPerNomeBtn() {return cercaPerNomeBtn;}
    public JMenuItem getModifica() {return modifica;}
    public JMenuItem getAggiungi() {return aggiungi;}
    public JMenuItem getRimuovi() {return rimuovi;}
    public JMenuItem getVisualizza() {return visualizza;}
    public JButton getSalvaModificheBtn() {return salvaModificheBtn;}
    public JPanel getElementiPanel() {return elementiPanel;}
    public JPanel getContentPanel() {return contentPanel;}
    public JPanel getRisultatiPanel() {return risultatiPanel;}


    //metodi get e set per aggiungi panel
    public JPanel getAggiungiPanel() {return aggiungiPanel;}
    public JButton getAggiungiBtn() {return aggiungiBtn;}
    public JLabel getNomeNuovoProdotto() {return nomeNuovoProdotto;}
    public JLabel getTipoNuovoProdotto() {return tipoNuovoProdotto;}
    public JLabel getCodiceNuovoProdotto() {return codiceNuovoProdotto;}
    public JLabel getContenutoNuovoProdotto() {return contenutoNuovoProdotto;}
    public JLabel getMarcaNuovoProdotto() {return marcaNuovoProdotto;}
    public JLabel getFornitoreNuovoProdotto() {return fornitoreNuovoProdotto;}
    public JTextField getNomeProdottoField() {return nomeProdottoField;}
    public JTextField getTipoProdottoField() {return tipoProdottoField;}
    public JTextField getCodiceProdottoField() {return codiceProdottoField;}
    public JTextField getContenutoProdottoField() {return contenutoProdottoField;}
    public JTextField getMarcaProdottoField() {return marcaProdottoField;}
    public JTextField getFornitoreProdottoField() {return fornitoreProdottoField;}
    public JComboBox getTipoProdotto() {return tipoBox;}
    public JComboBox getMarcaProdotto() {return marcaBox;}
    public JComboBox getFornitoreProdotto() {return fornitoreBox;}

    public void setAggiungiPanel(JPanel aggiungiPanel) {this.aggiungiPanel = aggiungiPanel;}
    public void setNomeProdottoField(JTextField textField) {this.nomeProdottoField = textField;}
    public void setCodiceProdottoField(JTextField textField) {this.codiceProdottoField = textField;}

}
