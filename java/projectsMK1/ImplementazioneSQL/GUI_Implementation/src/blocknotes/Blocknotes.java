package blocknotes;

import testGestionale.GestionaleApplicazione;

import javax.swing.*;
import java.awt.*;

public class Blocknotes extends JFrame{

    public Blocknotes(){

        setTitle("Blocknotes");
        setSize(800, 600); //dimensione finestra iniziale
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //pannello principale dell'applicazione
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        JMenuItem nuovoItem = new JMenuItem("Nuovo");
        JMenuItem apriItem = new JMenuItem("Apri");
        JMenuItem esciItem = new JMenuItem("Esci");

        JMenuItem copiaItem = new JMenuItem("Copia");
        JMenuItem incollaItem = new JMenuItem("Incolla");

        fileMenu.add(nuovoItem);
        fileMenu.add(apriItem);
        fileMenu.addSeparator();
        fileMenu.add(esciItem);
        editMenu.add(copiaItem);
        editMenu.add(incollaItem);

        JMenu sottomenu = new JMenu("Sottomenu");
        JMenuItem elemento1 = new JMenuItem("elemento1");
        JMenuItem elemento2 = new JMenuItem("elemento2");
        JMenuItem elemento3 = new JMenuItem("elemento3");
        JMenuItem elemento4 = new JMenuItem("elemento4");

        sottomenu.add(elemento1);
        sottomenu.add(elemento2);
        sottomenu.add(elemento3);
        sottomenu.add(elemento4);

        fileMenu.add(sottomenu);


        JPanel contentPanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10, 10);

        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPanel.add(scrollPane);
        //contentPanel.add(textArea, BorderLayout.CENTER);
        add(contentPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setSize(800, 25);
        bottomPanel.setLayout(new GridLayout(1, 3));
        JLabel fileEncoding = new JLabel("UTF-8");
        JLabel riga = new JLabel("Riga X");
        JLabel colonna = new JLabel("Riga Y");
        JLabel formato = new JLabel("100%");

        bottomPanel.add(fileEncoding);
        bottomPanel.add(riga);
        bottomPanel.add(colonna);
        bottomPanel.add(formato);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        //aggiunta menu completi a barra menu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);



    }




    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Blocknotes().setVisible(true);
            } //dice al programma di lanciare un'altra istanza
        });
    }
}
