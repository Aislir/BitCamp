package view;

import javax.swing.*;
import java.awt.*;

public class RimuoviMembroForm extends JFrame{

    private JTextField idMembroField;
    private JButton rimuoviMembroButton;

    public RimuoviMembroForm(){
        setTitle("Rimuovi Membro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //chiude solo la finestra corrente ma non il programma
        setSize(300, 200);
        setLayout(new GridLayout(2,2));

        //aggiunta componenti
        add(new JLabel("Id membro:"));
        idMembroField = new JTextField();
        add(idMembroField);

        rimuoviMembroButton = new JButton("Rimuovi");
        add(rimuoviMembroButton);
    }

    public JTextField getIdMembroField(){return idMembroField;}
    public JButton getRimuoviMembroButton(){return rimuoviMembroButton;}

}
