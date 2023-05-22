CREATE TABLE nibirian (
    nom TEXT REFERENCES esser,
    vegano TEXT NOT NULL,
    pescado TEXT NOT NULL
);