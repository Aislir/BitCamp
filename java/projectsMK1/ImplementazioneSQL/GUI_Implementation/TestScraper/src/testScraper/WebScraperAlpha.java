package testScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class WebScraperAlpha {

    public static void main(String[] args) {
        String url = "https://www.bitcamp.it";

        try {
            //connessione e recupero del DOM dall'url passato
            Document doc = Jsoup.connect(url).get();

            //estraiamo porzioni specifiche dai tag del DOM
            String title = doc.title();
            String body = doc.body().text();//.text perchè bisogna convertire tutto in testo

            //stampa degli elementi recuperati
            System.out.println("Titolo: " + title);
            System.out.println("\nCorpo: " + body);

        }catch(IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }

    }

}
