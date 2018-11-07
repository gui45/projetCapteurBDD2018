<?php
	header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "connexion.php";
    include "sql_const.php";

	$requeteValeurMode = $basededonnees->prepare(SQL_VALEUR_MODE);
	$requeteValeurMode->execute();
    $valeur = $requeteValeurMode->fetch(PDO::FETCH_OBJ);
?>

<temperature>
    <mode>
        <?=$valeur->temp?>
    </mode>
</temperature>