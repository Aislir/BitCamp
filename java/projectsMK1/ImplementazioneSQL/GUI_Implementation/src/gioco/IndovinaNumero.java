package gioco;

import blocknotes.Blocknotes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class IndovinaNumero extends JFrame {

    private int numeroSegreto;
    private int tentativiRimasti = 10;
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton indovinaButton;

    public IndovinaNumero() {
        setTitle("Indovina il Numero con Bitcamp!");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Generazione randomica numero
        Random random = new Random();
        numeroSegreto = random.nextInt(100) + 1;

        //pannello principale per contenimento degli altri pannelli
        JPanel mainPanel = new JPanel(new BorderLayout());

        //Pannello per gestione input giocatore
        JPanel inputPanel = new JPanel();
        JLabel inputLabel = new JLabel("Indovina il numero (1 - 100)");
        inputField = new JTextField(10);
        //inserimento pannelli
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);

        //Pannello per il pulsante
        JPanel buttonPanel = new JPanel();
        indovinaButton = new JButton("Indovina");
        //gestione logica del bottone
        indovinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //metodo per controllo risposta
                controlloTentativo();
            }
        });
        //aggiungiamo il bottone al suo pannello
        buttonPanel.add(indovinaButton);
        //etichetta per il risultato
        resultLabel = new JLabel("Tentativi rimasti: " + tentativiRimasti);

        //assembliamo la finestra
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(resultLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void controlloTentativo() {
        if (tentativiRimasti > 0) {
            try {
                //getText ritorna il contenuto di inputField. Integer permette di prendere tale
                //valore e trasformarlo in int
                int numero = Integer.parseInt(inputField.getText());
                if (numero == numeroSegreto) {
                    resultLabel.setText("Complimenti, hai indovinato il numero!");
                } else if (numero < numeroSegreto) {
                    resultLabel.setText("Troppo basso. Riprova!");
                } else {
                    resultLabel.setText("Troppo alto. Riprova!");
                }
                tentativiRimasti--;
                resultLabel.setText(resultLabel.getText() + " Tentativi rimasti: " + tentativiRimasti);
                //facciamo il controllo qui perche' il decremento lo fa dopo aver inviato la risposta
                //e quindi dopo aver cliccato il bottone
                if (tentativiRimasti == 0){
                    resultLabel.setText("Hai esaurito i tentativi. Il numero segreto era: " + numeroSegreto);
                    indovinaButton.setEnabled(false);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Inserisci un valore valido.");
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IndovinaNumero().setVisible(true);
            } //dice al programma di lanciare un'altra istanza
        });
    }
}