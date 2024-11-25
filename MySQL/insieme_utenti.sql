CREATE DATABASE insieme_utenti;

USE insieme_utenti;

CREATE TABLE utenti(
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100),
cognome VARCHAR(100),
eta INT
);

INSERT INTO utenti(nome, cognome, eta)
VALUES
('Bob', 'Bobsom', 32),
('Baba', 'Jaga', 45),
('Sonny', 'Oni', 15);

SELECT * FROM utenti;

SELECT utenti.nome, utenti.cognome, utenti.eta
FROM utenti
WHERE utenti.eta > 25;

SELECT * FROM utenti ORDER BY utenti.cognome ASC;

UPDATE utenti SET eta = 35 WHERE id = 1;

DROP TABLE utenti;