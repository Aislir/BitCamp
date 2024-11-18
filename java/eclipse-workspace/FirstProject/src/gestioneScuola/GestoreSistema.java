package gestioneScuola;

import java.util.Scanner;
import java.util.ArrayList;

public class GestoreSistema {
	
	private ArrayList<Studenti> elencoStudenti;
	private ArrayList<Docenti> elencoDocenti;
	private ArrayList<Corsi> elencoCorsi;

	Scanner scanner = new Scanner(System.in);
	
	public GestoreSistema() {
		
		this.elencoStudenti = new ArrayList<>();
		this.elencoDocenti = new ArrayList<>();
		this.elencoCorsi = new ArrayList<>();
	}
	
	public void aggiungiStudente(Studenti nuovoStudente) {
		
		elencoStudenti.add(nuovoStudente);
		System.out.println("");
		System.out.println("Studente aggiunto con successo");
	}
	
	public void aggiungiDocente(Docenti nuovoDocente) {
		
		elencoDocenti.add(nuovoDocente);
		System.out.println("");
		System.out.println("Docente aggiunto con successo");
	}
	
	public void aggiungiCorso(Corsi nuovoCorso) {
		
		elencoCorsi.add(nuovoCorso);
		System.out.println("");
		System.out.println("Corso aggiunto con successo");
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
		
		for(Corsi corsi : elencoCorsi) {
			if(corsi.getCodiceCorso().equalsIgnoreCase(codiceCorso)) {
				return corsi;
			}
		}
		
		return null;
	}
	
	
	
	
	public void modificaStudente(String codiceStudente, Studenti studenteModificato) {
		
		Studenti studenti = cercaStudentePerCodice(codiceStudente);

		if(studenti != null) {
			int size = studenti.corsiFrequentati.size();
			if(size != 0){
				for(Corsi corso : studenti.corsiFrequentati){
					studenteModificato.corsiFrequentati.add(corso);
				}
			}
			elencoStudenti.set(elencoStudenti.indexOf(studenti), studenteModificato);
			System.out.println("Studente modificato con successo\n");
			visualizzaStudente(studenteModificato.getCodiceStudente());

		} else {
			System.out.println("Non e' stato possibile trovare lo studente da modificare");
		}

	}

	public void modificaDocenteComeDocente(String codiceDocente){
		Docenti docente = cercaDocentePerCodice((codiceDocente));
		if (docente != null){
			System.out.println("Menu modifiche consentite:\n");
			System.out.println("1. Cambia nome");
			System.out.println("2. Cambia cognome\n");
			System.out.print("Scegli un opzione: ");
			int scelta = scanner.nextInt();

			System.out.println();

			switch (scelta){
				case 1:
					System.out.print("Per favore, inserisci il nome: ");
					String nome = scanner.next();
					docente.setNome(nome);
					break;
				case 2:
					System.out.print("Per favore, inserisci il cognome: ");
					String cognome = scanner.next();
					docente.setCognome(cognome);
					break;
				default:
					System.out.println("Errore. Per favore inserisci un valore valido.");
					scanner.nextLine();
					break;
			}
		} else {
			System.out.println("Errore. Non e' stato trovato nessun docente con questo codice.");
		}
	}


	public void modificaDocente(String codiceDocente, Docenti docenteModificato) {

		Docenti docente = cercaDocentePerCodice(codiceDocente);
		if(docente != null) {
			int size = docente.corsiInsegnati.size();
			if(size != 0){
				for(Corsi corso : docente.corsiInsegnati){
					docenteModificato.corsiInsegnati.add(corso);
				}
			}
			elencoDocenti.set(elencoDocenti.indexOf(docente), docenteModificato);
			System.out.println("Docente modificato con successo\n");
			visualizzaDocente(docenteModificato.getCodiceDocente());

		} else {
			System.out.println("Non e' stato possibile trovare il docente da modificare");
		}
		

	}
	
	public void eliminaStudente(String codiceStudente) {
        Studenti studenti = cercaStudentePerCodice(codiceStudente);
        if(studenti != null){
			int size = studenti.corsiFrequentati.size();
			if(size != 0){
				for(Corsi corso : studenti.corsiFrequentati){
					rimuoviStudenteDalCorso(codiceStudente, corso.getCodiceCorso());
				}
			}
        	elencoStudenti.remove(studenti);
			System.out.println("Studente eliminato con successo");
        } else {
			System.out.println("Errore. Nessuno studente trovato con questo codice");
		}
    }
	
	public void eliminaDocente(String codiceDocente) {
        Docenti docenti = cercaDocentePerCodice(codiceDocente);
        if(docenti != null){
        	elencoDocenti.remove(docenti);
			System.out.println("Docente rimosso con successo");
        } else {
			System.out.println("Errore. Nessun docente trovato con questo codice.");
		}

    }
	
	public void visualizzaStudente(String codiceStudente) {
		Studenti studenti = cercaStudentePerCodice(codiceStudente);
		if(studenti != null) {
			System.out.println();
			System.out.println(studenti);
		} else {
			System.out.println("Non e' stato trovato nessuno studente con questo codice");
		}
	}
	
	
	public void visualizzaDocente(String codiceDocente) {
		Docenti docente = cercaDocentePerCodice(codiceDocente);
		if(docente != null) {
			System.out.println();
			System.out.println(docente);
		} else {
			System.out.println("Non e' stato trovato nessun docente con questo codice");
		}
	}

	public void visualizzaCorso(String codiceCorso) {
		Corsi corso = cercaCorsiPerCodice(codiceCorso);
		if(corso != null) {
			System.out.println();
			System.out.println(corso);
		} else {
			System.out.println("Non e' stato trovato nessun corso con questo codice");
		}
	}
	
	public void aggiungiDocenteAlCorso(String codiceDocente, String codiceCorso) {
		Docenti docente = cercaDocentePerCodice(codiceDocente);
		Corsi corso = cercaCorsiPerCodice(codiceCorso);
		if((docente != null) && (corso != null)) {
			corso.setDocente(docente);
			System.out.println("Docente aggiunto al corso con successo");
			visualizzaCorso(codiceCorso);
		} else {
			System.out.println("Errore. Nessun docente o corso trovato con questo codice");
		}
	}
	
	public void aggiungiStudenteAlCorso(String codiceStudente, String codiceCorso) {
		Studenti studente = cercaStudentePerCodice(codiceStudente);
		Corsi corso = cercaCorsiPerCodice(codiceCorso);
		if((studente != null) && (corso != null)) {
			corso.studentiIscritti.add(studente);
			studente.corsiFrequentati.add(corso);
			System.out.println("Studente aggiunto al corso con successo");
			visualizzaCorso(codiceCorso);
		} else {
			System.out.println("Errore. Nessuno studente o corso trovato con questo codice");
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

		if(corso != null) {
			int size = corso.studentiIscritti.size();
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

		if(docente != null) {
			int size = docente.corsiInsegnati.size();
			if(size != 0) {
				for(Corsi corso : docente.corsiInsegnati) {
					System.out.println(corso.getNomeCorso());
					System.out.println(corso.getCodiceCorso());
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
					System.out.println(corso.getDocente());
				}
			} else {
				System.out.println("Lo studente non e' attualmente iscritto a nessun corso");
			}
		} else {
			System.out.println("Non e' stato possibile trovare lo studente selezionato");
		}
	}
	
}
