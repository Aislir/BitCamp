package avanzato;

public class TestAutomobile {

    public static void main(String[] args) {

        //dichiarazione di un array di tipo Automobile, che conterra oggetti della classe Automobile
        Automobile[] automobili = new Automobile[3];

        automobili[0] = new Automobile("Lamborghini", "Infernus", 2024, 100000);
        automobili[1] = new Automobile("Fiat", "Panda", 2015, 5000);
        automobili[2] = new Automobile("Toyota", "Yaris", 2022, 12000);

        for(int i = 0; i < automobili.length; i++){
            automobili[i].stampaInfo();
        }
    }
}
