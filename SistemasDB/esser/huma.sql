CREATE TABLE huma (
    nom TEXT REFERENCES esser,
    edad INTEGER NOT NULL,
    genero TEXT NOT NULL
);