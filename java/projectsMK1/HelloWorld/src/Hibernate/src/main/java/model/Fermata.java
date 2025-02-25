package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fermata")
public class Fermata {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String luogo;
    @OneToMany (mappedBy = "fermata")
    private List<Biglietto> biglietti;

    public List<Biglietto> getBiglietto() {return biglietti;}

    public void setBiglietto(List<Biglietto> biglietti) {this.biglietti = biglietti;}

    public Fermata() {}
    public Fermata(String luogo) {
        this.luogo = luogo;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getLuogo() {return luogo;}
    public void setLuogo(String luogo) {this.luogo = luogo;}
}
