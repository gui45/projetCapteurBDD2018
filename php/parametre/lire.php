<?php
	header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "../connexion.php";
    include "../sql_const.php";

	$requete = $basededonnees->prepare(SQL_PARAMETRES);
	$requete->execute();
    $valeur = $requete->fetch(PDO::FETCH_OBJ);
?>

<parametres>
    <nbHeure>
        <?=$valeur->nbHeure?>
    </nbHeure>
    <nbElement>
        <?=$valeur->nbElement?>
    </nbElement>
    <minParam>
        <?=$valeur->minParam?>
    </minParam>
    <maxParam>
        <?=$valeur->maxParam?>
    </maxParam> 
</parametres>