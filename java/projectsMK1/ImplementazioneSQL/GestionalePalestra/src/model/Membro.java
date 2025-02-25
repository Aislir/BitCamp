package model;

public class Membro {

    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String dataIscrizione;

    public Membro(int id, String nome, String cognome, String email, String dataIscrizione){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataIscrizione = dataIscrizione;
    }

    //metodi get e set
    public int getId() {return id;}
    public String getNome() {return nome;}
    public String getCognome(){return cognome;}
    public String getEmail(){return email;}
    public String getDataIscrizione(){return dataIscrizione;}

}
