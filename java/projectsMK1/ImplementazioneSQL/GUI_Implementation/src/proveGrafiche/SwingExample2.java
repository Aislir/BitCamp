package proveGrafiche;

import javax.swing.*;

public class SwingExample2 {

    public static void main(String[] args) {
        //creazione di un oggetto finestra(JFrame)
        JFrame frame = new JFrame("Finestra con etichetta");
        //imposta dimensioni della finestra
        frame.setSize(600, 400);
        //imposta la posizione della finestra sullo schermo
        frame.setLocationRelativeTo(null);
        //impostazione per l'operazione predefinita di chiusura
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //prima di mostrare la finestra, la popoliamo con elementi interni
        //Creazione dell'oggetto etichetta
        JLabel label = new JLabel("Ciao Programmatori BitCamp!");

        //aggiunta dell'oggetto creato alla finestra
        frame.add(label);

        //Rende visibile la finestra
        frame.setVisible(true); //questo deve essere sempre l'ultimo comando
    }
}