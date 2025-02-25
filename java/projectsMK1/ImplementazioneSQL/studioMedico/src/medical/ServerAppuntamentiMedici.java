package medical;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;
import java.sql.*;

public class ServerAppuntamentiMedici {




    public static void main(String[] args) {

        //lo '0' nel secondo parametro e' per la gestione delle connessioni, che in questo
        //caso abbiamo deciso di affidare alla nostra macchina
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //GestoreRichieste e' la classe che abbiamo creato per poter, appunto, gestire le richieste
        server.createContext("/", new GestoreRichieste());

        //executor per gestire le richieste in asincrono
        server.setExecutor(null);

        server.start();
        System.out.println("Server medical avviato con successo su porta 8080.");


    }

    static class GestoreRichieste implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            //Ottenimento del metodo della richiesta
            String metodo = exchange.getRequestMethod();
            if(metodo.equalsIgnoreCase("GET")) {
                //creazione ed uso di un metodo per gestire le richieste Get
                gestisciRichiestaGet(exchange);
            }else if(metodo.equalsIgnoreCase("POST")) {
                //creazione ed uso di un metodo per gestire le richiest Post
                gestisciRichiestaPost(exchange);
            }
        }

        //metodo per get
        private void gestisciRichiestaGet(HttpExchange exchange)throws IOException{
            //costruzione della risposta HTML
            String risposta = "<html><head><title>GestionaleMedical</title></head>"
                    +"<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>"
                    +"</head>"
                    +"<body>"
                    +"<div class='container'><h2>Inserisci Appuntamento</h2>"
                    +"<form method='post'>"
                    +"Nome: <input type='text' name='nome'><br>"

                    +"Data: <input type='date' name='data'><br>"
                    +"Ora: <input type='time'name='ora'><br>"
                    +"Descrizione: <input type='text' name='descrizione'><br>"
                    +"<input type='submit' value='Invia'>"
                    +"</form></div>";

            //Gestione della seconda sezione della pagina in cui visualizzaimo la tabella
            risposta += "<div class='container'><h2>Lista Appuntamenti</h2>"
                    +"<table class='table'>"
                    +"<thead><tr>"
                    +"<th>Nome</th><th>Data</th><th>Ora</th>Descrizione</th>"
                    +"</tr></thead>"
                    +"<tbody>";


            //recupero dei dati dal database per creare dinamicamente le righe della tabella
            try {
                //connesione al database
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","0104");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT  * FROM appuntamenti");

                //iteriamo all'interno del result set per recuperare le singole informazioni e scrivere la riga
                while(rs.next()) {
                    risposta += "<tr><td>" + rs.getString("nome") + "</td>"
                            + "<td>" + rs.getString("data") + "</td>"
                            + "<td>" + rs.getString("ora") + "</td>"
                            + "<td>" + rs.getString("descrizione") + "</td></tr>";
                }
                rs.close();
                stmt.close();
                conn.close();

            }catch(SQLException e) {
                e.printStackTrace();
            }

            risposta += "</tbody></table></div></body></html>";

            //invio della risposta al client(browser utente)
            //exchange.sendResponseHeaders(200, risposta.getBytes().length);

            int contentLenght = risposta.getBytes("UTF-8").length;
            exchange.sendResponseHeaders(200, contentLenght);

            OutputStream os = exchange.getResponseBody();
            os.write(risposta.getBytes());
            os.close();
        }

        //metodo per post
        private void gestisciRichiestaPost(HttpExchange exchange) throws IOException{
            //parsing dei dati post
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String datiPost = br.readLine();
            //creazione dell'array con le coppie chiave-valore
            String[] coppie = datiPost.split("&");

            //estraiamo i valori dalle coppie
            String nome = null;
            String data = null;
            String ora = null;
            String descrizione = null;

            for(String coppia : coppie) {
                String[] chiaveValore = coppia.split("=");
                String chiave = chiaveValore[0];
                String valore = chiaveValore[1];

                if(chiave.equals("nome")) { //"\\+" rappresenta lo spazio
                    nome = valore.replaceAll("\\+"," ");
                }else if(chiave.equals("data")) {
                    data = valore;
                }else if(chiave.equals("ora")) { //"%3A" rappresenta i due punti ":"
                    ora = valore.replaceAll("%3A", ":");
                    if(ora.length()==5) {
                        ora += ":00";
                    }
                }else if(chiave.equals("descrizione")) {
                    descrizione = valore.replaceAll("\\+"," ");
                }
            }

            //inserimento dei valori catturati all'interno del database
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","0104");
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO appuntamenti(nome,data,ora,descrizione) VALUES (?,?,?,?)");
                pstmt.setString(1,nome);
                pstmt.setDate(2, Date.valueOf(data));
                pstmt.setTime(3, Time.valueOf(ora));
                pstmt.setString(4, descrizione);

                pstmt.executeUpdate();

                pstmt.close();
                conn.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }

            //imposta l'header location per reinderizzare il client sulla homepage
            exchange.getResponseHeaders().set("Location","/");
            exchange.sendResponseHeaders(302,-1);

            exchange.close();
        }
    }

}
