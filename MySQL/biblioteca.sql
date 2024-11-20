-- Questo e' un commento
# Anche questo e' un commento
/*
Anche queste 4 righe
sono commenti
*/

-- Creazione database
CREATE DATABASE biblioteca; # il nome deve essere sempre in minuscolo

-- Uso del database di nostro interesse
USE biblioteca;

-- Creazione di una tabella
CREATE TABLE libri(	# libri e' il nome della tabella
	id INT PRIMARY KEY AUTO_INCREMENT, 	# auto_increment aumenta in automatica di uno l'indice dell'id
    titolo VARCHAR(100) NOT NULL,
    autore VARCHAR(50) NOT NULL,
    anno_pubblicazione INT,
	genere VARCHAR(30)
); 

-- Comandi DML
-- Comando per inserire un record (riga) all'interno della tabella
INSERT INTO libri (titolo, autore, anno_pubblicazione, genere)
VALUES
('1984', 'George Orwell', 1949, 'distopico'),	 # Esempio di inserimento di un record (riga)
('Il Nome della Rosa', 'Umberto Eco', 1980, 'Storico'),
('Il Signore degli Anelli', 'J.R.R. Tolkien', 1954, 'Fantasy');

-- Comando per interrogare un database per farsi tornare i dati (QUERY)
SELECT * FROM libri; -- ritorna l'intera tabella libri

SELECT titolo, autore FROM libri; -- ritorna la tabella con solo titolo e autore

SELECT * FROM libri WHERE genere = 'Fantasy'; -- ritorna, della tabella libri, i soli record (righe)
											  -- che hanno 'Fantasy' come genere
                                              
SELECT * FROM libri ORDER BY anno_pubblicazione ASC; # ritorna la tabella libri in ordine crescente (ASC, altrimenti DESC per decrescemte)
													 # dell'anno di pubblicazione 
                                                     
SELECT * FROM libri LIMIT 2; # ritorna solo i primi 2 elementi della tabella

-- comando per modificare un record
# Modifica, nella tabella libri, il genere con 'Fantascienza' del libro con titolo '1984'
UPDATE libri SET genere = 'Fantascienza' WHERE titolo = '1984';  

# Comando per eliminare un record
DELETE FROM libri WHERE titolo = 'Il Nome della Rosa';

# Aggiungere una colonna (field o campo) ad una tabella pre-esistente (non consigliato)
ALTER TABLE libri ADD email_autore VARCHAR(100);
                                       
# Comando per cambiare nome di um campo (non consigliato)                                                                              
ALTER TABLE libri CHANGE titolo titolo_libro VARCHAR(100);

# Comando per eliminare una tabella/database
DROP table libri;

# Comando per creare un utente					//questa e' la password
CREATE USER 'mariorossi'@'localhost' IDENTIFIED BY 'pippo85';

# Assegnare diritti ad un utente
GRANT SELECT, INSERT, UPDATE, DELETE ON biblioteca.libri TO 'mariorossi'@'localhost'
# localhost e' la macchina dalla quale poter apportare modifiche.
# GRANT e' il comando per poter assegnare diritti. SELECT, INSERT, ecc... sono i poteri che gli diamo
# In questo caso diamo diritti di visualizzare, modificare e cancellare la table libri
# allo user mariorossi che sta usando la macchina 'localhost'

FLUSH PRIVILEGES; # Per rendere effettivi i diritti assegnati