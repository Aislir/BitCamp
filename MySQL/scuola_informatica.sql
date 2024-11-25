CREATE DATABASE scuola_informatica;

USE scuola_informatica;

CREATE table studenti(
	id_studente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    cognome VARCHAR(50)
);    

-- tabella per i corsi
CREATE TABLE corsi(
	id_corso INT AUTO_INCREMENT PRIMARY KEY,
    nome_corso VARCHAR(100),
    id_studente INT,
    FOREIGN KEY(id_studente) REFERENCES studenti(id_studente)
);

-- tabella per i professori dei corsi
CREATE TABLE professori(
	id_professore INT AUTO_INCREMENT PRIMARY KEY,
    nome_professore VARCHAR(50),
    cognome VARCHAR(50),
    id_corso INT,
    FOREIGN KEY (id_corso) REFERENCES corsi(id_corso)
);


INSERT INTO studenti (nome, cognome)
VALUES
('Mario', 'Rossi'), #1
('Luigi', 'Verdi'), #2
('Anna', 'Bianchi'), #3
('Giovanni', 'Barbagianni'); #4

INSERT INTO corsi (nome_corso, id_studente)
VALUES 
('Matematica', 2), #1
('Fisica', 1),
('Chimica', 3),
('Matematica', 4); #4

INSERT INTO professori (nome_professore, id_corso)
VALUES
('Prof. Verdi', 1),
('Prof. Neri', 4),
('Prof. Gialli', 2);

SELECT * FROM studenti;
SELECT * FROM corsi;
SELECT * FROM professori;

#Creazione query di estrazione per visualizzare gli studenti e i loro corsi
SELECT studenti.nome, studenti.cognome, corsi.nome_corso
FROM studenti
INNER JOIN corsi
ON studenti.id_studenti = corsi.id_studente;

#Creazione query per mostrare tutti gli studenti e solo i corsi relazionati agli studenti
SELECT studenti.nome, studenti.cognome, corsi.nome_corso
FROM studenti
LEFT JOIN corsi
ON studenti.id_studente = corsi.id_studente;

#Creazione di una query per estrarre tutti i corsi e solo gli studenti che frequentano un corso
SELECT studenti.nome, studenti.cognome, corsi.nome_corso
FROM studenti
RIGHT JOIN corsi
ON studenti.id_studente = corsi.id_studente;

#Creazione di una query per simulare FULL JOIN (non presente in mySQL)
SELECT studenti.nome, studenti.cognome, corsi.nome_corso
FROM studenti
LEFT JOIN corsi
ON studenti.id_studente = corsi.id_studente

UNION #Unisce le query sopra e sotto

SELECT studenti.nome, studenti.cognome, corsi.nome_corso
FROM studenti
RIGHT JOIN corsi
ON studenti.id_studente = corsi.id_studente;


#Creazione query per prodotto cartesiano
SELECT studenti.nome, corsi.nome_corso
FROM studenti
CROSS JOIN corsi;

# Creazione di una inner join con filtro
SELECT studenti.nome, studenti.cognome, corsi.nome_corso
FROM studenti
INNER JOIN corsi
ON studenti.id_studente = corsi.id_studente
AND corsi.nome_corso = 'Matematica';

# Creazione di una query di inner join tra 3 tabelle
SELECT studenti.nome, studenti.cognome, corsi.nome_corso, professori.nome_professore
FROM studenti
INNER JOIN corsi
ON studenti.id_studente = corsi.id_studente
INNER JOIN professori
ON corsi.id_corso = professori.id_corso;
