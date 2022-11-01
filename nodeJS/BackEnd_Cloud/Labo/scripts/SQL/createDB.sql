DROP TABLE IF EXISTS produit CASCADE;

CREATE TABLE produit (
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom varchar,
    prix float
);
INSERT INTO produit (nom, prix) VALUES
<<<<<<< HEAD
    ('Playstation 4', 400),
    ('Xbox One', 399.99),
    ('Nintendo Switch', 349.99);
    DROP TABLE IF EXISTS client CASCADE;
    CREATE TABLE client(
=======
('Playstation 4', 400),
('Xbox One', 399.99),
('Nintendo Switch', 349.99);

DROP TABLE IF EXISTS client CASCADE;
CREATE TABLE client(
>>>>>>> 7e58a8d848b1bf28cb4b4c537980293368f92ec3
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom varchar,
    prenom varchar,
    adresse varchar,
<<<<<<< HEAD
    email varchar UNIQUE,
=======
>>>>>>> 7e58a8d848b1bf28cb4b4c537980293368f92ec3
    password varchar
);
INSERT INTO client (nom, prenom, adresse, password) VALUES 
('Poirier', 'Tevin', '11, rue du Faubourg National 95150 TAVERNY', 'motdepasse');

<<<<<<< HEAD
INSERT INTO client (nom, prenom, adresse, email, password) VALUES 
('Poirier', 'Tevin', '11, rue du Faubourg National 95150 TAVERNY', 'poirier@mail.com', '$2a$10$vQ1rrXjoPNYhualYPfWlFec41p3JpSQH33B4VwXEyeaUTKmoF4VSy'); --motdepasse
=======
>>>>>>> 7e58a8d848b1bf28cb4b4c537980293368f92ec3
DROP TABLE IF EXISTS manager CASCADE;
CREATE TABLE manager(
    id integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom varchar,
<<<<<<< HEAD
    email varchar UNIQUE,
    password varchar
);
=======
    password varchar
);
INSERT INTO manager (nom, password) VALUES 
('John', 'password');
>>>>>>> 7e58a8d848b1bf28cb4b4c537980293368f92ec3

INSERT INTO manager (nom, email, password) VALUES 
('John', 'john@mail.com', '$2a$10$fiKILzSQn2YvA.mbmxhqa.7f8pErrnl4qofZY7nE/a5Vq8KakfPKG'); --password
DROP TABLE IF EXISTS achat CASCADE;
CREATE TABLE achat (
    id_produit integer REFERENCES produit(id) DEFERRABLE INITIALLY IMMEDIATE,
    id_client integer REFERENCES client(id) DEFERRABLE INITIALLY IMMEDIATE,
    quantite integer,
    "date" date,
    PRIMARY KEY(id_client, id_produit, "date")
<<<<<<< HEAD
);
=======
);
>>>>>>> 7e58a8d848b1bf28cb4b4c537980293368f92ec3
