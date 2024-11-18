package gestioneScuola;

import java.util.ArrayList;

public class Studenti {
	//	ATTRIBUTI
	private String nome;
	private String cognome;
	private String dataDiNascita;
	private String codiceStudente;
	public ArrayList<Corsi> corsiFrequentati;
	
	
	//	COSTRUTTORE
	
	
	public Studenti(String nome, String cognome, String dataDiNascita, String codiceStudente) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codiceStudente = codiceStudente;
		this.corsiFrequentati = new ArrayList<>();
	}
	
	
	
	//GET E SET
	public String getNome() {
		return nome;
	}
	
	public String getCognome () {
		return cognome;
	}
	
	public String getDataDiNascita () {
		return dataDiNascita;
	}
	
	public String getCodiceStudente () {
		return codiceStudente;
	}

	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome (String cognome) {
		this.cognome = cognome ;
	}
	
	public void setDataDiNascita (String dataDiNascita) {
		this.dataDiNascita = dataDiNascita ;
	}
	
	public void setCodiceStudente (String codiceStudente) {
		this.codiceStudente = codiceStudente ;
	}


	
	@Override
	public String toString() {
		return "Studente: " +nome +" " +cognome +" - "
				+dataDiNascita +" \n"
				+"Codice Studente: " +codiceStudente+" - "
				+"Corsi frequentati: "+corsiFrequentati;
	}
	
	
	
	
	
	
	
	
}
