<?php

include_once "connexion.php";

class StatistiqueDAO
{

    function listerStatistiquesCompletes()
    {
        global $basededonnees;
        $requeteListeStatistiques = $basededonnees->prepare("SELECT * FROM public.statistiques ORDER BY id DESC LIMIT 1");
		$requeteListeStatistiques->execute();
		return $requeteListeStatistiques->fetchAll(PDO::FETCH_OBJ);

    }

}

?>