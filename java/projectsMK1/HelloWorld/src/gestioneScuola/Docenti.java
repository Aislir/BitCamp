package gestioneScuola;

import java.util.ArrayList;

public class Docenti {
	//	ATTRIBUTI
	private String nome;
	private String cognome;
	private String codiceDocente;
	private ArrayList<Corsi> corsiInsegnati;
	
	
	//	COSTRUTTORE
	public Docenti(String nome, String cognome, String codiceDocente) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDocente = codiceDocente;
		this.corsiInsegnati = new ArrayList<>();
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

	public ArrayList<Corsi> getCorsiInsegnati() {
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

	
	
	@Override
	public String toString(){
		return "Docente: " +nome +" " +cognome +" \n"
				+"Codice docente: " +codiceDocente +" - "
				+"Corsi insegnati: " +corsiInsegnati;
	}

	public String InfoDocenteNoCorsi(){
		return "Docente: " +nome +" " +cognome +" - "
				+"Codice Docente: " +codiceDocente;
	}
	
}
