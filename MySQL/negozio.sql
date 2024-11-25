CREATE DATABASE negozio;
USE negozio;

#tabella clienti
CREATE TABLE clienti(
id_cliente INT AUTO_INCREMENT PRIMARY KEY ,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE
);

#tabella prodotti
CREATE TABLE prodotti(
id_prodotto INT AUTO_INCREMENT PRIMARY KEY,
nome_prodotto VARCHAR(100) NOT NULL,
prezzo DECIMAL(10,2) NOT NULL
);

# tabella ordini 
CREATE TABLE ordini(
id_ordine INT AUTO_INCREMENT PRIMARY KEY,
data_ordine DATE NOT NULL,
totale DECIMAL(10,2) NOT NULL, 
id_cliente INT ,
FOREIGN KEY(id_cliente) REFERENCES clienti(id_cliente)
);

#tabella ordine_prodotti
CREATE TABLE  ordine_prodotti(
id_ordine INT,
id_prodotto INT,
PRIMARY KEY(id_ordine,id_prodotto),
quantita INT NOT NULL ,
FOREIGN KEY (id_ordine) REFERENCES ordini(id_ordine),
FOREIGN KEY (id_prodotto) REFERENCES prodotti(id_prodotto)
);

#inserimento clienti
INSERT INTO clienti(nome,email)
VALUES
('Mario Rossi','mario.rossi@mail.com'),#1
('Luigi Bianchi','luigi.bianchi@mail.com');#2

#inserimento prodotti
INSERT INTO prodotti(nome_prodotto,prezzo)
VALUES
('Laptop',1200.50),#1
('Smartphone',800),#2
('Tablet',450.75);#3

#inserimento degli ordini 
INSERT INTO ordini (id_cliente,data_ordine,totale)
VALUES 
(1,'2024-11-20',2000.50),#1
(2,'2024-11-19',1250.75);#2

#inserimento della relazione ordini prodotti
 
 INSERT INTO ordine_prodotti (id_ordine,id_prodotto,quantita)
 VALUES 
 (1,1,1),
 (1,2,1),
 (2,2,1),
 (2,3,1);
 #estrazione (query) degli ordini del cliente Mario Rossi
 SELECT o.id_ordine,p.nome_prodotto,op.quantita,p.prezzo
 FROM ordine_prodotti op #qui viene definito l'alias ordine_prodotti
 JOIN prodotti p #qui viene definito alias prodotti
 ON op.id_prodotto =p.id_prodotto
 JOIN ordini o #qui viene definito alias ordini
 ON op.id_ordine= o.id_ordine
WHERE o.id_ordine =1;

#estrazione della ricevuta dell' ordine di Mario Rossi
SELECT o.id_ordine,c.nome,o.data_ordine,o.totale
FROM ordini o #qui viene definito alias ordini
JOIN clienti c  #qui viene definito alias clienti
ON  o.id_cliente=c.id_cliente
WHERE c.nome='Mario Rossi';

 #stessa query senza alias(verisone estesa)
 SELECT ordini.id_ordine,clienti.nome,ordini.data_ordine,ordini.totale
 FROM ordini
 JOIN clienti
 ON ordini.id_cliente=clienti.id_cliente
 WHERE clienti.nome = 'Mario Rossi';
 
  #stessa query senza alias(verisone mixata)
 SELECT o.id_ordine,clienti.nome,o.data_ordine,o.totale
 FROM ordini o
 JOIN clienti
 ON o.id_cliente=clienti.id_cliente
 WHERE clienti.nome = 'Mario Rossi';