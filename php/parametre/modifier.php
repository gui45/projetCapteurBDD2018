<?php
    include "../accesseur/ParametreDAO.php";


    if (isset($_POST['superieur_a']) && isset($_POST['inferieur_a'])) {

        $parametreDAO = new ParametreDAO();
        //$parametres = new stdClass(); pourquoi ?
        //$parametres->superieurA = $_POST['superieur_a'];
        //$parametres->inferieurA = $_POST['inferieur_a'];

        $filtreValeurs = array();
        $filtreValeurs['superieur_a'] = FILTER_SANITIZE_ENCODED;
        $filtreValeurs['inferieurA'] = FILTER_SANITIZE_ENCODED;

        if (isset($_POST['quantite_entree'])) {
            //$parametres->quantiteEntree = $_POST['quantite_entree'];
            $parametres->heures = 0;
            $filtreValeurs['quantite_entree'] = FILTER_SANITIZE_ENCODED;

        }
        else if (isset($_POST['heures'])) {
            //$parametres->heures = $_POST['heures'];
            $parametres->quantiteEntree = 0;
            $filtreValeurs['heures'] = FILTER_SANITIZE_ENCODED;

        }
        else {
            die();
        }

    }
    else {
        echo "CONNEXION FERMEE";
        die();
    }
    $parametreDAO = filter_var_array($_POST, $filtreValeurs);
    $parametreDAO->modifierParametres($parametres);
    echo "SUCCES";

?>
