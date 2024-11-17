package anagrafica;

public class Cliente {

    private String nome;
    private String cognome;
    private String email;
    private String telefono;

    public Cliente(String nome, String cognome, String email, String telefono){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getEmail(){
        return email;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return "Persona{ " + "Nome: " + nome + " - " + "Cognome: " + cognome +  " - " + "Email: " + email +  " - " + "Telefono: " + telefono +" }";
    }
}
