package gestioneScuola;

import java.util.ArrayList;

public class Docenti {
	//	ATTRIBUTI
	private ArrayList<Docenti> docente;
	private String nome;
	private String cognome;
	private String codiceDocente;
	private String corsiInsegnati;
	
	
	//	COSTRUTTORE
	public Docenti(String nome, String cognome, String codiceDocente, String corsiInsegnati) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDocente = codiceDocente;
		this.corsiInsegnati = corsiInsegnati;
	}
	
	
	
	//GET E SET
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getCodiceDocente() {
		return codiceDocente;
	}
	
	public String getCorsiInsegnati() {
		return corsiInsegnati;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setCodiceDocente(String codiceDocente) {
		this.codiceDocente = codiceDocente;
	}
	
	public void setCorsiInsegnati(String corsiInsegnati) {
		this.corsiInsegnati = corsiInsegnati;
	}
	
	
	@Override
	public String toString(){
		return "Docente: " +nome +" " +cognome +" - "
				+"Codice docente: " +codiceDocente +" - "
				+"Corsi insegnati: " +corsiInsegnati +" - ";
	}
	
	
	
}
