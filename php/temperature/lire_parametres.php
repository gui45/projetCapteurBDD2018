<?php
	header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';

    include "../connexion.php";
    include "../sql_const.php";

	$requeteValeurMaximum = $basededonnees->prepare(SQL_PARAMETRES);
	$requeteValeurMaximum->execute();
    $valeur = $requeteValeurMaximum->fetch(PDO::FETCH_OBJ);
?>

<parametres>
    <hours>
        <?=$valeur->hours?>
    </hours>
    <intakes>
        <?=$valeur->intakes?>
    </intakes>
    <over>
        <?=$valeur->over?>
    </over>
    <under>
        <?=$valeur->under?>
    </under> 
</parametres>