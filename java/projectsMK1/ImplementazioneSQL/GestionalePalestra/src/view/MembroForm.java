package view;

import javax.swing.*;
import java.awt.*;

public class MembroForm extends JFrame {

    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField emailField;
    private JTextField dataIscrizione;
    private JButton salvaButton;


    public MembroForm(){
        //setting finestra
        setTitle("Nuovo Membro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //chiude solo la finestra corrente ma non il programma
        setSize(300, 200);
        setLayout(new GridLayout(4,2));

        //aggiunta dei componenti
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Cognome"));
        cognomeField = new JTextField();
        add(cognomeField);

        add(new JLabel("Email"));
        emailField = new JTextField();
        add(emailField);

        salvaButton = new JButton("Salva");
        add(salvaButton);
    }

    //metodi get per accedere a campi e bottone
    public JTextField getNomeField(){return nomeField;}
    public JTextField getCognomeField(){return cognomeField;}
    public JTextField getEmailField(){return emailField;}
    public JButton getSalvaButton(){return salvaButton;}
    public JTextField getDataIscrizione(){return dataIscrizione;}
}
