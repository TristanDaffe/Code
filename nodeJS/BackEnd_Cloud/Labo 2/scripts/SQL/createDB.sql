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