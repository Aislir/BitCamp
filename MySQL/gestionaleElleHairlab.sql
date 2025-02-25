CREATE DATABASE IF NOT EXISTS gestionaleElleHairlab;
USE gestionaleElleHairlab;

CREATE TABLE IF NOT EXISTS storicoMagazzino(
id INT PRIMARY KEY AUTO_INCREMENT,
tipo ENUM('entrata', 'uscita'),
data DATETIME,
quantita INT,
prodotto_id INT,
ddt_id INT,
FOREIGN KEY (prodotto_id) REFERENCES prodotto(id),
FOREIGN KEY (ddt_id) REFERENCES ddt(id)
);

CREATE TABLE IF NOT EXISTS prodotto(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100),
tipo ENUM('shampoo', 'olio', 'crema', 'schiuma'),
codice VARCHAR(100),
contenuto DECIMAL(6,2),
marca ENUM('loreal', 'alterego', 'gdh', 'davines', 'matrix'),
quantita INT,
fornitore_id INT, 
FOREIGN KEY(fornitore_id) REFERENCES fornitore(id)
);

CREATE TABLE IF NOT EXISTS ddt(
id INT PRIMARY KEY AUTO_INCREMENT,
dataDDT DATE,
dataReg DATE,
numero INT,
fornitore_id INT, 
FOREIGN KEY(fornitore_id) REFERENCES fornitore(id)
);

CREATE TABLE IF NOT EXISTS fornitore(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
rappresentante VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS contatti_fornitore(
id INT PRIMARY KEY AUTO_INCREMENT,
contatti VARCHAR(100),
email VARCHAR(100),
fornitore_id INT,
FOREIGN KEY (fornitore_id) REFERENCES fornitore(id)
);

SELECT * FROM contatti_fornitore;
SELECT * FROM fornitore;
SELECT * FROM ddt;
SELECT * FROM prodotto;
SELECT * FROM storicoMagazzino;

DROP DATABASE gestionaleElleHairlab;
DROP TABLE fornitore;
DROP TABLE contatti_fornitore;