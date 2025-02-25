package BiglietteriaWeb;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        //gestione richiesta GET pagina HOME
        server.createContext("/", new HomePageHandler());

        //gestione richiesta vendita biglietti
        server.createContext("/venditaBiglietto", new VenditaBigliettoHandler());

        //server visualizzazione riepilogo biglietti
        server.createContext("/riepilogoBiglietti", new RiepilogoBigliettiHandler());

        //avvio server
        server.start();
        System.out.println("Server per la gestione della biglietteria avviato su porta 8080");

    }

    static class VenditaBigliettoHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            //get o post?
            if (exchange.getRequestMethod().equalsIgnoreCase("GET")){
                //creazione DOM con il form per vendita del biglietto
                String htmlResponse = "<html><head><title>Vendita biglietti</title></head>"
                        +"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>"
                        +"<style>" +
                        "   body{" +
                        "   background-image: url('https://media.meer.com/attachments/7725bcd94bc0c8c2ce869c13a78ea1fabf73f134/store/fill/1090/613/4685b5227116ad2c93693dbe5655b2d30d7daee84bbab531998b864b7166/Stazione-treno-Luogo-reale-eppure-simile-alla-leggenda.jpg');" +
                        "   background-size: cover;" +
                        "   background-position: center;" +
                        "   height: 100vh;" +
                        "   color: white;" +
                        "   }" +
                        "   .container{" +
                        "   padding-top: 50px;" +
                        "   }" +
                        "</style>"
                        +"</head>"
                        +"<body>"
                        +"<div class='container'><h1 class='mt-5'>Vendita Biglietto</h1>"
                        +"<form id='venditaForm' class='mt-3' method='post' action='/venditaBiglietto'>" +
                        "<div class='form-group'>" +
                        "<label for='data'>Nome:</label>"
                        +"<input type='date' class='form-control' id='data' name='nome'><br>" +
                        "</div>" +
                        "<div class='form-group'>"+
                        "<label for='destinazione'>Destinazione:</label>"
                        +"<input type='text' class='form-control' id='destinazione' name='destinazione'><br>"+
                        "</div>" +
                        "<div class='form-group'>"+
                        "<label for='prezzo'>Prezzo:</label>"
                        +"<input type='text' class='form-control' id='prezzo' name='prezzo'><br>"+
                        "</div>"
                        +"<button type='submit' class='btn btn-primary'>Vendi Biglietto</button>"
                        +"</form>" +
                        "</div>" +
                        "</body>" +
                        "</html>";

                //imposta l'intestazione per la risposta al browser
                exchange.getResponseHeaders().set("Content-Type", "text/html");
                //imposta lo status code e la lunghezza
                exchange.sendResponseHeaders(200, htmlResponse.length());

                //chiamata della libreria per la gestione dello stream dati
                OutputStream os = exchange.getResponseBody();
                os.write(htmlResponse.getBytes());
                os.close();
            } else if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                //recuperiamo i dati inviati dal form
                InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
                //Stringa di testo per contenere bufferedReader
                String formData = br.readLine(); //questa stringa adesso contiente tutte le info inviate
                //separate dalla "&". Usiamo quindi lo split con la "&" come parametro per dividere le
                //info e le mettiamo dentro un Array monodimensionale, dove ogni indice contiene una info
                String[] formDataArray = formData.split("&");
                //a questo punto pero' ogni indice contiene il valore con la sua label.
                //Es: "data=2024-12-07". Per fare in modo di avere solo il valore, usiamo uno split con
                //"=" come parametro, e gli diciamo di andare a prendere solo quella stringa che adesso
                //e' all'indice 1, ovvero "2024-12-07"
                String data = formDataArray[0].split("=")[1];
                String destinazione = formDataArray[1].split("=")[1];
                double prezzo = Double.parseDouble(formDataArray[2].split("=")[1]);

                //connessione e scrittura sul database
                try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biglietteria", "root", "0104")){
                    String query = "INSERT INTO biglietti (data, destinazione, prezzo) VALUES(?,?,?)";
                    try(PreparedStatement pstmt = connection.prepareStatement(query)){
                        pstmt.setString(1, data);
                        pstmt.setString(2, destinazione);
                        pstmt.setDouble(3, prezzo);
                        pstmt.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                    //dopo l'inserimento del biglietto nel DB, riportiamo il client sulla home
                    exchange.getResponseHeaders().set("Location", "/");
                    exchange.sendResponseHeaders(302, -1);
                } else {
                //se la richiesta non e' GET  o POST, manda il cod 405, ovvero indica che non e' un metodo consentito
                exchange.sendResponseHeaders(405, -1);
            }
        }
    }

    static class RiepilogoBigliettiHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            //connessione al DB e recupero biglietti
            List<String> biglietti = new ArrayList<>();
            try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biglietteria", "root", "0104")){
                String query = "SELECT * FROM biglietti";
                try(PreparedStatement pstmt = connection.prepareStatement(query)){
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()){
                        String data = rs.getString("data");
                        String destinazione = rs.getString("destinazione");
                        double prezzo = rs.getDouble("prezzo");

                        //aggiungiamo elementi all'array
                        biglietti.add("Data: "+data+" - Destinazione: "+destinazione+" - Prezzo: "+prezzo);
                    }
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            //preparazione della risposta HTML
            StringBuilder response = new StringBuilder();
            response.append("<html><body>");
            response.append("<h1>Riepilogo Biglietti Venduti:</h1>");
            for (String biglietto : biglietti){
                response.append("<p>").append(biglietto).append("</p>");
            }
            response.append("</body></html>");

            //prepariamo l'intestazione ed il flusso dati per il client
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        }
    }

    static class HomePageHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            String htmlResponse = "<html><head><title>Biglietteria della Stazione</title></head>"
                    +"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>"
                    +"<style>" +
                    "   body{" +
                    "   background-image: url('https://media.meer.com/attachments/7725bcd94bc0c8c2ce869c13a78ea1fabf73f134/store/fill/1090/613/4685b5227116ad2c93693dbe5655b2d30d7daee84bbab531998b864b7166/Stazione-treno-Luogo-reale-eppure-simile-alla-leggenda.jpg');" +
                    "   background-size: cover;" +
                    "   background-position: center;" +
                    "   height: 100vh;" +
                    "   color: white;" +
                    "   }" +
                    "   .container{" +
                    "   padding-top: 50px;" +
                    "   }" +
                    "</style>"
                    +"</head>"
                    +"<body>" +
                    "<h1>Benvenuto nella Biglietteria della Stazione</h1>" +
                    "<ul>" +
                    "<li><a href='/venditaBiglietto'>Prenota il tuo biglietto</a></li>" +
                    "<li><a href='/riepilogoBiglietti'>Visualizza i biglietti venduti</a></li>" +
                    "</ul>" +
                    "</body>" +
                    "</html>";

            //imposta la risposta al client
            exchange.getResponseHeaders().set("Content-Type", "text/html");
            //imposta status code
            exchange.sendResponseHeaders(200, htmlResponse.length());
            //scrive il flusso dati
            OutputStream os = exchange.getResponseBody();
            os.write(htmlResponse.getBytes());
            os.close();
        }
    }

}
