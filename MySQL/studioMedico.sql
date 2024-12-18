CREATE DATABASE IF NOT EXISTS studioMedico;
USE studioMedico;

CREATE TABLE IF NOT EXISTS appuntamenti(
id INT AUTO_INCREMENT PRIMARY KEY,
data DATE,
ora TIME,
dottore VARCHAR(100),
cliente VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS dottori(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100), 
specializzazione VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS clienti(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100), 
cognome VARCHAR(100)
);

SELECT * FROM dottori;