CREATE DATABASE IF NOT EXISTS stazione;
USE stazione;

CREATE TABLE IF NOT EXISTS biglietto(
id INT PRIMARY KEY AUTO_INCREMENT,
codice VARCHAR(50),
data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
tipo ENUM('partenza', 'arrivo') NOT NULL,
FOREIGN KEY (id) REFERENCES fermata(id)
);

CREATE TABLE IF NOT EXISTS fermata(
id INT PRIMARY KEY AUTO_INCREMENT,
luogo VARCHAR(50)
);

INSERT INTO biglietto (tipo)
VALUES
('arrivo'),
('partenza');

SELECT * FROM fermata;
SELECT * FROM biglietto;

DROP TABLE biglietto;
DROP DATABASE stazione;