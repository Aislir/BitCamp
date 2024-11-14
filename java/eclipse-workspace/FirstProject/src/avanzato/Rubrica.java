package avanzato;

public class Rubrica {
	
	private String nome;
	private String cognome;
	private String numero;
	
	public Rubrica(String nome, String cognome, String numero) {
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		
	}
	
	public Rubrica() {}
	
	
	//GETTERS
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getNumero() {
		return numero;
	}
	
	//SETTERS
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void stampaContatti() {
		System.out.println("Nome: " +nome);
		System.out.println("Cognome: " +cognome);
		System.out.println("Numero: " +numero);
		System.out.println();
	}
	
	public void cercaContatto(String nome, Rubrica contatti[]) {
		System.out.println("Ricerca contatto...\n");
		for(int i = 0; i < contatti.length; i++) {
			if (contatti[i].nome == nome) {
				System.out.println("Contatto trovato!\n");
				System.out.println("Nome: " +contatti[i].nome);
				System.out.println("Cognome: " +contatti[i].cognome);
				System.out.println("Numero: " +contatti[i].numero);
			} else if(contatti[i].cognome == nome) {
				System.out.println("Contatto trovato!\n");
				System.out.println("Nome: " +contatti[i].nome);
				System.out.println("Cognome: " +contatti[i].cognome);
				System.out.println("Numero: " +contatti[i].numero);
			}
		}
	}
	
}
