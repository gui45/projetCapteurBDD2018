<?php

include_once "connexion.php";

class StatistiqueDAO
{

    function listerStatistiquesCompletes()
    {
        global $basededonnees;
        $SQL_LISTER_STATISTIQUES = "SELECT * FROM public.statistiques ORDER BY id DESC LIMIT 1";
        $requeteListeStatistiques = $basededonnees->prepare($SQL_LISTER_STATISTIQUES);
		$requeteListeStatistiques->execute();
		return $requeteListeStatistiques->fetchAll(PDO::FETCH_OBJ);

    }

}

?>