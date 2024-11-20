package avanzato.enumeratori;

public class TestPizza {

    public static void main(String[] args) {

        Pizza miaPizza = Pizza.QUATTRO_STAGIONI;

        System.out.println("Il cliente ha ordinato la pizza "+miaPizza);

        for(Pizza pizza : Pizza.values()){
            System.out.print("La pizza " +pizza+ " ha i seguenti ingredienti: ");
            for (String ingrediente : pizza.getIngredienti()){
                System.out.print(ingrediente + ", ");
            }
            System.out.println();
        }
    }
}
