package view;


import javax.swing.*;
import java.awt.*;

public class ModificaMembroForm extends JFrame{

    private JTextField idMembroField;
    private JTextField nomeField;
    private JTextField cognomeField;
    private JTextField emailField;
    private JTextField dataIscrizione;
    private JButton modificaMembroButton;

    public ModificaMembroForm(){
        setTitle("Modifica Membro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //chiude solo la finestra corrente ma non il programma
        setSize(300, 200);
        setLayout(new GridLayout(5,2));

        add(new JLabel("ID Membro:"));
        idMembroField = new JTextField();
        add(idMembroField);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Cognome"));
        cognomeField = new JTextField();
        add(cognomeField);

        add(new JLabel("Email"));
        emailField = new JTextField();
        add(emailField);

        modificaMembroButton = new JButton("Modifica");
        add(modificaMembroButton);
    }

    public JButton getModificaMembroButton(){return modificaMembroButton;}
    public JTextField getNomeField(){return nomeField;}
    public JTextField getCognomeField(){return cognomeField;}
    public JTextField getEmailField(){return emailField;}
    public JTextField getIdMembroField(){return idMembroField;}

}
