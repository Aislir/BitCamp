package gestioneScuola;

import java.util.ArrayList;

public class Corsi {
	//attributi
	private ArrayList<Corsi> corso;
	private String nomeCorso;
	private String codiceCorso;
	private Docenti docente;
	private Studenti studentiIscritti;
	
	//costruttori
	public Corsi(String nomeCorso, String codiceCorso) {
		this.corso = new ArrayList<>();
		this.nomeCorso = nomeCorso;
		this.codiceCorso = codiceCorso;
	}

	public Corsi() {
	}
	
	//metodi Get e Set

	public ArrayList<Corsi> getCorso() {
		return corso;
	}

	public void setCorso(ArrayList<Corsi> corso) {
		this.corso = corso;
	}

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

	public Studenti getStudentiIscritti() {
		return studentiIscritti;
	}

	public void setStudentiIscritti(Studenti studentiIscritti) {
		this.studentiIscritti = studentiIscritti;
	}
	
	
	//metodo toString()
	@Override
	public String toString() {
		return "Corsi [corso=" + corso + ", nomeCorso=" + nomeCorso + ", codiceCorso=" + codiceCorso + ", docente="
				+ docente + ", studentiIscritti=" + studentiIscritti + "]";
	}
	

}
