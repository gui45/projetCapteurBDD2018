<?php
    // changer le * pour une valeur prise en BDD (param_temp)
    const SQL_VALEUR_MIN = "SELECT MIN(temp) AS minimum from raw;";
    const SQL_VALEUR_MAX = "SELECT MAX(temp) AS maximum from raw;";
    const SQL_VALEUR_MOYENNE = "SELECT AVG(temp) AS moyenne from raw;";
    const SQL_VALEUR_MODE = "SELECT COUNT(*) as compte, temp FROM raw GROUP BY raw.temp ORDER BY compte DESC LIMIT 1;";
    const SQL_VALEUR_MEDIANE = "SELECT * FROM raw ORDER BY temp OFFSET ((SELECT count(*) FROM raw) / 2) LIMIT 1;";
?>