package gestioneScuola;

import java.util.ArrayList;

public class Corsi {
	//attributi

	private String nomeCorso;
	private String codiceCorso;
	private Docenti docente;
	public ArrayList<Studenti> studentiIscritti;
	
	//costruttori
	public Corsi(String nomeCorso, String codiceCorso) {
		this.studentiIscritti = new ArrayList<>();
		this.nomeCorso = nomeCorso;
		this.codiceCorso = codiceCorso;
	}

	public Corsi() {
	}
	
	//metodi Get e Set
	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public String getCodiceCorso() {
		return codiceCorso;
	}

	public void setCodiceCorso(String codiceCorso) {
		this.codiceCorso = codiceCorso;
	}

	public Docenti getDocente() {
		return docente;
	}

	public void setDocente(Docenti docente) {
		this.docente = docente;
	}
	
	
	//metodo toString()
	@Override
	public String toString() {
		return "nomeCorso: " + nomeCorso + ", codiceCorso: " + codiceCorso + ", \n"+ docente;
	}
	

}
