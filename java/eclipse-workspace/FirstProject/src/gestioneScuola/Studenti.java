package gestioneScuola;

import java.util.ArrayList;

public class Studenti {
	//	ATTRIBUTI
	private ArrayList<Studenti> studente;
	private String nome;
	private String cognome;
	private String dataDiNascita;
	private String codiceStudente;
	private String corsiFrequentati;
	
	
	//	COSTRUTTORE
	
	
	public Studenti(String nome, String cognome, String dataDiNascita, String codiceStudente) {
		this.studente = new ArrayList<>();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codiceStudente = codiceStudente;
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
	
	public String getCorsiFrequentati () {
		return corsiFrequentati;
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
	
	public void setCorsiFrequentati (String corsiFrequentati) {
		this.corsiFrequentati = corsiFrequentati ;
	}

	
	@Override
	public String toString() {
		return "Studente: " +nome +" " +cognome +" - "
				+dataDiNascita +" - " 
				+"Codice Studente: " +codiceStudente;
	}
	
	
	
	
	
	
	
	
}
