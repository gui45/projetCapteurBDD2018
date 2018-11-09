<?php
    include "../connexion.php";
    include "../sql_const.php";
    
    if (isset($_PATCH['maxParam']) && isset($_PATCH['minParam'])) {
        $minParam = $_PATCH['minParam'];
        $maxParam = $_PATCH['maxParam'];

        if (isset($_PATCH['nbElement'])) {
            $element = $_PATCH['nbElement'];

            $requete = $basededonnees->prepare(SQL_MODIFIER_PARAMS_ELEMENT);
            $requete->bindParam(":nbElement", $element);
            $requete->bindParam(":minParam", $minParam);
            $requete->bindParam(":maxParam", $maxParam);
        }
        else if (isset($_PATCH['nbHeure'])) {
            $nbHeure = $_PATCH['nbHeure'];

            $requete = $basededonnees->prepare(SQL_MODIFIER_PARAMS_HEURE);
            $requete->bindParam(":nbHeure", $nbHeure);
            $requete->bindParam(":minParam", $minParam);
            $requete->bindParam(":maxParam", $maxParam);
        }
        else {
            die();
        }
    }
    else {
        die();
    }

	$requete->execute();
    $valeur = $requete->fetchAll(PDO::FETCH_OBJ);

?>