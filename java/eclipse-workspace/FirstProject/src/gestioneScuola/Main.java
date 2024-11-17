package gestioneScuola;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Istanza scanner
		Utente[] utenti = new Utente[3];
		Scanner scanner = new Scanner(System.in);
		
		utenti[0] = new Utente("Mario", "admin", "studente");
		utenti[1] = new Utente("Luigi", "admin", "docente");
		utenti[2] = new Utente("Yoshi", "admin", "amministratore");
		
		
		//Sezione di login
		System.out.println("Login");
		System.out.print("Inserisci il nome utente: ");
		String loginUtente = scanner.next();
		System.out.print("Inserisci la password: ");
		String loginPassword = scanner.next();
		
		int counter = 0;
		//Verifico se i dati sono validi
		for(int i=0; i < utenti.length; i++) {
			if((loginUtente.equals(utenti[i].nomeUtente)) && (loginPassword.equals(utenti[i].password))) {
				counter++;
				System.out.println("ok");
				break;
			}	
		}
		if(counter == 0) {
			System.out.println("Errore. Nome utente o password errati");
		}
		
		
		
		
		
		
	}

}
