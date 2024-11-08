package base;

//importiamo la libreria che si serve
import java.util.Scanner;

public class InputUtente {

    public static void main(String[] args) {

        //creazione di un oggetto della libreria Scanner per poterne utilizzare le proprieta'
        Scanner input = new Scanner(System.in);

        System.out.print("Inserisci una stringa: ");
        String inputUtente = input.next();
        System.out.println(inputUtente);

    }
}
