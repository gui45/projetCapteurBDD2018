<?php

    include "../accesseur/ParametreDAO.php";

    $parametreDAO = new ParametreDAO();

    $listeParametres = $parametreDAO->listerParametres();

    header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<parametres>
<?php
    foreach($listeParametres as $parametre)
    {
?>
    <parametre>
        <heures><?=$parametre->heures?></heures>
        <quantite_entree><?=$parametre->quantite_entree?></quantite_entree>
        <superieur_a><?=$parametre->superieur_a?></superieur_a>
        <inferieur_a><?=$parametre->inferieur_a?></inferieur_a> 
    </parametre>
<?php
    }
?>
</parametres>
