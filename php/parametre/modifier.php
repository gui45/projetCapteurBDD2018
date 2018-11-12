<?php
    include "../accesseur/ParametreDAO.php";

    
    if (isset($_POST['superieur_a']) && isset($_POST['inferieur_a'])) {

        $parametreDAO = new ParametreDAO();
        $temperatures = new stdClass();
        $temperatures->superieurA = $_POST['superieur_a'];
        $temperatures->inferieurA = $_POST['inferieur_a'];

        if (isset($_POST['quantite_entree'])) {
            $temperatures->quantiteEntree = $_POST['quantite_entree'];
            $temperatures->heures = 0;

        }
        else if (isset($_POST['heures'])) {
            $heures = $_POST['heures'];
            $temperatures->inferieurA = $_POST['inferieur_a'];
            $temperatures->quantiteEntree = 0;

        }
        else {
            die();
        }

    }
    else {
        echo "CONNEXION FERMEE";
        die();
    }
    $parametreDAO->modifierParametres($temperatures);

?>