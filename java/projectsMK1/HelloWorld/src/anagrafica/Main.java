package anagrafica;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        GestioneClienti gestioneClienti = new GestioneClienti();

        while(true){
            System.out.println("Gestionale Ver. 0.00001 Anagrafica Clienti");
            System.out.println("------------------------------------------\n");
            System.out.println("1. Aggiungi Cliente Privato");
            System.out.println("2. Aggiungi Cliente Aziendale");
            System.out.println("3. Mostra Clienti");
            System.out.println("4. Cerca cliente per Email");
            System.out.println("5. Modifica Cliente Privato");
            System.out.println("6. Modifica Cliente Aziendale");
            System.out.println("7. Elimina Cliente");
            System.out.println("8. Esci\n");
            System.out.print("Scegli un opzione: ");

            int scelta = input.nextInt();
            input.nextLine();

            switch(scelta){
                case 1:
                    //riempimento campi necessari
                    System.out.print("Inserisci il nome del cliente: ");
                    String nome = input.nextLine();
                    System.out.print("Inserisci il cognome del cliente: ");
                    String cognome = input.nextLine();
                    System.out.print("Inserisci l'email del cliente: ");
                    String email = input.nextLine();
                    System.out.print("Inserisci il telefono del cliente: ");
                    String telefono = input.nextLine();
                    System.out.print("Inserisci il codice fiscale del cliente: ");
                    String codiceFiscale = input.nextLine();

                    //creazione e valorizzazione di un oggetto ClientePrivato
                    ClientePrivato clientePrivato = new ClientePrivato(nome, cognome, email, telefono, codiceFiscale);

                    //aggiunta del cliente all'array di clienti
                    gestioneClienti.aggiungiCliente(clientePrivato);
                    break;
                case 2:
                    System.out.print("Inserisci il nome del cliente: ");
                    nome = input.nextLine();
                    System.out.print("Inserisci il cognome del cliente: ");
                    cognome = input.nextLine();
                    System.out.print("Inserisci l'email del cliente: ");
                    email = input.nextLine();
                    System.out.print("Inserisci il telefono del cliente: ");
                    telefono = input.nextLine();
                    System.out.print("Inserisci la partita IVA del cliente: ");
                    String partitaIVA = input.nextLine();
                    System.out.print("Inserisci il nome dell'Azienda del cliente: ");
                    String nomeAzienda = input.nextLine();

                    //creazione e valorizzazione di un oggetto ClienteAziendale
                    ClienteAziendale clienteAziendale = new ClienteAziendale(nome, cognome, email, telefono, partitaIVA, nomeAzienda);

                    //aggiunta del cliente all'array di clienti
                    gestioneClienti.aggiungiCliente((clienteAziendale));
                    break;
                case 3:
                    gestioneClienti.mostraClienti();
                    break;
                case 4:
                    System.out.print("Inserisci l'email del cliente da cercare: ");
                    String emailRicerca = input.nextLine();
                    Cliente clienteTrovato = gestioneClienti.cercaClientePerEmail(emailRicerca);
                    if (clienteTrovato != null){
                        System.out.println("Cliente trovato: " + clienteTrovato);
                    } else {
                        System.out.println("Cliente non trovato");
                    }
                    break;
                case 5:
                    System.out.print("Inserisci l'email del cliente da modificare: ");
                    String emailModifica = input.nextLine();

                    System.out.print("Inserisci il nuovo nome: ");
                    String nuovoNome = input.nextLine();
                    System.out.print("Inserisci il nuovo cognome: ");
                    String nuovoCognome = input.nextLine();
                    System.out.print("Inserisci la nuova email: ");
                    String nuovaEmail = input.nextLine();
                    System.out.print("Inserisci il nuovo telefono: ");
                    String nuovoTelefono = input.nextLine();
                    System.out.print("Inserisci il nuovo codice fiscale: ");
                    String nuovoCodiceFiscale = input.nextLine();

                    ClientePrivato nuovoClientePrivato = new ClientePrivato(nuovoNome, nuovoCognome, nuovaEmail, nuovoTelefono, nuovoCodiceFiscale);
                    boolean modificatoPrivato = gestioneClienti.modificaCliente(emailModifica, nuovoClientePrivato);

                    if(modificatoPrivato){
                        System.out.println("Cliente modificato con successo.");
                    } else {
                        System.out.println("Cliente non trovato");
                    }

                    break;
                case 6:
                    System.out.print("Inserisci l'email del cliente da modificare: ");
                    emailModifica = input.nextLine();

                    System.out.print("Inserisci il nuovo nome: ");
                    nuovoNome = input.nextLine();
                    System.out.print("Inserisci il nuovo cognome: ");
                    nuovoCognome = input.nextLine();
                    System.out.print("Inserisci la nuova email: ");
                    nuovaEmail = input.nextLine();
                    System.out.print("Inserisci il nuovo telefono: ");
                    nuovoTelefono = input.nextLine();
                    System.out.print("Inserisci la nuova partita IVA: ");
                    String nuovaPartitaIVA = input.nextLine();
                    System.out.print("Inserisci il nuovo nome dell'Azienda: ");
                    String nuovoNomeAzienda = input.nextLine();

                    ClienteAziendale nuovoClienteAziendale = new ClienteAziendale(nuovoNome, nuovoCognome, nuovaEmail, nuovoTelefono, nuovaPartitaIVA, nuovoNomeAzienda);
                    boolean modificatoAziendale = gestioneClienti.modificaCliente(emailModifica, nuovoClienteAziendale);

                    if(modificatoAziendale){
                        System.out.println("Cliente modificato con successo.");
                    } else {
                        System.out.println("Cliente non trovato");
                    }

                    break;
                case 7:
                    System.out.print("Inserisci l'email del cliente da eliminare: ");
                    String eliminaCliente = input.nextLine();

                    boolean eliminato = gestioneClienti.eliminaCliente(eliminaCliente);
                    if (eliminato) {
                        System.out.println("Cliente eliminato con successo");
                    } else {
                        System.out.println("Nessun cliente trovato con questa email");
                    }

                    break;
                case 8:
                    System.out.println("Termine programma");
                    input.close();
                default:
                    System.out.println("Opzione non valida");
                    input.nextLine();
            }


        }
    }
}
