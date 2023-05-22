CREATE TABLE ferengi (
    nom TEXT REFERENCES esser,
    latinum INTEGER NOT NULL
);