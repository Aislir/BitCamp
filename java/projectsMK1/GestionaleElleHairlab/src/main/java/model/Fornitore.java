package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fornitore")

public class Fornitore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String rappresentante;

    @Transient //variabile non utilizzata nella mappatura
    private Boolean isSelected = false;

    @OneToMany (mappedBy = "fornitore", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContattoFornitore> contatti = new ArrayList<>();

    @OneToMany (mappedBy = "fornitore", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Prodotto> prodotti = new ArrayList<>();

    @OneToMany (mappedBy = "fornitore", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<DDT> ddts = new ArrayList<>();

    public Fornitore() {
    }

    public Fornitore(String nome, String rappresentante) {
        this.nome = nome;
        this.rappresentante = rappresentante;
    }

    //metodi get
    public int getId() {return id;}
    public String getNome(){return nome;}
    public String getRappresentante(){return rappresentante;}
    public List<ContattoFornitore> getContatti(){return contatti;}
    public List<Prodotto> getProdotti(){return prodotti;}
    public List<DDT> getDdts() {return ddts;}
    public Boolean getSelected() {return isSelected;}

    //metodi set
    public void setNome(String nome){this.nome = nome;}
    public void setRappresentante(String rappresentante){this.rappresentante = rappresentante;}
    public void setId(int fornitore_id){this.id = fornitore_id;}
    public void setContatti(List<ContattoFornitore> contatti){this.contatti = contatti;}
    public void setDdts(List<DDT> ddts) {this.ddts = ddts;}
    public void setProdotti(List<Prodotto> prodotti) {this.prodotti = prodotti;}
    public void setSelected(Boolean isSelected) {this.isSelected = isSelected;}

    public void addContatto(ContattoFornitore contatto) {
        contatti.add(contatto);   // Aggiunta alla lista
        contatto.setFornitore(this); // Imposta la relazione bidirezionale
    }

}
