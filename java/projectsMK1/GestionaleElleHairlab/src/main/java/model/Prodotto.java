package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "prodotto")
public class Prodotto {
    //identifica il campo id della tabella
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodotto_generator")
    @SequenceGenerator(name = "prodotto_generator", sequenceName = "prodotto_seq")
    private long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoProdotto tipo;

    private String codice;
    private double contenuto;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    @Enumerated(EnumType.STRING)
    private Fornitore fornitore;

    private int quantita;

    @Transient
    private Boolean isSelected = false;

    @OneToMany (mappedBy = "prodotto", fetch = FetchType.LAZY )
    private List<StoricoMagazzino> storicoProdotto = new ArrayList<>();

    @ManyToMany
    private Set<DDT> ddtProdotto = new HashSet<>();

    public Prodotto() {}

    //metodi get
    public long getId() {return id;}
    public String getNome() {return nome;}
    public TipoProdotto getTipo() {return tipo;}
    public String getCodice() {return codice;}
    public double getContenuto() {return contenuto;}
    public Marca getMarca() {return marca;}
    public int getQuantita() {return quantita;}
    public List<StoricoMagazzino> getStoricoProdotto() {return storicoProdotto;}
    public Boolean getIsSelected() {return isSelected;}
    public Fornitore getFornitore() {return fornitore;}
    public Set<DDT> getDdtProdotto() {return ddtProdotto;}

    //metodi set
    public void setNome(String nome) {this.nome = nome;}
    public void setTipo(TipoProdotto tipo) {this.tipo = tipo;}
    public void setCodice(String codice) {this.codice = codice;}
    public void setContenuto(double contenuto) {this.contenuto = contenuto;}
    public void setMarca(Marca marca) {this.marca = marca;}
    public void setQuantita(int quantita) {this.quantita = quantita;}
    public void setIsSelected(Boolean selected) {this.isSelected = selected;}
    public void setFornitore(Fornitore fornitore) {this.fornitore = fornitore;}
    public void setDdtProdotto(Set<DDT> ddtProdotto) {this.ddtProdotto = ddtProdotto;}
}
