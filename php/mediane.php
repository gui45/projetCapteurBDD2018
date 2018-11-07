<?php
	header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "connexion.php";
    include "sql_const.php";

	$requeteValeurMediane = $basededonnees->prepare(SQL_VALEUR_MEDIANE);
	$requeteValeurMediane->execute();
    $valeur = $requeteValeurMediane->fetch(PDO::FETCH_OBJ);
?>

<temperature>
    <mediane>
        <?=$valeur->temp?>
    </mediane>
</temperature>