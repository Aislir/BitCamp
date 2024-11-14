package avanzato;

public class Cerchio {
    private double raggio;

    public Cerchio(double raggio){
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    public double calcolaArea(){
        double area = (this.raggio * this.raggio) * Math.PI;
        return area;
    }
}
