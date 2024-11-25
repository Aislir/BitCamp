CREATE DATABASE rubrica;

USE rubrica;

CREATE TABLE contatti(
	id_contatto INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    numero_contatto VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO contatti(nome, cognome, numero_contatto)
VALUES
('Mario', 'Rossi', '334579459547'),
('Luigi', 'Bianchi', '2347395630'),
('Marco', 'Verdi', '93569356703');

SELECT * FROM contatti;



    