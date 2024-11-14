package avanzato;

public class Studente {
    private String nome;
    private String cognome;
    private int matricola;
    private int[] voti;

    public Studente(String nome, String cognome, int matricola){
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        voti = new int[5]; //decidiamo noi la grandezza dell'array di base
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public void assegnaVoto(int index, int voto){
        voti[index] = voto;
    }

    public double mediaVoti(){
        int somma = 0;
        for(int i = 0; i < voti.length; i++){
            somma += voti[i];
        }
        double media = (double) somma / (double) voti.length;
        return media;
    }


}
