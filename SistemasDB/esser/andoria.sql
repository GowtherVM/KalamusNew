\echo ---------- taula andoria

CREATE TABLE andoria (
    nom TEXT REFERENCES esser,
    rango TEXT NOT NULL
);