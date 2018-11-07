<?php
	header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "connexion.php";
    include "sql_const.php";

	$requeteValeurMoyenne = $basededonnees->prepare(SQL_VALEUR_MOYENNE);
	$requeteValeurMoyenne->execute();
    $valeur = $requeteValeurMoyenne->fetch(PDO::FETCH_OBJ);
?>

<temperature>
    <moyenne>
        <?=$valeur->moyenne?>
    </moyenne>
</temperature>