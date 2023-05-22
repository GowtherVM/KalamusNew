CREATE TABLE klingon (
    nom TEXT REFERENCES esser,
    fuerza INTEGER NOT NULL
);