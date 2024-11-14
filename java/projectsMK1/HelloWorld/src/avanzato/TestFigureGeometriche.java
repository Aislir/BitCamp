package avanzato;

public class TestFigureGeometriche {

    public static void main(String[] args) {

        Cerchio c1 = new Cerchio(4);
        Quadrato q1 = new Quadrato(5);

        System.out.println("Il cerchio ha raggio: " +c1.getRaggio());
        System.out.println("Il cerchio ha area "+c1.calcolaArea());
        System.out.println("Il quadrato ha lato: "+q1.getLato()+ " e un'area di : " +q1.calculateArea());
    }
}
