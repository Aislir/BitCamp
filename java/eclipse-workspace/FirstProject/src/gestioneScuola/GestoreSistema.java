package gestioneScuola;

import java.util.ArrayList;

public class GestoreSistema {
	
	private ArrayList<Studenti> elencoStudenti;
	private ArrayList<Docenti> elencoDocenti;
	private ArrayList<Corsi> elencoCorsi;
	
	public GestoreSistema() {
		
		this.elencoStudenti = new ArrayList<>();
		this.elencoDocenti = new ArrayList<>();
		this.elencoCorsi = new ArrayList<>();
	}
	
	public void aggiungiStudente(Studenti nuovoStudente) {
		
		elencoStudenti.add(nuovoStudente);
	}
	
	public void aggiungiDocente(Docenti nuovoDocente) {
		
		elencoDocenti.add(nuovoDocente);	
	}
	
	public void aggiungiCorso(Corsi nuovoCorso) {
		
		elencoCorsi.add(nuovoCorso);
	}
	
	public Studenti cercaStudentePerCodice(String codiceStudente) {
		
		for(Studenti studenti : elencoStudenti) {
			if(studenti.getCodiceStudente().equalsIgnoreCase(codiceStudente)) {
				return studenti;
			}
		}
		
		return null;
	}
	
	public Docenti cercaDocentePerCodice(String codiceDocente) {
			
			for(Docenti docenti : elencoDocenti) {
				if(docenti.getCodiceDocente().equalsIgnoreCase(codiceDocente)) {
					return docenti;
				}
			}
			
			return null;
	}
	
	
	public Corsi cercaCorsiPerCodice(String codiceCorso) {
		
		for(Corsi corsi : corso) {
			if(corsi.getCodiceCorso().equalsIgnoreCase(codiceCorso)) {
				return corsi;
			}
		}
		
		return null;
	}
	
	
	
	
	public boolean modificaStudente(String codiceStudente, Studenti studenteModificato) {
		
		Studenti studenti = cercaStudentePerCodice(codiceStudente);
		if(studenti != null) {
			elencoStudenti.set(elencoStudenti.indexOf(studenti), studenteModificato);
			
			return true;
		}
		
		return false;
	}
	
	public boolean modificaDocente(String codiceDocente, Docenti docenteModificato) {
		
		Docenti docenti = cercaDocentePerCodice(codiceDocente);
		if(docenti != null) {
			elencoDocenti.set(elencoDocenti.indexOf(docenti), docenteModificato);
			
			return true;
		}
		
		return false;
	}
	
	public boolean eliminaStudente(String codiceStudente) {
        Studenti studenti = cercaStudentePerCodice(codiceStudente);
        if(studenti != null){
        	elencoStudenti.remove(studenti);
            return true;
        }
        return false;
    }
	
	public boolean eliminaDocente(String codiceDocente) {
        Docenti docenti = cercaDocentePerCodice(codiceDocente);
        if(docenti != null){
        	elencoDocenti.remove(docenti);
            return true;
        }
        return false;
    }
	
	public void visualizzaStudente(String codiceStudente) {
		Studenti studenti = cercaStudentePerCodice(codiceStudente);
		if(studenti != null) {
			System.out.println(studenti);
		} else {
			System.out.println("Non e' stato trovato nessuno studente con questo codice");
		}
	}
	
	
	public void visualizzaDocente(String codiceDocente) {
		Docenti docente = cercaDocentePerCodice(codiceDocente);
		if(docente != null) {
			System.out.println(docente);
		} else {
			System.out.println("Non e' stato trovato nessuno studente con questo codice");
		}
	}
	
	public void aggiungiDocenteAlCorso(String codiceDocente, String codiceCorso) {
		Docenti docente = cercaDocentePerCodice(codiceDocente);
		Corsi corso = cercaCorsiPerCodice(codiceCorso);
		if((docente != null) && (corso != null)) {
			corso.docente = docente;
			System.out.println("Docente aggiunto al corso con successo");
		} else {
			System.out.println("Errore. Nessun docente trovato con questo codice");
		}
	}
	
	public void aggiungiStudenteAlCorso(String codiceStudente, String codiceCorso) {
		Studenti studente = cercaStudentePerCodice(codiceStudente);
		Corsi corso = cercaCorsiPerCodice(codiceCorso);
		if((studente != null) && (corso != null)) {
			corso.studentiIscritti.add(studente);
			System.out.println("Studente aggiunto al corso con successo");
		} else {
			System.out.println("Errore. Nessuno studente trovato con questo codice");
		}
	}
	
	public void rimuoviStudenteDalCorso(String codiceStudente, String codiceCorso) {
		int counter = 0;
		Studenti studente = cercaStudentePerCodice(codiceStudente);
		Corsi corso = cercaCorsiPerCodice(codiceCorso);
		if(corso.studentiIscritti.contains(studente)) {
			corso.studentiIscritti.remove(studente);
			counter++;
			System.out.println("Studente rimosso dal corso con successo");
		}
		if(counter == 0) {
			System.out.println("Errore. Nessuno studente trovato con questo codice");
		}
		
	}
	
	public void reportisticaStudenti(String codiceCorso) {
		Corsi corso = cercaCorsiPerCodice(codiceCorso);
		int size = 0;
		if(corso != null) {
			size = corso.studentiIscritti.size();
			if(size != 0) {
				for(Studenti studente : corso.studentiIscritti) {
					System.out.println(studente);
				}
			} else {
				System.out.println("Questo corso non ha attualmente nessuno studente iscritto");
			}
		} else {
			System.out.println("Errore. Nessun corso trovato con questo codice");
		}
	}
	
	public void reportisticaCorsi(String codiceDocente) {
		Docenti docente = cercaDocentePerCodice(codiceDocente);
		int size = 0;
		if(docente != null) {
			size = docente.corsiInsegnati.size();
			if(size != 0) {
				for(Corsi corso : docente.corsiInsegnati) {
					System.out.println(corso.nomeCorso);
					System.out.println(corso.codiceCorso);
				}
			} else {
				System.out.println("Il docente selezionato non insegna nessun corso");
			}
		} else {
			System.out.println("Nessun docente con questo codice");
		}
	}
	
	public void visualizzaCorsiStudente(String codiceStudente) {
		Studenti studente = cercaStudentePerCodice(codiceStudente);
		int size = 0;
		if(studente != null) {
			size = studente.corsiFrequentati.size();
			if(size != 0) {
				for(Corsi corso : studente.corsiFrequentati) {
					System.out.println(corso);
				}
			} else {
				System.out.println("Lo studente selezionato non e' attualmente iscritto a nessun corso");
			}
		} else {
			System.out.println("Non e' stato possibile trovare lo studente selezionato");
		}
	}
	
	public void visualizzaDocentiDeiCorsi(String codiceStudente) {
		Studenti studente = cercaStudentePerCodice(codiceStudente);
		int size = 0;
		if(studente != null) {
			size = studente.corsiFrequentati.size();
			if(size != 0) {
				for(Corsi corso : studente.corsiFrequentati) {
					System.out.println(corso.docente);
				}
			}
		}
	}
	
}
