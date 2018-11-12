<?php

include_once "connexion.php"

class ParametreDAO{

    function listerParametres(){
        global $basededonnees;
        $SQL_LISTER_PARAMETRES = "SELECT * FROM public.parametres LIMIT 1;";
        $requeteListeParametres = $basededonnees->prepare($SQL_LISTER_PARAMETRES);
		$requeteListeParametres->execute();
		return $requeteListeParametres->fetchAll(PDO::FETCH_OBJ);

    }

}

?>