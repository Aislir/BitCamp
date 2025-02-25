package model;

import jakarta.persistence.*;

@Entity
@Table(name = "contatti_fornitore")

public class ContattoFornitore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contatti;
    private String email;

    @ManyToOne
    @JoinColumn(name = "fornitore_id")
    private Fornitore fornitore;

    public ContattoFornitore() {}
    public ContattoFornitore(String contatti, String email) {
        this.contatti = contatti;
        this.email = email;
    }

    public Fornitore getFornitore() {return fornitore;}
    public void setFornitore(Fornitore fornitore) {this.fornitore = fornitore;}

    public int getId() {return id;}
    public void setContattiId(int id) {this.id = id;}
    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}

    public String getContatti() {return contatti;}
    public void setContatti(String contatti) {this.contatti = contatti;}

}
