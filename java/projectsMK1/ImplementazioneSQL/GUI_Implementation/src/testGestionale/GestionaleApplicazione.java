package testGestionale;

import javax.swing.*;
import java.awt.*;

public class GestionaleApplicazione extends JFrame {

    //costruttore della classe che inizializza la grafica
    public GestionaleApplicazione(){
        setTitle("Prima Applicazione Gestionale");
        setSize(1200, 800); //dimensione finestra iniziale
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //pannello principale dell'applicazione
        JPanel mainPanel = new JPanel(new BorderLayout()); //borderLayout permette di posizionare gli elementi in tutti le possibili direzioni (sotto, sopra, destra, sinistra, centro)

        //pannello per il menu
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(200, 800));
        menuPanel.setBackground(Color.LIGHT_GRAY);

        //creazione bottoni per pannello menu
        JButton clientiButton = new JButton("Clienti");
        JButton fornitoriButton = new JButton("Fornitori");
        JButton prodottiButton = new JButton("Prodotti");
        JButton venditeButton = new JButton("Vendite");
        JButton fattureButton = new JButton("Fatture");

        //aggiungiamo i bottoni al menu nell'ordine con cui li vogliamo visualizzare
        menuPanel.add(venditeButton);
        menuPanel.add(fattureButton);
        menuPanel.add(prodottiButton);
        menuPanel.add(clientiButton);
        menuPanel.add(fornitoriButton);

        //Pannello principale contenuti
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        //aggiunta componenti al pannello principale
        JLabel titleLabel = new JLabel("Benvenuto nel nostro software gestionale");
        titleLabel.setFont((new Font("Arial", Font.BOLD, 24))); //formattazione testo della label
        contentPanel.add(titleLabel, BorderLayout.NORTH); //posizioniamo la label in alto

        //textarea in cui andremo a visualizzare le info
        JTextArea placeholderArea = new JTextArea(20,80);
        placeholderArea.setEditable(false); //non e' possibile scriverci o modificare, solo visualizzare
        placeholderArea.setText("Questo e' un esempio di come potrebbe apparire il contenuto");
        contentPanel.add(placeholderArea, BorderLayout.CENTER);

        //aggiunta di un pannello per eventuali grafici
        JPanel chartPanel = new JPanel();
        chartPanel.setPreferredSize(new Dimension(800, 400));
        chartPanel.setBackground(Color.YELLOW);
        JLabel chartLabel = new JLabel("Grafici");
        chartPanel.add(chartLabel);
        contentPanel.add(chartPanel, BorderLayout.SOUTH);

        //aggiunta dei singoli pannelli all'interno del pannello principale
        mainPanel.add(menuPanel, BorderLayout.EAST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        //aggiunta del pannello principale al frame
        add(mainPanel);



    }


    public static void main(String[] args) {
        //gestire il multithreading in swing (apertura di piu' finestre contemporaneamente)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionaleApplicazione().setVisible(true);
            } //dice al programma di lanciare un'altra istanza
        }); // su un altro thread dove possibile

        //creazione istanza della finestra del gestionale
        //new GestionaleApplicazione().setVisible(true);
    }
}
