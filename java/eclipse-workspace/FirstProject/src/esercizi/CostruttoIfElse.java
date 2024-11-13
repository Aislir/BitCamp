package esercizi;

import java.util.Scanner;

public class CostruttoIfElse {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Inserisci un numero intero: ");
		
		int numInt = input.nextInt();
		
		if(numInt % 2 == 0) {
			System.out.println("Il numero inserito e' pari");
		} else {
			System.out.println("Il numero inserito e' dispari");
		}

	}

}
