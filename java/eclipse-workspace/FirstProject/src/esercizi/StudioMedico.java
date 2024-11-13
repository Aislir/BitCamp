package esercizi;

public class StudioMedico {

	public static void main(String[] args) {
		
		String[][] infoPazienti = new String[5][4];
		
		infoPazienti[0][0] = "Mario Rossi";
		infoPazienti[0][1] = "25";
		infoPazienti[0][2] = "M";
		infoPazienti[0][3] = "Negativo";
		
		infoPazienti[1][0] = "Anna Bianchi";
		infoPazienti[1][1] = "35";
		infoPazienti[1][2] = "F";
		infoPazienti[1][3] = "Positivo";
		
		infoPazienti[2][0] = "Carlo Verdi";
		infoPazienti[2][1] = "50";
		infoPazienti[2][2] = "M";
		infoPazienti[2][3] = "Positivo";
		
		infoPazienti[3][0] = "Giovanna Neri";
		infoPazienti[3][1] = "45";
		infoPazienti[3][2] = "F";
		infoPazienti[3][3] = "Negativo";
		
		infoPazienti[4][0] = "Peppe Gialli";
		infoPazienti[4][1] = "94";
		infoPazienti[4][2] = "M";
		infoPazienti[4][3] = "Positivo";
		
		System.out.println("Elenco Pazienti: ");
		System.out.println("----------------\n");
		
		for(int i = 0; i < infoPazienti.length; i++) {
			System.out.println("Nome: "+infoPazienti[i][0]);
			System.out.println("Eta': "+infoPazienti[i][1]);
			System.out.println("Sesso: "+infoPazienti[i][2]);
			System.out.println("Gruppo sanguigno: "+infoPazienti[i][3]+"\n");
		}

	}

}
