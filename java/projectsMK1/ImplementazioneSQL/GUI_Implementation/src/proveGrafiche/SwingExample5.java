package proveGrafiche;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample5 {

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
        //creazione di un pulsante
        JButton button = new JButton("Clicca qui");

        //Array di elementi
        String[] data = {"elemento 1", "elemento 2", "elemento 3", "elemento 2", "elemento 2", "elemento 2",
                "elemento 2", "elemento 2", "elemento 2", "elemento 2", "elemento 2", "elemento 2", "elemento 2",
                "elemento 2", "elemento 2", "elemento 2","elemento 2","elemento 2","elemento 2","elemento 2","elemento 2",};
        //creazione oggetto lista
        JList<String> list = new JList<>(data);
        //impostazione modalita di scelta
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //creazione pannello scrollbar
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane);
        //Rende visibile la finestra
        frame.setVisible(true);
    }
}
