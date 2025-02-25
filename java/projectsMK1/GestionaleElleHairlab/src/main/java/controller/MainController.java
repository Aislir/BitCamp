package controller;

import view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainController extends JFrame{
    CardLayout cardLayout = new CardLayout();
    JPanel cardPanel = new JPanel(); //pannello che cambia in base alla card
    JPanel mainPanel = new JPanel(new BorderLayout()); //pannello contenente card e menu
    JPanel buttonsMenu = new JPanel(new GridLayout(5, 1));
    JButton magazzinoButton = new JButton("Magazzino");
    JButton gestioneProdottiButton = new JButton("Gestione Prodotti");
    JButton DDTButton = new JButton("DDT");
    JButton gestioneFornitoriButton = new JButton("Gestione Fornitori");
    JButton storicoButton = new JButton("Storico");

    public MainController() {

        setTitle("Gestionale Elle Hairlab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1000);
        setLocationRelativeTo(null);

        //aggiunta bottoni al menu
        buttonsMenu.add(magazzinoButton);
        buttonsMenu.add(DDTButton);
        buttonsMenu.add(gestioneProdottiButton);
        buttonsMenu.add(gestioneFornitoriButton);
        buttonsMenu.add(storicoButton);

        cardPanel.setLayout(cardLayout);
        cardPanel.setBackground(Color.LIGHT_GRAY);

        //aggiunta menu al pannello principale
        mainPanel.add(buttonsMenu, BorderLayout.WEST);
        mainPanel.add(cardPanel, BorderLayout.CENTER);
        add(mainPanel);
        cardLayout.show(cardPanel, "principale");


        caricaFrame();
        setVisible(true);
    }

    public void caricaFrame(){
        magazzinoButton.addActionListener( e -> {
            //MagazzinoFrame magazzinoFrame = new MagazzinoFrame();
            MagazzinoController magazzinoController = new MagazzinoController();
            cardPanel.add(magazzinoController.magazzinoFrame, "magazzino");
            cardLayout.show(cardPanel, "magazzino");
            cardPanel.revalidate();
            cardPanel.repaint();

        });
        gestioneFornitoriButton.addActionListener(e -> {
            FornitoriController gestioneFornitori = new FornitoriController();
            cardPanel.add(gestioneFornitori.gestioneFornitoriFrame, "gestioneFornitori");
            cardLayout.show(cardPanel, "gestioneFornitori");
            cardPanel.revalidate();
            cardPanel.repaint();

        });
        gestioneProdottiButton.addActionListener(e -> {
            GestioneProdottiController gestioneProdottiController = new GestioneProdottiController();
            cardPanel.add(gestioneProdottiController.gestioneProdottiFrame, "gestioneProdotti");
            cardLayout.show(cardPanel, "gestioneProdotti");
            cardPanel.revalidate();
            cardPanel.repaint();
        });
        DDTButton.addActionListener(e -> {
            DDTFrame ddtFrame = new DDTFrame();
            cardPanel.add(ddtFrame, "ddt");
            cardLayout.show(cardPanel, "ddt");
            cardPanel.revalidate();
            cardPanel.repaint();
        });
        //mainFrame.getStoricoBtn().addActionListener(e -> openStoricoPanel());
        //mainFrame.getAppuntamentiBtn().addActionListener(e -> openAppuntamentiPanel());
    }

    public JFrame getFrame(){return this;}

}
