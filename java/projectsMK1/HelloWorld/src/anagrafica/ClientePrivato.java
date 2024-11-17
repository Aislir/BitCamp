package anagrafica;

public class ClientePrivato extends Cliente{
    private String codiceFiscale;

    public ClientePrivato(String nome, String cognome, String email, String telefono, String codiceFiscale){
        super(nome, cognome, email, telefono);
        this.codiceFiscale = codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceFiscale(){
        return codiceFiscale;
    }

    @Override
    public String toString(){
        return "Persona{ " + "Nome: " + getNome() + " - " + "Cognome: " + getCognome() +  " - " +
                "Email: " + getEmail() +  " - " + "Telefono: " + getTelefono() + " - " + "Codice Fiscale: "+codiceFiscale+ " }"; 
    }
}
