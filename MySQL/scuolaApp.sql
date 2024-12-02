CREATE DATABASE scuolaApp;

USE scuolaApp;

CREATE table studenti(
	id_studente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    matricola VARCHAR(50) UNIQUE NOT NULL
);    

-- tabella per i corsi
CREATE TABLE corsi(
	id_corso INT AUTO_INCREMENT PRIMARY KEY,
    nome_corso VARCHAR(100),
    docente VARCHAR(100) NOT NULL
);

-- tabella per i professori dei corsi
CREATE TABLE iscrizioni(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_studente INT NOT NULL,
    id_corso INT NOT NULL,
    FOREIGN KEY (id_studente) REFERENCES studenti(id) ON DELETE CASCADE,
    FOREIGN KEY (id_corso) REFERENCES corsi(id_corso)
);

# on delete cascade permette di cancellare anche le corrispondenti righe delle tabelle figlie
# quando un elemento viene cancellato nella tabella padre