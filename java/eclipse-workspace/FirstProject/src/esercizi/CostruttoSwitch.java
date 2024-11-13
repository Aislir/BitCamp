package esercizi;
import java.util.Scanner;

public class CostruttoSwitch {

	public static void main(String[] args) {
//		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Inserisci un numero intero tra 1 e 7: ");
		//int i = 0;
		boolean isANumber = false;
		
		do {
			
			isANumber = input.hasNextInt();
			
			if(isANumber) {
				int numeroGiorno = input.nextInt();
				
				switch(numeroGiorno) {
						case 1:
							System.out.println("Lunedi'");
							
							break;
						case 2:
							System.out.println("Martedi'");
							
							break;
						case 3:
							System.out.println("Mercoledi'");
							
							break;
						case 4:
							System.out.println("Giovedi'");
							
							break;
						case 5:
							System.out.println("Venerdi'");
							
							break;
						case 6:
							System.out.println("Sabato");
							
							break;
						case 7:
							System.out.println("Domenica");
							
							break;
						default:
							System.out.println("Numero inserito non compreso tra 1 e 7!");
				} 
					
				
			} else {
				System.out.println("L'input inserito non e' valido!");
				input.nextLine(); //permette di poter inserire nuovamente un valore dopo il primo
			}
		} while(!isANumber);
		
	}

}
