\echo escript principal per la base de dades sistemasdb
\echo -------------------------------------------

DROP DATABASE sistemasdb;
CREATE DATABASE sistemasdb;
\c sistemasdb
\i 'planeta\\planeta.sql'
\i 'esser\\esser.sql'
\i 'esser\\huma.sql'
\i 'esser\\andoria.sql'
\i 'esser\\ferengi.sql'
\i 'esser\\klingon.sql'
\i 'esser\\nibirian.sql'
\i 'esser\\vulcania.sql'
