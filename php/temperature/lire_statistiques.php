<?php

    include "../accesseur/TemperatureDAO.php";

    $temperatureDAO = new TemperatureDAO();

    $listeStats = temperatureDAO.listerStatistiquesCompletes();

    header('Content-Type: application/xml');
    echo '<?xml version="1.0" encoding="UTF-8"?>';
?>

<?php
    foreach($listeStats as $stats)
    {
?>
        <temperature>
            <minimum><?=$stats->minimum?></minimum>
            <maximum><?=$stats->maximum?></maximum>
            <moyenne><?=$stats->moyenne?></moyenne>
            <mode><?=$stats->mode?></mode>
            <mediane><?=$stats->mediane?></mediane>
        </temperature>

<?php
    }
?>