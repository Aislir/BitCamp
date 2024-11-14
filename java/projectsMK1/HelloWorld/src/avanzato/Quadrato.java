package avanzato;

public class Quadrato {
    private double lato;

    public Quadrato(double lato){
        this.lato = lato;
    }

    public double getLato(){
        return lato;
    }

    public void setLato(double lato){
        this.lato = lato;
    }

    public double calculateArea(){
        double area = this.lato * this.lato;
        return area;
    }
}
