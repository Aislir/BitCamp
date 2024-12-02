package proveGrafiche;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample3 {

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

        //gestione dell'evento sul click del bottone
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cosa accade al click?
                JOptionPane.showMessageDialog(frame, "Hai cliccato il pulsante!");
            }
        });
        frame.add(button);

        //Rende visibile la finestra
        frame.setVisible(true);

    }
}
