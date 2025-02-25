package primoServer;

import com.sun.net.httpserver.HttpServer; //classe per creare un server HTTP
import com.sun.net.httpserver.HttpHandler; //per gestire richieste HTTP (get e post)
import com.sun.net.httpserver.HttpExchange; //per gestire il flusso dati
import java.io.*;
import java.net.InetSocketAddress; //per gestione indirizzo IP e porta


public class SimpleWelcomePage {



    public static void main(String[] args) throws IOException{
        //creazione di un serve HTTP sulla porta 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        //gestiamo gli handler per le richieste da parte del browser
        server.createContext("/", new WelcomePageHandler());

        //avvio del server
        server.start();
        System.out.println("Server in esecuzione sulla porta 8080.");


    }

    //classe per gestire la chiamata sul server quando digitiamo "/"
    static class WelcomePageHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            String htmlResponse = "<html>" +
                    "<head><title>Benvenuto sul Server</title></head>" +
                    "<body>" +
                    "<h1>Benvenuto!</h1>" +
                    "<p>Questa e' una semplice pagina di benvenuto</p>" +
                    "</body>" +
                    "</html>";

            //imposta l'intestazione della risposta
            exchange.getResponseHeaders().set("Content-Type", "text/html");

            //imposta lo status code e la lunghezza del contenuto che gli invio
            exchange.sendResponseHeaders(200, htmlResponse.length());

            //scrive la risposta al cliente in formatto stream (flusso di byte)
            OutputStream os = exchange.getResponseBody();

            //passiamo il contenuto della risposta (codice html) come array di byte a 'os'
            os.write(htmlResponse.getBytes());

            //chiudiamo lo streaming
            os.close();

        }
    }

}
