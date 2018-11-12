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
            <?=$parametre->nbHeure?>
        </nbHeure>
        <nbElement>
            <?=$parametre->nbElement?>
        </nbElement>
        <minParam>
            <?=$parametre->minParam?>
        </minParam>
        <maxParam>
            <?=$parametre->maxParam?>
        </maxParam> 
    </parametre>
    <?php
    }
    ?>
</parametres>
