package esercizi;

import java.util.Scanner;

public class ConvertitoreUnita {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int scelta = -1;
		
		System.out.println("Benvenuto al convertitore d'unita'\n");
		
		
		String[][] conversioniUnita = new String[3][2];
		
		conversioniUnita[0][0] = "Da Celsius a Fahrenheit";
		conversioniUnita[0][1] = "Da Fahrenheit a Celsius";
		
		conversioniUnita[1][0] = "Da Chilometri a Miglia";
		conversioniUnita[1][1] = "Da Miglia a Chilometri";
		
		conversioniUnita[2][0] = "Da Chilogrammi a Libbre";
		conversioniUnita[2][1] = "Da Libbre a Chilogrammi";
		
		while(scelta != 0) {
			
			System.out.println("Scegli una tra le seguenti conversioni: \n");
			int k = 1;
			
			for(int i = 0; i < conversioniUnita.length; i++) {
				
				System.out.println((k++) + ") " + conversioniUnita[i][0]);
				System.out.println((k++) + ") " + conversioniUnita[i][1]);
			}
			System.out.println("0) Esci dal programma");
			System.out.println();
			
			if(input.hasNextInt()){
				scelta = input.nextInt();
				
				switch(scelta) {
				case 1:
					System.out.print("Inserisci il valore da convertire: ");
					double celsius = input.nextDouble();
					double calcFahr = (celsius * 9/5) + 32;
					System.out.println(celsius + " gradi Celsius equivalgono a " +calcFahr+ " gradi Fahreneit.");
					break;
				case 2:
					System.out.print("Inserisci il valore da convertire: ");
					double fahrenheit = input.nextDouble();
					double calcCels = (fahrenheit - 32) * 5/9;
					System.out.println(fahrenheit + " gradi Fahreneit equivalgono a " +calcCels+ " gradi Celsius.");
					break;
				case 3:
					System.out.print("Inserisci il valore da convertire: ");
					double chilometri = input.nextDouble();
					double calcMiglia = chilometri * 0.621371;
					System.out.println(chilometri + " chilometri equivalogono a "+calcMiglia+ " miglia.");
					break;
				case 4:
					System.out.print("Inserisci il valore da convertire: ");
					double miglia = input.nextDouble();
					double calcChilometri = miglia / 0.621371;
					System.out.println(miglia+ " miglia equivalogono a "+calcChilometri+ " chilometri.");
					break;
				case 5:
					System.out.print("Inserisci il valore da convertire: ");
					double kg = input.nextDouble();
					double calcLibbre = kg * 2.20462;
					System.out.println(kg + " chili equivalgono a "+calcLibbre+ " libbre.");
					break;
				case 6:
					System.out.print("Inserisci il valore da convertire: ");
					double libbre = input.nextDouble();
					double calcKg = libbre / 2.20462;
					System.out.println(libbre + " libbre equivalgono a "+calcKg+ " chili.");
					break;
				case 0:
					System.out.println("Arrivederci.");
					break;
				default:
					System.out.println("Per favore inserisci un valore valido.");
				}
			} else {
				System.out.println("Per favore inserisci un valore valido.");
				input.nextLine();
			}
			System.out.println();
		}
		
		
		input.close();
		
		
	}

}
