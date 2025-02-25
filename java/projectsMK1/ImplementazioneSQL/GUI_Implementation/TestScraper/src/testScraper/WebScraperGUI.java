package testScraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;//contenitore del flusso dei dati
import java.io.InputStreamReader;  //uscita o ingresso di 010101


public class WebScraperGUI extends JFrame {

    private JTextField campoURL; //campo per inserire l'indirizzo URL
    private JTextField campParolaChiave;//testo per effettuare la ricerca
    private JTextArea areaRisultato;//visualizziamo i risultati della ricerca

    public WebScraperGUI() {
        //settings della nostra finestra
        setTitle("Web Scraper");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        //pannello per inserimento dati
        JPanel pannelloInput = new JPanel(new FlowLayout());
        JLabel etichettaURL = new JLabel("URL:");
        campoURL = new JTextField(30);
        campoURL.setText("https://");
        JLabel etichetaParolaChiave = new JLabel("Parola chiave:");
        campParolaChiave = new JTextField(20);
        JButton bottoneCerca = new JButton("Cerca");

        bottoneCerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerca();
            }
        });

        pannelloInput.add(etichettaURL);
        pannelloInput.add(campoURL);
        pannelloInput.add(etichetaParolaChiave);
        pannelloInput.add(campParolaChiave);
        pannelloInput.add(bottoneCerca);

        areaRisultato = new JTextArea();
        areaRisultato.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(areaRisultato);

        add(pannelloInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);


    }


    public static void main(String[] args) {
        new WebScraperGUI().setVisible(true);

    }

    //gestione logica ricerca
    public void cerca(){
        String url = campoURL.getText();
        String parolaChiave = campParolaChiave.getText();

        //controllo inserimento dei valori
        if (url.isEmpty() || parolaChiave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Inserisci URL o parola chiave.");
            return;
        }

        try {
            //scraping della pagina
            List<String> corrispondenze = eseguiScraping(url, parolaChiave);
            visualizzaRisultato(corrispondenze);

        } catch (IOException e){
            JOptionPane.showMessageDialog(this, "Errore: "+ e.getMessage());
        }


    }

    //metodo per gestione scraping
    private List<String> eseguiScraping(String url, String parolaChiave) throws IOException{
        List<String> corrispondenze = new ArrayList<>();
        URL paginaWeb = new URL(url);
        BufferedReader lettore = new BufferedReader(new InputStreamReader(paginaWeb.openStream()));
        String riga;
        while ((riga = lettore.readLine()) != null){
            if (riga.contains(parolaChiave)){
                corrispondenze.add(riga);
            }
        }

        lettore.close();
        return corrispondenze;
    }

    //metodo per visualizzare i risultati
    private void visualizzaRisultato(List<String> corrispondenze){
        areaRisultato.setText("");
        if (corrispondenze.isEmpty()){
            areaRisultato.append("Nessuna corrispondenza trovata.");
        } else {
            for (String corrispondenza : corrispondenze){
                areaRisultato.append(corrispondenza+ "\n");
            }
        }

    }

}