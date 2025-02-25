package view;

import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DDTFrame extends JPanel{
    JPanel filtriPanel = new JPanel(); //pannello contenuto in risultatiPanel
    JPanel upperPanel = new JPanel();
    JPanel risultatiPanel = new JPanel();
    JPanel tablePanel = new JPanel();
    JScrollPane tableScrollPane = new JScrollPane(tablePanel);
    JPanel elementiPanel = new JPanel(); //pannello prodotti DDT
    JPanel prodottiPanel = new JPanel(); //contenuto in elementiPanel
    JMenuBar opzioniMenuBar = new JMenuBar();
    //JMenu menuOpzioni = new JMenu("Opzioni");
    JButton aggiungiProdotto = new JButton("Aggiungi prodotto");
    JButton salvaDDT = new JButton("Registra DDT");
    JPanel contentPanel = new JPanel(); //pannello principale
    JMenuBar menuBarPrincipale = new JMenuBar(); //contenuto in upperPanel
    JMenu menu = new JMenu("Menu DDT");
    JMenuItem aggiungiDDT = new JMenuItem("Registra nuovo DDT");
    JMenuItem modificaDDT = new JMenuItem("Modifica DDT");
    JMenuItem storicoDDT = new JMenuItem("Visualizza storico DDT");
    JButton cercaPerRappresentanteBtn = new JButton("Cerca");
    JButton cercaConFiltriBtn = new JButton("Cerca con filtri inseriti");
    JButton salvaModificheBtn = new JButton("Salva modifiche");
    JTable risultatiTable = new JTable();
    JScrollPane risultatiScrollPane = new JScrollPane(risultatiTable);


    public DDTFrame(){
        setLayout(new BorderLayout());
        upperPanel.setLayout(new BorderLayout());
        contentPanel.setLayout(new GridLayout(1, 2));
        risultatiPanel.setLayout(new BorderLayout());

        //aggiunta elementi pannello centrale destro
        risultatiPanel.add(filtriPanel, BorderLayout.NORTH);
        risultatiPanel.add(tableScrollPane, BorderLayout.CENTER);

        //aggiunta elementi pannello centrale sinistro
        opzioniMenuBar.add(aggiungiProdotto);
        opzioniMenuBar.add(salvaDDT);
        elementiPanel.setLayout(new BorderLayout());
        elementiPanel.add(prodottiPanel, BorderLayout.CENTER);

        //aggiunta elementi menu principale
        menu.add(aggiungiDDT);
        menu.add(modificaDDT);
        menu.add(storicoDDT);
        menuBarPrincipale.add(menu);

        //aggiunta pannello contente label e textfield
        JLabel dataDDT = new JLabel("Data DDT:");
        JDateChooser chooserDDT = new JDateChooser();
        chooserDDT.setPreferredSize(new Dimension(200, 25));
        chooserDDT.setDateFormatString("dd/MM/yyyy");
        JLabel dataRegistrazione = new JLabel("Data Registrazione:");
        JDateChooser chooserRegistrazione = new JDateChooser();
        chooserRegistrazione.setDateFormatString("dd/MM/yyyy");
        chooserRegistrazione.setPreferredSize(new Dimension(200, 25));
        JLabel numeroDDT = new JLabel("Numero DDT:");
        JTextField numeroDDTField = new JTextField(15);
        JLabel selectFornitore = new JLabel("Seleziona Fornitore:");
        JComboBox comboBoxFornitore = new JComboBox();
        comboBoxFornitore.setPreferredSize(new Dimension(200, 25));


        //pannello in cui vanno tutti i field di input
        JPanel inputFieldsPanel = new JPanel();
        //aggiunta elementi al pannello
        inputFieldsPanel.add(dataDDT);
        inputFieldsPanel.add(chooserDDT);
        inputFieldsPanel.add(dataRegistrazione);
        inputFieldsPanel.add(chooserRegistrazione);
        inputFieldsPanel.add(numeroDDT);
        inputFieldsPanel.add(numeroDDTField);
        inputFieldsPanel.add(selectFornitore);
        inputFieldsPanel.add(comboBoxFornitore);
        upperPanel.add(inputFieldsPanel, BorderLayout.CENTER);
        upperPanel.add(menuBarPrincipale, BorderLayout.NORTH);
        upperPanel.add(opzioniMenuBar, BorderLayout.SOUTH);



        //aggiunta pannelli di destra e sinistra al pannello contenitore
        contentPanel.add(risultatiPanel);
        contentPanel.add(elementiPanel);
        //fine aggiunta pannelli
        add(upperPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);


    }

}
