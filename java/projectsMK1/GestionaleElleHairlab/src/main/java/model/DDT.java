package model;

import java.time.LocalDate;
import java.util.ArrayList;
import jakarta.persistence.*;
@Entity
@Table(name = "ddt")

public class DDT {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private LocalDate dataDDT;
    private LocalDate dataReg;
    private int numero;

    @OneToMany (mappedBy = "ddt", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<StoricoMagazzino> prodottiDelDDT;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "fornitore_id")
    private Fornitore fornitore;

    public DDT(LocalDate dataDDT, LocalDate dataReg, int numero) {
        this.dataDDT = dataDDT;
        this.dataReg = dataReg;
        this.numero = numero;
    }

    public DDT() {}

    //metodi get
    public int getDdtId() {return id;}
    public LocalDate getDataDDT() {return dataDDT;}
    public LocalDate getDataReg() {return dataReg;}
    public int getNumero() {return numero;}

    //metodi set
    public void setDataDDT(LocalDate dataDDT) {this.dataDDT = dataDDT;}
    public void setDataReg(LocalDate dataReg) {this.dataReg = dataReg;}
    public void setNumero(int numero) {this.numero = numero;}
    public void  setId(int id) {this.id = id;}
}
