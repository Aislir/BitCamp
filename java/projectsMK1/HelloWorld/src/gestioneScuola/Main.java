package gestioneScuola;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Istanza scanner
		Utente[] utenti = new Utente[3];
		Scanner scanner = new Scanner(System.in);
		GestoreSistema gestoreSistema = new GestoreSistema();
		
		utenti[0] = new Utente("Mario", "admin", "studente");
		utenti[1] = new Utente("Luigi", "admin", "docente");
		utenti[2] = new Utente("Yoshi", "admin", "amministratore");

		String ruoloUtente = "";

		int counter = 0;
		do{
			//Sezione di login
			System.out.println("Login");
			System.out.print("Inserisci il nome utente: ");
			String loginUtente = scanner.next();
			System.out.print("Inserisci la password: ");
			String loginPassword = scanner.next();

			//Verifico se i dati sono validi
			for(int i=0; i < utenti.length; i++) {
				if((loginUtente.equals(utenti[i].getNomeUtente())) && (loginPassword.equals(utenti[i].getPassword()))) {
					counter++;
					ruoloUtente = utenti[i].getRuolo();

					break;
				}
			}

			if(counter == 0) {
				System.out.println("Errore. Nome utente o password errati");
			} else {
				if (ruoloUtente == "studente"){

					boolean exitStudente = true;
					while(exitStudente){

						System.out.println("1. Visualizza i tuoi corsi");
						System.out.println("2. Visualizza il tuo profilo studente");
						System.out.println("3. Visualizza informazione dei docenti dei tuoi corsi");
						System.out.println("4. Logout\n");
						System.out.print("Scegli un opzione: ");

						//richiesta input utente
						int scelta = scanner.nextInt();

						//entra all'interno del menu studente
						switch (scelta){
							case 1:
								System.out.print("Per favore, inserisci il codice studente: ");
								String codiceStudente = scanner.next();
								gestoreSistema.visualizzaCorsiStudente(codiceStudente);
								break;
							case 2:
								System.out.print("Per favore, inserisci il codice studente: ");
								codiceStudente = scanner.next();
								gestoreSistema.visualizzaStudente(codiceStudente);
								break;
							case 3:
								System.out.print("Per favore, inserisci il codice studente: ");
								codiceStudente = scanner.next();
								gestoreSistema.visualizzaDocentiDeiCorsi(codiceStudente);
								break;
							case 4:
								System.out.println("Arrivederci");
								exitStudente = false;
								counter = 0;
								break;
							default:
								System.out.println("Scelta non valida. Inserisci un altro valore");
								scanner.nextLine();
								break;
						}

					}

				} else if (ruoloUtente == "docente") {
					boolean exitDocente = true;
					while(exitDocente){

						System.out.println("1. Visualizza i tuoi corsi");
						System.out.println("2. Visualizza studenti iscritti ad un tuo corso");
						System.out.println("3. Aggiorna informazioni profilo");
						System.out.println("4. Logout\n");
						System.out.print("Scegli un opzione: ");

						//richiesta input utente
						int scelta = scanner.nextInt();

						//entra all'interno del menu studente
						switch (scelta){
							case 1:
								System.out.print("Per favore, inserisci il codice Docente: ");
								String codiceDocente = scanner.next();
								gestoreSistema.reportisticaCorsi(codiceDocente);
								break;
							case 2:
								System.out.print("Per favore, inserisci il codice Docente: ");
								codiceDocente = scanner.next();
								gestoreSistema.reportisticaStudenti(codiceDocente);
								break;
							case 3:
								System.out.print("Per favore, inserisci il codice Docente: ");
								String nuovoCodiceDocente = scanner.nextLine();
								gestoreSistema.modificaDocenteComeDocente(nuovoCodiceDocente);
								break;
							case 4:
								System.out.println("Arrivederci");
								exitDocente = false;
								counter = 0;
								break;
							default:
								System.out.println("Scelta non valida. Inserisci un altro valore");
								scanner.nextLine();
								break;
						}

					}

				} else if (ruoloUtente == "amministratore") {
					boolean adminExit = true;
					while(adminExit){
						System.out.println("1. Gestione studenti");
						System.out.println("2. Gestione docenti");
						System.out.println("3. Gestione corsi");
						System.out.println("4. Reportistica");
						System.out.println("5. Logout\n");
						System.out.print("Scegli un opzione: ");

						int scelta = scanner.nextInt();

						switch (scelta){
							case 1:
								boolean caseExit1 = true;
								while(caseExit1){
									//gestione studenti


									System.out.println("1. Aggiungi studente");
									System.out.println("2. Modifica studente");
									System.out.println("3. Rimuovi studente");
									System.out.println("4. Visualizza profilo studente");
									System.out.println("5. Torna al menu principale\n");
									System.out.print("Scegli un opzione: ");

									int sceltaMenuStudente = scanner.nextInt();
									scanner.nextLine();

									switch (sceltaMenuStudente){

										//aggiungi studente

										case 1:
											System.out.println("----------------------");
											System.out.println("Aggiunta nuovo studente\n");
											System.out.print("Per favore, inserisci il nome dello studente: ");
											String nomeStudente = scanner.nextLine();
											System.out.print("Inserisci il cognome dello studente: ");
											String cognomeStudente = scanner.nextLine();
											System.out.print("Inserisci la data di nascita dello studente: ");
											String dataDiNascitaStudente = scanner.nextLine();
											System.out.print("Inserisci il codice studente: ");
											String codiceStudente = scanner.nextLine();
											Studenti studente = new Studenti(nomeStudente, cognomeStudente, dataDiNascitaStudente, codiceStudente);
											gestoreSistema.aggiungiStudente(studente);

											break;
										case 2:

											//modifica studente

											System.out.println("----------------------");
											System.out.println("Modifica studente\n");

											System.out.print("Inserisci il codice studente dello studente da modificare: ");
											String codiceVecchioStudente = scanner.nextLine();

											System.out.print("Per favore, inserisci il nome dello studente: ");
											nomeStudente = scanner.nextLine();
											System.out.print("Inserisci il cognome dello studente: ");
											cognomeStudente = scanner.nextLine();
											System.out.print("Inserisci la data di nascita dello studente: ");
											dataDiNascitaStudente = scanner.nextLine();
											System.out.print("Inserisci il codice studente: ");
											codiceStudente = scanner.nextLine();
											Studenti studenteModificato = new Studenti(nomeStudente, cognomeStudente, dataDiNascitaStudente, codiceStudente);
											gestoreSistema.modificaStudente(codiceVecchioStudente, studenteModificato);

											break;
										case 3:
											//rimuovi studente
											System.out.println("----------------------");
											System.out.println("Rimuovi studente\n");
											System.out.print("Inserisci il codice studente dello studente da rimuovere: ");
											codiceStudente = scanner.nextLine();

											gestoreSistema.eliminaStudente(codiceStudente);

											break;
										case 4:
											//visualizza profilo studente
											System.out.println("----------------------");
											System.out.println("Visualizzazione profilo studente\n");
											System.out.print("Inserisci il codice studente dello studente da visualizzare: ");
											codiceStudente = scanner.nextLine();
											gestoreSistema.visualizzaStudente(codiceStudente);
											break;
										case 5:
											//Ritorno al menu principale
											System.out.println("----------------------");
											System.out.println("\n");
											caseExit1 = false;
											break;
										default:
											System.out.println("Scelta non valida. Inserisci un altro valore");
											scanner.nextLine();
											break;
									}

								}
								break;
							case 2:
								//gestione docenti
								boolean caseExit2 = true;
								while(caseExit2){
									//gestione docenti
									System.out.println("1. Aggiungi docente");
									System.out.println("2. Modifica docente");
									System.out.println("3. Rimuovi docente");
									System.out.println("4. Visualizza profilo docente");
									System.out.println("5. Torna al menu principale\n");
									System.out.print("Scegli un opzione: ");

									int sceltaMenuDocente = scanner.nextInt();
									scanner.nextLine();

									switch (sceltaMenuDocente){



										case 1:
											//aggiungi docente

											System.out.println("----------------------");
											System.out.println("Aggiunta nuovo docente\n");
											System.out.print("Per favore, inserisci il nome del docente: ");
											String nomeDocente = scanner.nextLine();
											System.out.print("Inserisci il cognome del docente: ");
											String cognomeDocente = scanner.nextLine();
											System.out.print("Inserisci il codice docente: ");
											String codiceDocente = scanner.nextLine();
											Docenti docente = new Docenti(nomeDocente, cognomeDocente, codiceDocente);
											gestoreSistema.aggiungiDocente(docente);


											break;
										case 2:
											//modifica docente


											System.out.println("----------------------");
											System.out.println("Aggiunta nuovo docente\n");

											System.out.print("Inserisci il codice docente del docente da modificare: ");
											String codiceVecchioDocente = scanner.nextLine();

											System.out.print("Per favore, inserisci il nome del docente: ");
											nomeDocente = scanner.nextLine();
											System.out.print("Inserisci il cognome del docente: ");
											cognomeDocente = scanner.nextLine();
											System.out.print("Inserisci il codice docente: ");
											codiceDocente = scanner.nextLine();
											Docenti docenteModificato = new Docenti(nomeDocente, cognomeDocente, codiceDocente);
											gestoreSistema.modificaDocente(codiceVecchioDocente, docenteModificato);

											break;
										case 3:
											//rimuovi docente
											System.out.println("----------------------");
											System.out.println("Rimuovi docente\n");
											System.out.print("Inserisci il codice docente del docente da rimuovere: ");
											codiceDocente = scanner.nextLine();

											gestoreSistema.eliminaDocente(codiceDocente);

											break;
										case 4:
											//visualizza profilo docente
											System.out.println("----------------------");
											System.out.println("Visualizzazione profilo docente\n");
											System.out.print("Inserisci il codice docente del docente da visualizzare: ");
											codiceDocente = scanner.nextLine();
											gestoreSistema.visualizzaDocente(codiceDocente);

											break;
										case 5:
											//Ritorno al menu principale
											System.out.println("----------------------");
											System.out.println("\n");
											caseExit2 = false;
											break;
										default:
											System.out.println("Scelta non valida. Inserisci un altro valore");
											scanner.nextLine();
											break;
									}

								}
								break;
							case 3:
								//gestione corsi
								boolean caseExit3 = true;
								while(caseExit3){
									System.out.println("1. Aggiungi nuovo corso");
									System.out.println("2. Assegna docente ad un corso");
									System.out.println("3. Iscrivi studente ad un corso");
									System.out.println("4. Rimuovi studente da un corso");
									System.out.println("5. Torna al menu principale\n");

									System.out.print("Scegli un opzione: ");

									int sceltaMenuCorsi = scanner.nextInt();
									scanner.nextLine();


									switch (sceltaMenuCorsi){
										case 1:
											//Aggiungi nuovo corso
											System.out.println("----------------------");
											System.out.println("Aggiunta nuovo corso\n");
											System.out.print("Per favore, inserisci il nome del corso: ");
											String nomeCorso = scanner.nextLine();
											System.out.print("Per favore, inserisci il codice corso: ");
											String codiceCorso = scanner.nextLine();

											Corsi corso = new Corsi(nomeCorso, codiceCorso);

											gestoreSistema.aggiungiCorso(corso);

											break;
										case 2:
											//Assegna docente ad un corso
											System.out.println("----------------------");
											System.out.println("Assegnazione docente a corso\n");
											System.out.print("Per favore, inserisci il codice corso: ");
											codiceCorso = scanner.nextLine();
											System.out.print("Per favore, inserisci il codice docente del docente da assegnare: ");
											String codiceDocente = scanner.nextLine();

											gestoreSistema.aggiungiDocenteAlCorso(codiceDocente, codiceCorso);
											break;
										case 3:
											//Iscrivi studente ad un corso
											System.out.println("----------------------");
											System.out.println("Iscrizione studente a corso\n");
											System.out.print("Per favore, inserisci il codice corso: ");
											codiceCorso = scanner.nextLine();
											System.out.print("Per favore, inserisci il codice studente dello studente da iscrivere: ");
											String codiceStudente = scanner.nextLine();

											gestoreSistema.aggiungiStudenteAlCorso(codiceStudente, codiceCorso);

											break;
										case 4:
											//Rimuovi studente da un corso
											System.out.println("----------------------");
											System.out.println("Rimozione studente da corso\n");
											System.out.print("Per favore, inserisci il codice corso: ");
											codiceCorso = scanner.nextLine();
											System.out.print("Per favore, inserisci il codice studente dello studente da rimuovere: ");
											codiceStudente = scanner.nextLine();

											gestoreSistema.rimuoviStudenteDalCorso(codiceStudente, codiceCorso);

											break;
										case 5:
											//Torna al menu principale
											System.out.println("----------------------");
											System.out.println("\n");
											caseExit3 = false;
											break;
										default:
											System.out.println("Errore. Inserisci un valore valido.");

											break;
									}

								}

								break;
							case 4:
								//reportistica
								boolean caseExit4 = true;
								while(caseExit4){

									System.out.println("1. Visualizzazione studenti per corso");
									System.out.println("2. Visualizzazione corsi per docente");
									System.out.println("3. Torna al menu principale\n");
									System.out.print("Scegli un opzione: ");

									int sceltaReportistica = scanner.nextInt();
									scanner.nextLine();

									switch (sceltaReportistica){
										case 1:
											//Visualizzazione studenti per corso
											System.out.println("----------------------");
											System.out.println("Visualizzazione studenti per corso\n");

											System.out.print("Per favore, inserisci il codice corso: ");
											String codiceCorso = scanner.nextLine();

											gestoreSistema.reportisticaStudenti(codiceCorso);
											scanner.nextLine();
											break;
										case 2:
											//Visualizzazione corsi per docente
											System.out.println("----------------------");
											System.out.println("Visualizzazione corsi per docente\n");

											System.out.print("Per favore, inserisci il codice docente: ");
											String codiceDocente = scanner.nextLine();

											gestoreSistema.reportisticaCorsi(codiceDocente);
											scanner.nextLine();
											break;
										case 3:
											//Torna al menu principale
											System.out.println("----------------------");
											System.out.println("\n");
											caseExit4 = false;

											break;
										default:
											System.out.println("Errore. Inserisci un valore valido.");
											scanner.nextLine();
											break;
									}

								}
								break;
							case 5:
								System.out.println("Arrivederci");
								adminExit = false;
								counter = 0;
								break;
							default:
								System.out.println("Errore. Per favore inserisci un valore valido");
								break;
						}

					}

				}
			}
			System.out.println(counter);
		



		} while(counter == 0);

		scanner.close();
	}

}
