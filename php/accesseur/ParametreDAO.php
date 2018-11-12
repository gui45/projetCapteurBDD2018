<?php

include_once "connexion.php"
include "../sql_const.php";


class ParametreDAO{

    function listerParametres(){
        global $basededonnees;
        $requeteListeParametres = $basededonnees->prepare($SQL_PARAMETRES);
		$requeteListeParametres->execute();
		return $requeteListeParametres->fetchAll(PDO::FETCH_OBJ);

    }

}

?>