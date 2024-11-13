package esercizi;
import java.util.Scanner;

public class OpConfronto {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Inserisci un numero intero: ");
		
		int num = input.nextInt();
		
		if(num >= 10) {
			System.out.println("Il numero e' maggiore o uguale a 10");
		} else {
			System.out.println("Il numero e' minore di 10");
		}

	}

}
