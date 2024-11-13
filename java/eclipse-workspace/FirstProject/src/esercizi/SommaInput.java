package esercizi;

import java.util.Scanner;

public class SommaInput {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int somma = 0;
		
		while(somma <= 100) {
			
			System.out.print("Inserisci un numero intero positivo: ");
			
			if(input.hasNextInt()) {
				int num = input.nextInt();
				System.out.println("Hai inserito il numero: "+num);
				somma += num;
				System.out.println("L'attuale somma dei numeri inseriti e': "+somma);
			} else {
				System.out.println("Per favore inserisci un valore valido!");
				input.nextLine();
			}

			
		}

	}

}
