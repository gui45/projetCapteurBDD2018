<?php
    include "../connexion.php";
    include "../sql_const.php";
    
    if (isset($_POST['maxParam']) && isset($_POST['minParam'])) {
        $minParam = $_POST['minParam'];
        $maxParam = $_POST['maxParam'];

        if (isset($_POST['nbElement'])) {
            $element = $_POST['nbElement'];

            $requete = $basededonnees->prepare(SQL_MODIFIER_PARAMS_ELEMENT);
            $requete->bindParam(":nbElement", $element);
            $requete->bindParam(":minParam", $minParam);
            $requete->bindParam(":maxParam", $maxParam);
        }
        else if (isset($_POST['nbHeure'])) {
            $nbHeure = $_POST['nbHeure'];

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