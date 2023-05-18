\echo escript principal per la base de dades kalamus
\echo -------------------------------------------

\c postgres
DROP DATABASE sistemas;
CREATE DATABASE sistemas;
\c kalamus
\i 'planeta\planeta.sql'
\i 'esser\esser.sql'