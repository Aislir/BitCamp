CREATE DATABASE scuolaApp;

USE scuolaApp;

CREATE TABLE studenti (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
cognome VARCHAR(100)NOT NULL,
matricola VARCHAR(50)UNIQUE NOT NULL);

CREATE TABLE corsi (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
docente VARCHAR(100) NOT NULL);

CREATE TABLE iscrizioni(
id INT AUTO_INCREMENT PRIMARY KEY,
id_studente INT NOT NULL,
id_corso INT NOT NULL,
FOREIGN KEY (id_studente) REFERENCES studenti(id) ON DELETE CASCADE, -- ON DELETE CASCADE ci permette di portarci dietro tutte le relazioni esterne vengono eliminate continuamente. ON UPDATE CASCADE per la modifica di tutte le relazioni con la foreign key
FOREIGN KEY (id_corso) REFERENCES corsi(id) ON DELETE CASCADE
);

INSERT INTO studenti(nome, cognome, matricola)
VALUES
('Mario', 'Rossi','MA123456'),
('Anna', 'Bianchi','AN874564');

INSERT INTO corsi (nome, docente)
VALUES
('Matematica','Prof.Verdi'),
('Fisica','Prof. Neri');

INSERT INTO iscrizioni (id_studente, id_corso)
VALUES
(1,1),
(2,2);

DROP DATABASE scuolaApp;

# on delete cascade permette di cancellare anche le corrispondenti righe delle tabelle figlie
# quando un elemento viene cancellato nella tabella padre