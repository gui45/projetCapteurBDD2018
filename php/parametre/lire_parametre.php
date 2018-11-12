<?php

    include "../accesseur/ParametreDAO.php";

    $parametreDAO = new ParametreDAO();

    $listeParametres = $parametreDAO.listerParametres();

    header('Content-Type: application/xml');
	echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<parametres>
<?php
    foreach($listeParametres as $parametre)
    {
?>
    <parametre>
        <nbHeure>
            <?=$parametre->heures?>
        </nbHeure>
        <nbElement>
            <?=$parametre->quantite_entree?>
        </nbElement>
        <minParam>
            <?=$parametre->superieur_a?>
        </minParam>
        <maxParam>
            <?=$parametre->inferieur_a?>
        </maxParam> 
    </parametre>
    <?php
    }
    ?>
</parametres>
