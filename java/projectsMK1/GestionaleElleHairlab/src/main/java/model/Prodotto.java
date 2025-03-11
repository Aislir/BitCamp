package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prodotto")
public class Prodotto {
    //identifica il campo id della tabella
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodotto_generator")
    @SequenceGenerator(name = "prodotto_generator", sequenceName = "prodotto_seq")
    private int id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoProdotto tipo;

    private String codice;
    private double contenuto;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private int quantita;

    @Transient
    private Boolean selected = false;

    @OneToMany (mappedBy = "prodotto", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true )
    private List<StoricoMagazzino> storicoProdotto = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "fornitore_id")
    private Fornitore fornitore;

    public Prodotto() {}

    public Prodotto(String nome, String codice, TipoProdotto tipo, double contenuto, Marca marca) {
        this.nome = nome;
        this.codice = codice;
        this.tipo = tipo;
        this.contenuto = contenuto;
        this.marca = marca;
        this.quantita = 0;
    }

    public void addFornitore(Fornitore fornitore) {
        fornitore.getProdotti().add(this);   // Aggiunta alla lista
        this.setFornitore(fornitore); // Imposta la relazione bidirezionale
    }

    //metodi get
    public int getId() {return id;}
    public String getNome() {return nome;}
    public TipoProdotto getTipo() {return tipo;}
    public String getCodice() {return codice;}
    public double getContenuto() {return contenuto;}
    public Marca getMarca() {return marca;}
    public Fornitore getFornitore() {return fornitore;}
    public int getQuantita() {return quantita;}
    public List<StoricoMagazzino> getStoricoProdotto() {return storicoProdotto;}
    public Boolean getSelected() {return selected;}

    //metodi set
    public void setNome(String nome) {this.nome = nome;}
    public void setTipo(TipoProdotto tipo) {this.tipo = tipo;}
    public void setCodice(String codice) {this.codice = codice;}
    public void setContenuto(double contenuto) {this.contenuto = contenuto;}
    public void setMarca(Marca marca) {this.marca = marca;}
    public void setFornitore(Fornitore fornitore) {this.fornitore = fornitore;}
    public void setQuantita(int quantita) {this.quantita = quantita;}
    public void setId(int id) {this.id = id;}
    public void setStoricoProdotto(List<StoricoMagazzino> storicoProdotto) {this.storicoProdotto = storicoProdotto;}
    public void setSelected(Boolean selected) {this.selected = selected;}
}
