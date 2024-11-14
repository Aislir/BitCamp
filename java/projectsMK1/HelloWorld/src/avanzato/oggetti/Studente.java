package avanzato.oggetti;


public class Studente extends Persona{
    //dato che la classe Studente e Persona avrebbero gli stessi attributi,
    //andiamo ad estendere gli attributi della classe Persona sulla classe Studente
    //attraverso "extends" + [nome_Classe_da_estendere]

    private String matricola;
    private String corsoDiStudi;
    //ci sono anche nome, cognome ed eta ereditati da Persona

    public Studente(String nome, String cognome, int eta, String matricola, String corsoDiStudi){
        super(nome, cognome, eta); //estensione del costruttore di Persona per poter accedere
        //a nome, cognome ed eta

        this.matricola = matricola;
        this.corsoDiStudi = corsoDiStudi;
    }

    public void setMatricola(String matricola){
        this.matricola = matricola;
    }

    public void setCorsoDiStudi(String corsoDiStudi){
        this.corsoDiStudi = corsoDiStudi;
    }

    public String getMatricola(){
        return matricola;
    }

    public String getCorsoDiStudi(){
        return corsoDiStudi;
    }

    @Override //sovrascrive il comportamento base del metodo toString
    public String toString(){
        return "Persona{ " + "Nome: " + getNome() + " - " + "Cognome: " + getCognome() +  " - " +
                "Eta: " + getEta() + " - " + "Matricola: " + matricola + " - " +
                "Corso di studi: " + corsoDiStudi + " }";
    }

}
