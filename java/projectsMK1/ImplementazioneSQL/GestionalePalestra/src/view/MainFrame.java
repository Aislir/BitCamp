package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTable membriTable;
    private JButton aggiungiButton;
    private JButton rimuoviButton;
    private JButton modificaButton;
    private JPanel southPanel;

    //aggiungiamo nel costruttore gli elementi che vogliamo all'interno della finestra
    public MainFrame(){
        setTitle("Gestionale Palestra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        southPanel = new JPanel(new GridLayout(1, 3));
        add(southPanel, BorderLayout.SOUTH);

        membriTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(membriTable);
        add(scrollPane, BorderLayout.CENTER);

        aggiungiButton = new JButton("Aggiungi Membro");
        southPanel.add(aggiungiButton);

        rimuoviButton = new JButton("Rimuovi Membro");
        southPanel.add(rimuoviButton);

        modificaButton = new JButton("Modifica Membro");
        southPanel.add(modificaButton);

        // Caricamento dell'immagine
        ImageIcon immagine = new ImageIcon("/home/riky/Documents/sfondo.jpeg");// Specifica il percorso dell'immagine
        Image image = immagine.getImage().getScaledInstance(600, 50, Image.SCALE_SMOOTH);
        ImageIcon immagineScalata = new ImageIcon(image);
        // Creazione della JLabel con l'immagine
        JLabel labelConImmagine = new JLabel(immagineScalata);
        labelConImmagine.setHorizontalAlignment(JLabel.CENTER); // Allineamento orizzontale al centro
        labelConImmagine.setVerticalAlignment(JLabel.NORTH);   // Allineamento verticale al centro
        // Aggiunta della JLabel al frame
        add(labelConImmagine, BorderLayout.NORTH);

    }

    //metodi getter per interagire con gli elementi dell'interfaccia
    public JTable getMembriTable(){return membriTable;}

    public JButton getAggiungiButton(){return aggiungiButton;}
    public JButton getRimuoviButton(){return rimuoviButton;}
    public JButton getModificaButton(){return modificaButton;}

}
