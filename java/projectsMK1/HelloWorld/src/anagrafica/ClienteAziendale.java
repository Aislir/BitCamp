package anagrafica;

public class ClienteAziendale extends  Cliente{

    private String partitaIva;
    private String nomeAzienda;

    public ClienteAziendale(String nome, String cognome, String email, String telefono, String partitaIva, String nomeAzienda){
        super(nome, cognome, email, telefono);

        this.partitaIva = partitaIva;
        this.nomeAzienda = nomeAzienda;
    }

    public String getPartitaIva(){
        return partitaIva;
    }

    public String getNomeAzienda(){
        return nomeAzienda;
    }

    public void setPartitaIva(String partitaIva){
        this.partitaIva = partitaIva;
    }

    public void setNomeAzienda(String nomeAzienda){
        this.nomeAzienda = nomeAzienda;
    }

    @Override
    public String toString(){
        return "Persona{ " + "Nome: " + getNome() + " - " + "Cognome: " + getCognome() +  " - " +
                "Email: " + getEmail() +  " - " + "Telefono: " + getTelefono() + " - " +
                "Partita IVA: "+partitaIva+ " - " + "Nome Azienda: " + nomeAzienda+ " }";
    }
}
