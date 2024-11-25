CREATE DATABASE galleria;

USE galleria;

CREATE TABLE artisti(
	id_artista INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    nazionalita VARCHAR(50) NOT NULL,
    anno_di_nascita INT NOT NULL
    );
    
CREATE TABLE opere(
	id_opera INT PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(100) NOT NULL, 
    anno_creazione INT NOT NULL,
    tipo VARCHAR(50), 
	FOREIGN KEY(id_artista) REFERENCES artisti(id_artista)
    );
    
INSERT INTO artisti(nome, cognome, nazionalita, anno_di_nascita)
VALUES
('Mario', 'Rossi', 'Italiana', 1751),
('Luigi', 'Bianchi', 'Italiana', 1892),
('Bob', 'Bobs', 'Inglese', 1640);

INSERT INTO opere(titolo, anno_creazione, tipo, id_artista)
VALUES
('La morte', 1787, 1),
('La vita', 1801, 1),
('Primavera', 1929, 2),
('Trincea', 1920, 2),
('Her Majesty', 1674, 3);