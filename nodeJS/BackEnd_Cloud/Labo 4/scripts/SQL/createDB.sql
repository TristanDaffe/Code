DROP TABLE IF EXISTS produit CASCADE;

CREATE TABLE produit (
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom varchar,
    prix float
);
INSERT INTO produit (nom, prix) VALUES
('Playstation 4', 400),
('Xbox One', 399.99),
('Nintendo Switch', 349.99);

DROP TABLE IF EXISTS client CASCADE;
CREATE TABLE client(
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom varchar,
    prenom varchar,
    adresse varchar,
    password varchar
);
INSERT INTO client (nom, prenom, adresse, password) VALUES 
('Poirier', 'Tevin', '11, rue du Faubourg National 95150 TAVERNY', 'motdepasse');

DROP TABLE IF EXISTS manager CASCADE;
CREATE TABLE manager(
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom varchar,
    password varchar
);
INSERT INTO manager (nom, password) VALUES 
('John', 'password');

DROP TABLE IF EXISTS achat CASCADE;
CREATE TABLE achat (
    id_produit integer REFERENCES produit(id) DEFERRABLE INITIALLY IMMEDIATE,
    id_client integer REFERENCES client(id) DEFERRABLE INITIALLY IMMEDIATE,
    quantite integer,
    "date" date,
    PRIMARY KEY(id_client, id_produit, "date")
);
