package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GestioneFornitoriFrame extends JPanel{

    //elementi per pannello per visualizzare, modificare e rimuovere
    JPanel filtriPanel = new JPanel();
    JPanel upperFiltri = new JPanel();
    JPanel lowerFiltri = new JPanel();
    JPanel risultatiPanel = new JPanel();
    JPanel elementiPanel = new JPanel();
    JPanel contentPanel = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu Gestione Fornitori");
    JMenuItem visualizza = new JMenuItem("Visualizza tutti i fornitori");
    static JMenuItem modifica = new JMenuItem("Modifica fornitore");
    JMenuItem aggiungi = new JMenuItem("Aggiungi nuovo fornitore");
    static JMenuItem rimuovi = new JMenuItem("Rimuovi fornitore permanentemente");
    JPanel upperPanel = new JPanel();
    JTable risultatiTable = new JTable();
    JScrollPane risultatiScrollPane = new JScrollPane(risultatiTable);


    //elementi per pannello per aggiunta elementi
    JPanel aggiungiPanel = new JPanel();
    JPanel upperAggiungiPanel = new JPanel();
    JPanel lowerAggiungiPanel = new JPanel();
    JLabel nomeNuovoFornitore = new JLabel("Nome Fornitore:");
    JLabel rappresentanteNuovoFornitore = new JLabel("Nome Rappresentante:");
    JLabel contattoNuovoFornitore = new JLabel("Contatto telefonico Fornitore:");
    JLabel emailNuovoFornitore = new JLabel("Email Fornitore:");
    JLabel idFornitoreLabel = new JLabel("ID");
    JTextField idFornitoreField = new JTextField();
    JTextField nomeNuovoFornitoreField = new JTextField(20);
    JTextField rappresentanteNuovoField = new JTextField(20);
    JTextField contattoNuovoField = new JTextField(20);
    JTextField emailNuovoField = new JTextField(20);
    JButton aggiungiBtn = new JButton("Aggiungi");

    //elementi per pannello superiore modifica elementi
    JPanel modificaPanel = new JPanel();
    JPanel modificaLowerPanel = new JPanel();
    JPanel modificaUpperPanel = new JPanel();
    JButton salvaModificheBtn = new JButton("Salva modifiche");
    JLabel modificaNomeLabel = new JLabel("Nome fornitore:");
    JLabel modificaRappresentanteLabel = new JLabel("Nome Rappresentante:");
    JLabel modificaEmailLabel = new JLabel("Email Fornitore:");
    JLabel modificaContattoLabel = new JLabel("Contatto telefonico Fornitore:");
    JTextField modificaNomeField = new JTextField(20);
    JTextField modificaRappresentanteField = new JTextField(20);
    JTextField modificaEmailField = new JTextField(20);
    JTextField modificaContattoField = new JTextField(20);

    ImageIcon imageIcon;
    JLabel imageLabel;

    public GestioneFornitoriFrame() {

        setLayout(new BorderLayout());
        upperPanel.setLayout(new BorderLayout());
        //contentPanel.setLayout(new GridLayout(1,1));
        risultatiPanel.setLayout(new BorderLayout());
        //risultatiTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        idFornitoreField.setEditable(false);
        risultatiPanel.add(risultatiScrollPane, BorderLayout.CENTER);

        //aggiunta elementi MenuBar
        menu.add(visualizza);
        menu.add(modifica);
        menu.add(aggiungi);
        menu.add(rimuovi);
        menuBar.add(menu);

        //creazione elementi pannello filtri
        JLabel nomeFornitoreFiltro = new JLabel("Nome Fornitore:");
        JTextField nomeFornitoreField = new JTextField(10);
        JLabel rappresentanteFornitoreFiltro = new JLabel("Nome Rappresentante:");
        JTextField rappresentanteField = new JTextField(10);
        filtriPanel.setLayout(new BorderLayout(5, 5));
        upperFiltri.setLayout(new FlowLayout());

        //-----------------------------------------//
        //sezione per aggiunta elementi al pannello AGGIUNGI PRODOTTO
        aggiungiPanel.setLayout(new BorderLayout(5, 5));
        upperAggiungiPanel.setBorder(BorderFactory.createTitledBorder("Aggiungi un fornitore"));
        upperAggiungiPanel.add(nomeNuovoFornitore);
        upperAggiungiPanel.add(nomeNuovoFornitoreField);
        upperAggiungiPanel.add(rappresentanteNuovoFornitore);
        upperAggiungiPanel.add(rappresentanteNuovoField);
        upperAggiungiPanel.add(contattoNuovoFornitore);
        upperAggiungiPanel.add(contattoNuovoField);
        upperAggiungiPanel.add(emailNuovoFornitore);
        upperAggiungiPanel.add(emailNuovoField);
        aggiungiBtn.setPreferredSize(new Dimension(200, 25));
        lowerAggiungiPanel.add(aggiungiBtn);
        aggiungiPanel.add(upperAggiungiPanel, BorderLayout.NORTH);
        aggiungiPanel.add(lowerAggiungiPanel, BorderLayout.SOUTH);
        //add(aggiungiPanel, BorderLayout.NORTH);

        //SEZIONE MODIFICA aggiunta elementi a pannelli
        modificaUpperPanel.add(idFornitoreLabel);
        modificaUpperPanel.add(idFornitoreField);
        modificaUpperPanel.add(modificaNomeLabel);
        modificaUpperPanel.add(modificaNomeField);
        modificaUpperPanel.add(modificaRappresentanteLabel);
        modificaUpperPanel.add(modificaRappresentanteField);
        modificaUpperPanel.add(modificaContattoLabel);
        modificaUpperPanel.add(modificaContattoField);
        modificaUpperPanel.add(modificaEmailLabel);
        modificaUpperPanel.add(modificaEmailField);
        modificaLowerPanel.add(getSalvaModificheBtn());
        modificaPanel.setLayout(new BorderLayout());
        modificaPanel.add(modificaUpperPanel, BorderLayout.NORTH);
        modificaPanel.add(modificaLowerPanel, BorderLayout.SOUTH);

        upperPanel.add(menuBar, BorderLayout.NORTH);
        add(upperPanel, BorderLayout.NORTH);

        //sezione aggiunta immagine a pannello principale
        imageIcon = new ImageIcon("src/main/resources/images/black3.png");
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(2000, 1000, Image.SCALE_DEFAULT));
        imageLabel = new JLabel(imageIcon);
        contentPanel.add(imageLabel);
        add(contentPanel, BorderLayout.SOUTH);


    }

    public JMenuItem getAggiungi() {return aggiungi;}
    public static JMenuItem getModifica() {return modifica;}
    public static JMenuItem getRimuovi() {return rimuovi;}
    public JMenuItem getVisualizza() {return visualizza;}
    public JButton getAggiungiBtn(){return aggiungiBtn;}
    public JButton getSalvaModificheBtn(){return salvaModificheBtn;}
    public JPanel getRisultatiPanel(){return risultatiPanel;}
    public JPanel getUpperPanel(){return upperPanel;}
    public JPanel getContentPanel(){return contentPanel;}
    public JPanel getElementiPanel(){return elementiPanel;}
    public JPanel getAggiungiPanel(){return aggiungiPanel;}
    public JPanel getLowerAggiungiPanel(){return lowerAggiungiPanel;}
    public JPanel getUpperAggiungiPanel(){return upperAggiungiPanel;}
    public JLabel getImageLabel(){return imageLabel;}
    public JLabel getIdFornitoreLabel(){return idFornitoreLabel;}
    public JTextField getIdFornitoreField(){return idFornitoreField;}
    public JTextField getNomeNuovoFornitoreField(){return nomeNuovoFornitoreField;}
    public JTextField getRappresentanteNuovoField(){return rappresentanteNuovoField;}
    public JTextField getEmailNuovoField(){return emailNuovoField;}
    public JTextField getContattoNuovoField(){return contattoNuovoField;}
    public JTable getRisultatiTable(){return risultatiTable;}
    public ImageIcon getImageIcon(){return imageIcon;}

    public JPanel getModificaPanel(){return modificaPanel;}
    public JTextField getModificaNomeField(){return modificaNomeField;}
    public JTextField getModificaRappresentanteField(){return modificaRappresentanteField;}
    public JTextField getModificaEmailField(){return modificaEmailField;}
    public JTextField getModificaContattoField(){return modificaContattoField;}
}
