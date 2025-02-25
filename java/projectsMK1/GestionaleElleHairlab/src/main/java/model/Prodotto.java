package model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "prodotto")
public class Prodotto {
    //identifica il campo id della tabella
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoProdotto tipo;

    private String codice;
    private double contenuto;

    @Enumerated(EnumType.STRING)
    private Marche marca;
    private int quantita;

    @OneToMany (mappedBy = "prodotto", cascade = CascadeType.ALL)
    private ArrayList<StoricoMagazzino> storicoProdotto = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornitore_id")
    private Fornitore fornitore;


    public Prodotto() {}
    public Prodotto(String nome, TipoProdotto tipo, String codice, double contenuto, Marche marca, Fornitore fornitore, int quantita) {
        this.nome = nome;
        this.tipo = tipo;
        this.codice = codice;
        this.contenuto = contenuto;
        this.marca = marca;
        this.fornitore = fornitore;
        this.quantita = quantita;
    }

    //metodi get
    public int getId() {return id;}
    public String getNome() {return nome;}
    public TipoProdotto getTipo() {return tipo;}
    public String getCodice() {return codice;}
    public double getContenuto() {return contenuto;}
    public Marche getMarca() {return marca;}
    public Fornitore getFornitore() {return fornitore;}
    public int getQuantita() {return quantita;}
    public ArrayList<StoricoMagazzino> getStoricoProdotto() {return storicoProdotto;}

    //metodi set
    public void setNome(String nome) {this.nome = nome;}
    public void setTipo(TipoProdotto tipo) {this.tipo = tipo;}
    public void setCodice(String codice) {this.codice = codice;}
    public void setContenuto(double contenuto) {this.contenuto = contenuto;}
    public void setMarca(Marche marca) {this.marca = marca;}
    public void setFornitore(Fornitore fornitore) {this.fornitore = fornitore;}
    public void setQuantita(int quantita) {this.quantita = quantita;}
    public void setId(int id) {this.id = id;}
    public void setStoricoProdotto(ArrayList<StoricoMagazzino> storicoProdotto) {this.storicoProdotto = storicoProdotto;}
}
