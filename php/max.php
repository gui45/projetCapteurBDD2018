<?php
	header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "connexion.php";
    include "sql_const.php";

	$requeteValeurMaximum = $basededonnees->prepare(SQL_VALEUR_MAX);
	$requeteValeurMaximum->execute();
    $valeur = $requeteValeurMaximum->fetch(PDO::FETCH_OBJ);
?>

<temperature>
    <maximum>
        <?=$valeur->maximum?>
    </maximum>
</temperature>