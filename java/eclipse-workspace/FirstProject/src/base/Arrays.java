package base;

public class Arrays {
	
	public static void main(String[] args) {
		
		//dichiarazione e inizializzazione array monodimensionale
		int[] numeri = {1,2,3,4,5}; 
		
		for(int i = 0; i < numeri.length; i++) {	
			System.out.println("Il valore dell'elemento "+ i + " e' " +numeri[i]);
		}
		
		numeri[3] = 8; //riassegnazione di un valore all'interno dell'array
		System.out.println(numeri[3]);
		
		//dichiarazione e inializzazione array bidimensionale
		int[][] array2D = { //prima coppia di quadre per la riga, seconda per la colonna
			//	 0 1  colonne
				{1,2}, //riga 0
				{3,4}, //riga 1
				{5,6}  //riga 2
				};
		
		array2D[0][0] = 5; //riassegnazione elemento in riga 0 colonna 0 (1)
		array2D[2][1] =10; //riassegnazione elemento in riga 2 colonna 1 (6)
		
		//dichiarazioone e inizializzazione array tridimensionale
		//prima coppia di quadre per specificare la "profondita"
		//seconda coppia per la riga
		//terza coppia per la colonna
		int[][][] array3D = {
				{//prima tabella (0)
					{1,2}, 
					{3,4},
					{5,6}}, 
				{//seconda tabella (1)
					{7,8},
					{9,10},
					{11,12}}};
		
		//loop all'interno di un array 3D
		System.out.println("Inizio array 3D");
		for(int a = 0; a < array3D.length; a++) {
			for(int b = 0; b < array3D[a].length; b++) {
				for(int c = 0; c < array3D[a][b].length; c++) {
					System.out.print(array3D[a][b][c] + " ");
				} 
				System.out.println(); //permette di visualizzare come tabella
			} 
		}
		
		array3D[1][0][1] = 6; //modifica l'elemento nella seconda tabella, prima riga, seconda colonna (8)
		
		System.out.println(array3D[0][1][0]); //(3)
		
		
		//dichiarazione e inizializzazione array quadridimensionale
		//prima coppia per specificare il contenuto della profondita
		//seconda coppia per la profondita
		int[][][][] array4D = {{{{1,2},{3,4},{5,6}},{{7,8},{9,10}}}, {{{1,2},{3,4},{5,6}},{{7,8},{9,10}}}};
		
		
		//dichiarazione di un array bidimensionale vuoto
		
		int[][] arrayInt = new int[3][2]; //array 2D vuoto composto da 3 righe e 2 colonne
		
		arrayInt[0][0] = 1; //inizializzazione elemento in riga 0 colonna 0
		arrayInt[0][1] = 2;
		arrayInt[1][0] = 3;
		arrayInt[1][1] = 4;
		arrayInt[2][0] = 5;
		arrayInt[2][1] = 6;
		
		System.out.println("Inizio loop array 2D");
		
		//loop per ciclare all'interno di un array bidimensionale
		for(int k = 0; k < arrayInt.length; k++) { //loop all'interno della riga
			for(int j = 0; j < arrayInt[k].length; j++) { //loop all'interno della colonna
				System.out.print(arrayInt[k][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}
}
