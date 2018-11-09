<?php
    const SQL_PARAMETRES = "SELECT * FROM public.params LIMIT 1;";

    const SQL_VALEUR_MIN = "SELECT MIN(temp) AS minimum from raw;";
    const SQL_VALEUR_MAX = "SELECT MAX(temp) AS maximum from raw;";
    const SQL_VALEUR_MOYENNE = "SELECT AVG(temp) AS moyenne from raw;";
    const SQL_VALEUR_MODE = "SELECT COUNT(*) as compte, temp FROM raw GROUP BY raw.temp ORDER BY compte DESC LIMIT 1;";
    const SQL_VALEUR_MEDIANE = "SELECT * FROM raw ORDER BY temp OFFSET ((SELECT count(*) FROM raw) / 2) LIMIT 1;";

    const SQL_MODIFIER_PARAMS_HEURE = "UPDATE public.params SET nbHeure = :nbHeure, minParam = :minParam, maxParam = maxParam;";
    const SQL_MODIFIER_PARAMS_ELEMENT = "UPDATE public.params SET nbElement = :nbElement, minParam = :minParam, maxParam = maxParam;";
?>