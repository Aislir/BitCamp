package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
@Entity
@Table(name = "ddt")

public class DDT {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ddt_generator")
    @SequenceGenerator(name = "ddt_generator", sequenceName = "ddt_seq")
    private long id;
    private LocalDate dataDDT;
    private LocalDate dataReg;
    private int numero;

    @Enumerated(EnumType.STRING)
    private Fornitore fornitore;

    @OneToMany (mappedBy = "DDT", fetch = FetchType.LAZY)
    private List<StoricoMagazzino> prodottiEntrati = new ArrayList<StoricoMagazzino>();

    @ManyToMany(mappedBy = "ddtProdotto", fetch = FetchType.LAZY)
    private Set<Prodotto> prodotti = new HashSet<Prodotto>();

    @Transient
    private boolean isSelected = false;

    public DDT() {}

    //metodi get
    public long getDdtId() {return id;}
    public LocalDate getDataDDT() {return dataDDT;}
    public LocalDate getDataReg() {return dataReg;}
    public int getNumero() {return numero;}
    public Fornitore getFornitore() {return fornitore;}
    public List<StoricoMagazzino> getProdottiEntrati() {return prodottiEntrati;}
    public boolean getIsSelected() {return isSelected;}
    //metodi set
    public void setDataDDT(LocalDate dataDDT) {this.dataDDT = dataDDT;}
    public void setDataReg(LocalDate dataReg) {this.dataReg = dataReg;}
    public void setNumero(int numero) {this.numero = numero;}
    public void setFornitore(Fornitore fornitore) {this.fornitore = fornitore;}
    public void setIsSelected(boolean selected) {isSelected = selected;}
}
