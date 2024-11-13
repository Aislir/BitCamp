package esercizi;

import java.util.Scanner;

public class CalcolatoreAree {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int scelta;
		
		do {
			//stampa menu opzioni del programma
			System.out.println("Seleziona una figura geometrice:\n");
			System.out.println("1. Quadrato");
			System.out.println("2. Rettangolo");
			System.out.println("3. Triangolo");
			System.out.println("4. Cerchio");
			System.out.println("0. Esci");
			
			scelta = input.nextInt();
			
			switch(scelta) {
			case 1:
				System.out.print("Inserisci la lunghezza del lato: ");
				double lato = input.nextDouble();
				double areaQuadrato = lato * lato;
				System.out.println("L'area del quadrato e': "+areaQuadrato);
				break;
			case 2:
				System.out.print("Inserisci la lunghezza della base: ");
				double base = input.nextDouble();
				System.out.print("Inserisci l'altezza: ");
				double altezza = input.nextDouble();
				double areaRettangolo = base * altezza;
				System.out.println("L'area del rettangolo e': "+areaRettangolo);
				break;
			case 3:
				System.out.print("Inserisci la lunghezza della base: ");
				double baseT = input.nextDouble();
				System.out.print("Inserisci l'altezza: ");
				double altezzaT = input.nextDouble();
				double areaTriangolo = (baseT * altezzaT)/2;
				System.out.println("L'area del triangolo e': "+areaTriangolo);
				break;
			case 4:
				System.out.print("Inserisci la lunghezza del raggio: ");
				double raggio = input.nextDouble();
				double areaCerchio = Math.PI * (raggio*raggio);
				System.out.println("L'area del cerchio e' : "+areaCerchio);
				break;
			case 0:
				System.out.println("Arrivederci");
				break;
			default:
				System.out.println("Scelta non valida.");
			}
			
			System.out.println();
			
		}while(scelta != 0);
		
	}

}
