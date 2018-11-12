<?php

    include "../connexion.php";
    include "../sql_const.php";

    $requete = $basededonnees->prepare(SQL_RETOURNER_STATISTIQUES_COMPLETES);
	$requete->execute();
    $valeur = $requete->fetch(PDO::FETCH_OBJ);

    header('Content-Type: application/xml');
    echo '<?xml version="1.0" encoding="UTF-8"?>';
?>

<temperature>
    <minimum><?=$valeur->min?></minimum>
    <maximum><?=$valeur->max?></maximum>
    <moyenne><?=$valeur->moyenne?></moyenne>
    <mode><?=$valeur->mod?></mode>
    <mediane><?=$valeur->med?></mediane>
</temperature>