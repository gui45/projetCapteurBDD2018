<?php

include_once "connexion.php"
include "../sql_const.php";


class TemperatureDAO{

    function listerStatistiquesCompletes(){
        global $basededonnees;
        $requeteListeStatistiques = $basededonnees->prepare($SQL_RETOURNER_STATISTIQUES_COMPLETES);
		$requeteListeStatistiques->execute();
		return $requeteListeStatistiques->fetchAll(PDO::FETCH_OBJ);

    }

}

?>