package base;
import java.util.Scanner;

public class CostruttoWhile {

	public static void main(String[] args) {
		
		int num = 0;
		Scanner input = new Scanner(System.in);
		
		while(num >= 0) { //loop che va avanti fintanto che num non e' negativo
			System.out.println("Inserisci un valore maggiore di 0");
			num = input.nextInt();
			System.out.println("Hai inserito il numero "+num);
		}
		
		int somma = 0;
		
		while(true) { //loop tecnicamente infinito
			System.out.println("Inserisci un numero intero positivo: ");
			num = input.nextInt();
			if(num < 0) {
				break; //permette di uscire dal while nel case num e' negativo
			}
			
			somma += num;
			System.out.println("L'attuale somma dei numeri inseriti e': "+somma);
		}
	}

}
