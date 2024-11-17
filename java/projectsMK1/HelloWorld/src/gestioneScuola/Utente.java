package gestioneScuola;

public class Utente {
	//attributi
	private Utente[] utenti = new Utente [3];
	private String nomeUtente;
	private String password;
	private String ruolo;
	//utenti[0] = new utente("Mario", "admin", "studente");
	//utenti[1] = new utente("Luigi", "admin", "docente");
	//utenti[2] = new utente("Yoshi", "admin", "amministratore");
	
	//costruttore
	public Utente(String nomeUtente, String password, String ruolo) {
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	//Metodi Get e Set
	public Utente[] getUtenti() {
		return utenti;
	}

	public void setUtenti(Utente[] utenti) {
		this.utenti = utenti;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
