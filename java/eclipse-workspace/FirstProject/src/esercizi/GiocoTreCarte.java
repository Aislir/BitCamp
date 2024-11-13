package esercizi;

import java.util.Scanner;

public class GiocoTreCarte {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String[] carte = {"A", "B", "C"};
		
		int cartaScelta = -1;
	
		
		System.out.println("Benvenuto al gioco delle 3 carte!");
		
		while(true) {
			//random dentro al while permette di aggiornare le carte ogni volta che si prova ad indovinare un numero
			int cartaVincente = (int)(Math.random() * 3); //il cast dell'int ci permette di selezionare solo il numero intero
			//System.out.println(cartaVincente);
			System.out.println("Scegli una carta: ");
			for(int i = 0; i < carte.length; i++) {
				System.out.println((i + 1) + ") " + carte[i]);
			}
			
			cartaScelta = input.nextInt() - 1;
			
			if(cartaScelta == cartaVincente) {
				System.out.println("Complimenti, hai indovinato!");
				break; //esco dal while una volta indovinata la carta
			} else {
				System.out.println("Oh no! Carta errata. Riprova");
			}
		}
	}

}
