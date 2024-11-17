package anagrafica;

import java.util.ArrayList;

public class GestioneClienti {

    //array per gestire tutti i clienti
    private ArrayList<Cliente> clienti;

    public GestioneClienti(){
        this.clienti = new ArrayList<>();
    }

    //Metodo per visualizzare tutti i clienti presenti
    public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
    }

    //Metodo per visualizzare tutti i clienti presenti
    public void mostraClienti(){
        for(Cliente cliente : clienti) {
            System.out.println(cliente);
        }
    }

    //Metodo per ricercare un cliente per email
    public Cliente cercaClientePerEmail(String email) {
        for(Cliente cliente : clienti) {
            if(cliente.getEmail().equalsIgnoreCase(email)){
                return cliente;
            }
        }
        return null; //ritorna null SOLO se l'if non ritorna cliente
    }

    //Metodo per modificare un cliente ---> crea un nuovo oggetto e lo rimpiazza al precedente
    public boolean modificaCliente(String email, Cliente clienteModificato){
        Cliente cliente = cercaClientePerEmail(email); //chiama la funzione per capire se esiste un oggetto con quella mail
        if (cliente != null){
            clienti.set(clienti.indexOf(cliente), clienteModificato); //mette il nuovo oggetto (clienteModificato) al posto
                                                                      //dell'oggetto precedente
            return true;
        }
        return false; //ritorna false solo se l'if precedente NON ritorna true;
    }

    public boolean eliminaCliente(String email) {
        Cliente cliente = cercaClientePerEmail(email);
        if(cliente != null){
            clienti.remove(cliente);
            return true;
        }
        return false;
    }

}
