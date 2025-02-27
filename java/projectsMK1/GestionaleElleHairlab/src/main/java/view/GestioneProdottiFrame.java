package view;

import model.Fornitore;
import model.Marca;
import model.TipoProdotto;

import javax.swing.*;
import java.awt.*;

//classe per aggiunta, modifica, rimozione (dal database) e visualizzazione dei prodotti
public class GestioneProdottiFrame extends JPanel{

    //elementi per pannello per visualizzare
    JPanel filtriPanel = new JPanel();
    JPanel upperFiltri = new JPanel();
    JPanel lowerFiltri = new JPanel();
    JPanel risultatiPanel = new JPanel();
    JPanel elementiPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu Gestione Prodotti");
    JMenuItem visualizza = new JMenuItem("Visualizza tutti i prodotti");
    static JMenuItem modifica = new JMenuItem("Modifica prodotto");
    JMenuItem aggiungi = new JMenuItem("Aggiungi nuovo prodotto");
    static JMenuItem rimuovi = new JMenuItem("Rimuovi prodotto permanentemente");
    JButton cercaPerNomeBtn = new JButton("Cerca");
    JButton cercaPerTipoBtn = new JButton("Cerca");
    JButton cercaPerCodiceBtn = new JButton("Cerca");
    JButton cercaConFiltriBtn = new JButton("Cerca con filtri inseriti");
    JPanel upperPanel = new JPanel();
    JTable visualizzaTable = new JTable();
    JScrollPane risultatiScrollPane = new JScrollPane(visualizzaTable);
    TipoProdotto tipoProdotto;
    //ComboBox per tipo, marca e fornitore
    JComboBox<TipoProdotto> tipoBox = new JComboBox<>(TipoProdotto.values());
    JComboBox<Marca> marcaBox = new JComboBox(Marca.values());
    JComboBox<String> fornitoreBox = new JComboBox<>();

    //elementi per pannello per aggiunta elementi
    JPanel aggiungiPanel = new JPanel();
    JPanel upperAggiungiPanel = new JPanel();
    JPanel lowerAggiungiPanel = new JPanel();
    JLabel nomeProdottoLabel = new JLabel("Nome:");
    JLabel tipoProdottoLabel = new JLabel("Tipo:");
    JLabel codiceProdottoLabel = new JLabel("Codice:");
    JLabel contenutoProdottoLabel = new JLabel("Contenuto:");
    JLabel marcaProdottoLabel = new JLabel("Marca:");
    JLabel fornitoreProdottoLabel = new JLabel("Fornitore:");
    JTextField nomeProdottoField = new JTextField(20);
    JTextField codiceProdottoField = new JTextField(20);
    JTextField contenutoProdottoField = new JTextField(15);
    JButton aggiungiBtn = new JButton("Aggiungi");

    //elementi per pannello superiore modifica elementi
    JPanel modificaPanel = new JPanel();
    JPanel modificaLowerPanel = new JPanel();
    JPanel modificaUpperPanel = new JPanel();
    JButton salvaModificheBtn = new JButton("Salva modifiche");
    JLabel modificaNomeLabel = new JLabel("Nome:");
    JLabel modificaCodiceLabel = new JLabel("Codice:");
    JLabel modificaContenutoLabel = new JLabel("Contenuto:");
    JLabel modificaFornitoreLabel = new JLabel("Fornitore:");
    JLabel modificaMarcaLabel = new JLabel("Marca:");
    JLabel modificaTipoLabel = new JLabel("Tipo:");
    JComboBox modificaFornitoreBox = new JComboBox();
    JComboBox modificaMarcaBox = new JComboBox();
    JComboBox modificaTipoBox = new JComboBox();
    JTextField modificaNomeField = new JTextField(20);
    JTextField modificaCodiceField = new JTextField(20);
    JTextField modificaContenutoField = new JTextField(15);

    ImageIcon imageIcon;
    JLabel imageLabel;

    public GestioneProdottiFrame() {

        setLayout(new BorderLayout());
        upperPanel.setLayout(new BorderLayout());
        contentPanel.setLayout(new GridLayout(1, 2));
        risultatiPanel.setLayout(new BorderLayout());
        risultatiPanel.add(risultatiScrollPane, BorderLayout.CENTER);
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


        upperPanel.add(menuBar, BorderLayout.NORTH);
        //upperPanel.add(filtriPanel, BorderLayout.SOUTH);
        //contentPanel.add(risultatiPanel);
        //contentPanel.add(elementiPanel);
        add(upperPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);


        //-----------------------------------------//
        //sezione per aggiunta elementi al pannello AGGIUNGI PRODOTTO
        tipoBox.setPreferredSize(new Dimension(200, 25));
        marcaBox.setPreferredSize(new Dimension(200, 25));
        fornitoreBox.setPreferredSize(new Dimension(200, 25));

        aggiungiPanel.setLayout(new BorderLayout(5, 5));
        upperAggiungiPanel.setBorder(BorderFactory.createTitledBorder("Aggiungi un prodotto"));
        upperAggiungiPanel.add(nomeProdottoLabel);
        upperAggiungiPanel.add(nomeProdottoField);
        upperAggiungiPanel.add(codiceProdottoLabel);
        upperAggiungiPanel.add(codiceProdottoField);
        upperAggiungiPanel.add(tipoProdottoLabel);
        upperAggiungiPanel.add(tipoBox);
        upperAggiungiPanel.add(contenutoProdottoLabel);
        upperAggiungiPanel.add(contenutoProdottoField);
        upperAggiungiPanel.add(marcaProdottoLabel);
        upperAggiungiPanel.add(marcaBox);
        upperAggiungiPanel.add(fornitoreProdottoLabel);
        upperAggiungiPanel.add(fornitoreBox);
        aggiungiBtn.setPreferredSize(new Dimension(200, 25));
        lowerAggiungiPanel.add(aggiungiBtn);
        aggiungiPanel.add(upperAggiungiPanel, BorderLayout.NORTH);
        aggiungiPanel.add(lowerAggiungiPanel, BorderLayout.SOUTH);

        //aggiunta immagine a pannello principale
        imageIcon = new ImageIcon("src/main/resources/images/black3.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(2000, 1000, Image.SCALE_DEFAULT));
        imageLabel = new JLabel(imageIcon);
        contentPanel.add(imageLabel);
        add(contentPanel, BorderLayout.SOUTH);
    }

    //metodi get
    public JTable getVisualizzaTable() {return visualizzaTable;}
    public JButton getCercaPerNomeBtn() {return cercaPerNomeBtn;}
    public static JMenuItem getModifica() {return modifica;}
    public JMenuItem getAggiungi() {return aggiungi;}
    public static JMenuItem getRimuovi() {return rimuovi;}
    public JMenuItem getVisualizza() {return visualizza;}
    public JButton getSalvaModificheBtn() {return salvaModificheBtn;}
    public JPanel getElementiPanel() {return elementiPanel;}
    public JPanel getContentPanel() {return contentPanel;}
    public JPanel getRisultatiPanel() {return risultatiPanel;}
    public ImageIcon getImageIcon() {return imageIcon;}
    public JLabel getImageLabel() {return imageLabel;}
    public JPanel getModificaPanel() {return modificaPanel;}
    public JTextField getModificaNomeField() {return modificaNomeField;}
    public JTextField getModificaCodiceField() {return modificaCodiceField;}
    public JTextField getModificaContenutoField() {return modificaContenutoField;}
    public JComboBox getModificaTipoBox() {return modificaTipoBox;}
    public JComboBox getModificaMarcaBox() {return modificaMarcaBox;}
    public JComboBox getModificaFornitoreBox() {return modificaFornitoreBox;}

    //metodi get e set per aggiungi panel
    public JPanel getAggiungiPanel() {return aggiungiPanel;}
    public JButton getAggiungiBtn() {return aggiungiBtn;}
    public JTextField getNomeProdottoField() {return nomeProdottoField;}
    public JTextField getCodiceProdottoField() {return codiceProdottoField;}
    public JTextField getContenutoProdottoField() {return contenutoProdottoField;}
    public JComboBox getTipoProdotto() {return tipoBox;}
    public JComboBox getMarcaProdotto() {return marcaBox;}
    public JComboBox getFornitoreProdotto() {return fornitoreBox;}

    public void setAggiungiPanel(JPanel aggiungiPanel) {this.aggiungiPanel = aggiungiPanel;}
    public void setNomeProdottoField(JTextField textField) {this.nomeProdottoField = textField;}
    public void setCodiceProdottoField(JTextField textField) {this.codiceProdottoField = textField;}

}
