package base;

public class CostruttoFor {

	public static void main(String[] args) {
		
		
		for(int i = 1; i <= 5; i++) { //for tipico
			
			System.out.println(i);
			
		}
		
		for(int k = 0; 1 == 1; k++) { //for tecnicamente infinito
			
			if(k % 5 == 0) {
				
				continue; //se k e' un multiplo di 5, l'iterazione corrente viene saltata
			}
			
			System.out.println(k);
			
			if(k>100) {
				break; //break permette di uscire anche dei loop infiniti
			}
		}
		
		

	}

}
