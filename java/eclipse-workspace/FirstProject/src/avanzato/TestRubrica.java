package avanzato;

public class TestRubrica {

	public static void main(String[] args) {
		
		Rubrica[] contatti = new Rubrica[10];

		contatti[0] = new Rubrica("Mario", "Rossi", "3457189800");
		contatti[1] = new Rubrica("Luigi", "Bianchi", "3437782989");
		contatti[2] = new Rubrica("Waluigi", "Bagigi", "2369465692");
		contatti[3] = new Rubrica("Wario", "Acquario", "2383074824");
		
		
		
		
		Rubrica r1 = new Rubrica();
		r1.setNome("Bob");
		r1.setCognome("AggiustaTutto");
		r1.setNumero("3423975822");
		contatti[4] = r1;
		
		contatti[5] = new Rubrica("Bella", "Stracciatella", "4283424545");
		contatti[6] = new Rubrica("Bowser", "Il Browser", "33595700875");
		contatti[7] = new Rubrica("Yoshi", "Tadayoshi", "3276543759");
		contatti[8] = new Rubrica("Oda", "Nobunaga", "724507405");
		contatti[9] = new Rubrica("Dudu", "Bagugu", "984572918");
		
		System.out.println(contatti[0].getCognome());
		System.out.println();
		contatti[0].setCognome("Bros");
		
		for(int i = 0; i < contatti.length; i++) {
			contatti[i].stampaContatti();
		}
		
		Rubrica r2 = new Rubrica();
		
		r2.cercaContatto("Bob", contatti);
	}
		
	
}
