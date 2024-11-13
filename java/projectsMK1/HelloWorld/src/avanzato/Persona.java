package avanzato;

public class Persona {

    //inserimento attributi della classe
    private String nome;    //private permette di non poter accedere agli attributi della classe
    private int eta;

    //costruttore per inizializzazione oggetti della classe. Presente di default se vuoto
    public Persona(String nome, int eta) { //parametri necessari da passare al costruttore se
                                          //si vuole creare un oggetto

        //this si riferisce all'attributo della classe.
        this.nome = nome;
        this.eta = eta;

    }

    //e' possibile creare piu' costruttori che differiscono per numero o tipo di parametri
    //NON e' possibile creare piu' costruttori con lo stesso numero di parametri
    //e stessi tipi di dato (anche se il nome della variabile e' differente)
    public Persona(String nome) {
        this.nome = nome;
    }

    public Persona() {} //se abbiamo inserito costruttori CON parametri, inserire un costruttore
    //vuoto permette di creare oggetti vuoti (senza attributi della classe)

    //metodi Getter e Setter
    public String getNome(){             //i metodi get permettono di farci ritornare
        return nome;                     //un determinato attributo di un oggetto di una classe
    }

    public int getEta(){
        return eta;
    }

    public void setNome(String nome){
        this.nome = nome;               //i metodi set ci permettono di "settare" un determinato
    }                                   //attributi di una classe

    public void setEta(int eta){
        this.eta = eta;
    }
    //NB: E' NECESSARIO INSERIRE UN METODO GET E SET PER OGNI SINGOLO ATTRIBUTO DELLA CLASSE

}
