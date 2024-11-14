package avanzato;

public class Automobile {
    private String marca;
    private String modello;
    private int anno;
    private double prezzo;

    public Automobile(String marca, String modello, int anno, double prezzo) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setModello(String modello){
        this.modello = modello;
    }

    public String getModello(){
        return this.modello;
    }

    public void setAnno(int anno){
        this.anno = anno;
    }

    public int getAnno(){
        return this.anno;
    }

    public void setPrezzo(double prezzo){
        this.prezzo = prezzo;
    }

    public double getPrezzo(){
        return this.prezzo;
    }

    public void stampaInfo(){
        System.out.println(this.marca);
        System.out.println(this.modello);
        System.out.println(this.anno);
        System.out.println(this.prezzo);
    }


}
