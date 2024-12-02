package proveGrafiche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample4 {

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
        //creazione oggetto campo di testo o input
        JTextField textField = new JTextField(50);
        //creazione oggetto etichetta
        JLabel label = new JLabel("Inserisci qualcosa: ");
        //gestione evento su invio campo input
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Hai scritto: "+textField.getText());
            }
        });

        JPanel panel= new JPanel();
        panel.add(label);
        panel.add(textField);
        frame.add(panel);

        //Rende visibile la finestra
        frame.setVisible(true);
    }
}
