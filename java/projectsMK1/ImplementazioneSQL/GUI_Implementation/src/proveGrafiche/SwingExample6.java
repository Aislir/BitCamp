package proveGrafiche;

import javax.swing.*;

public class SwingExample6 {

    public static void main(String[] args) {

        //creazione di un oggetto finestra(JFrame)
        JFrame frame = new JFrame("Finestra con menu testuale");
        //imposta dimensioni della finestra
        frame.setSize(600, 400);
        //imposta la posizione della finestra sullo schermo
        frame.setLocationRelativeTo(null);
        //impostazione per l'operazione predefinita di chiusura
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creazione oggetto contenitore della barra dei menu
        JMenuBar menuBar = new JMenuBar();
        //creazione della singola voce presente nella barra dei menu
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        //creazione voci del singolo menu
        //voci del menu File
        JMenuItem nuovoItem = new JMenuItem("Nuovo");
        JMenuItem apriItem = new JMenuItem("Apri");
        JMenuItem esciItem = new JMenuItem("Esci");

        //voci del menu Edit
        JMenuItem copiaItem = new JMenuItem("Copia");
        JMenuItem incollaItem = new JMenuItem("Incolla");

        //aggiunta delle voci del menu al menu
        fileMenu.add(nuovoItem);
        fileMenu.add(apriItem);
        fileMenu.addSeparator();
        fileMenu.add(esciItem);
        editMenu.add(copiaItem);
        editMenu.add(incollaItem);

        //aggiunta menu completi a barra menu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //inserimento menu nel frame
        frame.setJMenuBar(menuBar);

        //Rende visibile la finestra
        frame.setVisible(true);
    }
}
