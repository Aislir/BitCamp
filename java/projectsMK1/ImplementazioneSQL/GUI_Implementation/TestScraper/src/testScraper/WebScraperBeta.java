package testScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebScraperBeta {

    public static void main(String[] args) {
        String url = "https://www.bitcamp.it";

        try {
            //connessione e recupero del DOM dall'url passato
            Document doc = Jsoup.connect(url).get();

            //esempio di estrazione di testo da un elemento con uno specifico ID
            Element elementoSpecifico = doc.getElementById("form-corso-full");
            String elementoCatturato = elementoSpecifico.text();
            System.out.println("Testo dell'elemento id scelto: "+elementoCatturato);

            Elements elementiClasse = doc.getElementsByClass("text");
            for(Element element : elementiClasse) {
                System.out.println("Estrapolato: "+element.text());
            }

        }catch(IOException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
