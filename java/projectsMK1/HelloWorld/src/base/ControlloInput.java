package base;
import java.util.Scanner;

public class ControlloInput {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //verifica dell'input per ricezione numero intero
        System.out.println("Inserisci un numero intero: ");
        if (input.hasNextInt()){
            int numInt = input.nextInt();
            System.out.println("Hai inserito il numero: " +numInt);
        } else {
            System.out.println("Input errato. L'elemento inserito non e' un numero intero");
        }

        //verifica decimale
        System.out.println("Inserisci un numero decimale: ");
        if (input.hasNextDouble()){
            double numDouble = input.nextDouble();
            System.out.println("Hai inserito il numero: " +numDouble);
        } else {
            System.out.println("Input errato. L'elemento inserito non e' un numero decimale");
        }
    }
}
