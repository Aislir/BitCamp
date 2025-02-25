package model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "biglietto")
public class Biglietto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codice;

    @Enumerated(EnumType.STRING)
    Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "fermata_id")
    private Fermata fermata;

    //@Temporal(TemporalType.TIMESTAMP) apparentemente inutile
    private LocalDateTime data;

    public Fermata getFermata() {return fermata;}

    public void setFermata(Fermata fermata) {this.fermata = fermata;}

    public Biglietto() {}
    public Biglietto(String codice, Tipo tipo) {
        this.codice = codice;
        this.tipo = tipo;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getCodice() {return codice;}
    public void setCodice(String codice) {this.codice = codice;}
    public LocalDateTime getData() {return data;}
    public void setData(LocalDateTime data) {this.data = data;}
    public Tipo getTipo() {return tipo;}
    public void setTipo(Tipo tipo) {this.tipo = tipo;}
}
