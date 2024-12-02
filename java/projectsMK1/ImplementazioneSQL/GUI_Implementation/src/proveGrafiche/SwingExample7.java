package proveGrafiche;

import javax.swing.*;

public class SwingExample7 {

    public static void main(String[] args) {

        //creazione di un oggetto finestra(JFrame)
        JFrame frame = new JFrame("Finestra con etichetta");
        //imposta dimensioni della finestra
        frame.setSize(600, 400);
        //imposta la posizione della finestra sullo schermo
        frame.setLocationRelativeTo(null);
        //impostazione per l'operazione predefinita di chiusura
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creazione pannello tabulare
        JTabbedPane tabbedPane = new JTabbedPane();
        //creazione pannelli per il tab
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        //aggiungiamo elementi ai pannelli
        panel1.add(new JLabel("Contenuto Tab 1"));
        panel2.add(new JLabel("Contenuto Tab 2"));
        panel3.add(new JLabel("Contenuto Tab 3"));

        //aggiunta singol pannelli al TabbedPane

        //Rende visibile la finestra
        frame.setVisible(true);
    }
}
