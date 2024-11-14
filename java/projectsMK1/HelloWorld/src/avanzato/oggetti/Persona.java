package avanzato.oggetti;

public class Persona {

    private String nome;
    private String cognome;
    private int eta;


    public Persona(String nome, String cognome, int eta){
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setEta(int eta){
        this.eta = eta;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public int getEta(){
        return eta;
    }

    @Override //sovrascrive il comportamento base del metodo toString
    public String toString(){
        return "Persona{ " + "Nome: " + nome + " - " + "Cognome: " + cognome +  " - " + "Eta: " + eta + " }";
    }


}
