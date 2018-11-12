<?php
	header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "../connexion.php";
    include "../sql_const.php";

	$requeteValeurMinimum = $basededonnees->prepare(SQL_VALEUR_MIN);
	$requeteValeurMinimum->execute();
    $valeur = $requeteValeurMinimum->fetch(PDO::FETCH_OBJ);
?>

<temperature>
    <minimum>
        <?=$valeur->minimum?>
    </minimum>
</temperature>