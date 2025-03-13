package model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "storicoMagazzino")
public class StoricoMagazzino {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storico_generator")
    @SequenceGenerator(name = "storico_generator", sequenceName = "storico_seq")
    private long id;
    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;
    private LocalDateTime dataMovimento;
    private int quantita;

    @ManyToOne
    @JoinColumn(name = "prodotto_id")
    private Prodotto prodotto;

    @ManyToOne
    @JoinColumn(name = "ddt_id")
    private DDT ddt;

    public StoricoMagazzino() {}
    public StoricoMagazzino(Prodotto prodotto, int quantita, LocalDateTime dataMovimento, TipoMovimento tipoMovimento) {
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.dataMovimento = dataMovimento;
        this.tipoMovimento = tipoMovimento;
    }

    public Prodotto getProdotto() {return prodotto;}
    public long getStoricoMagazzino_id() {return id;}
    public TipoMovimento getTipoMovimento() {return tipoMovimento;}
    public LocalDateTime getDataMovimento() {return dataMovimento;}
    public int getQuantita() {return quantita;}


    public void setProdotto(Prodotto prodotto) {this.prodotto = prodotto;}
    public void setStoricoMagazzino_id(int id) {this.id = id;}
    public void setTipoMovimento(TipoMovimento tipoMovimento) {this.tipoMovimento = tipoMovimento;}
    public void setQuantita(int quantita) {this.quantita = quantita;}
    public void setDataMovimento(LocalDateTime dataMovimento) {this.dataMovimento = dataMovimento;}
}
