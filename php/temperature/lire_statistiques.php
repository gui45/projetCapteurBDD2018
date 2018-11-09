<?php
	

    include "../connexion.php";
    include "../sql_const.php";
    
    /*if (isset($_POST['over']) && isset($_POST['under'])) {
        $over = $_POST['over'];
        $under = $_POST['under'];

        if (isset($_POST['intakes'])) {
            $entrees = $_POST['intakes'];
            $requete = $basededonnees->prepare(SQL_VALEUR_STATS_INTAKES);
            $requete->bindParam(":limite", $entrees);
        }
        else if (isset($_POST['hours'])) {
            $heures = $_POST['hours'];
            //constSQL avec bons param
            $requete = $basededonnees->prepare(SQL_VALEUR_STATS_HOURS);
            $requete->bindParam(":limite", $heures);
        }
        else {
            die();
        }
    }
    else {
        die();
    }

	$requete->execute();
    $valeur = $requete->fetchAll(PDO::FETCH_OBJ);*/
    header('Content-Type: application/xml');
    echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<temperature>
            <minimum>
                28.4200000762939
            </minimum>
            <maximum>
                28.5
            </maximum>
            <moyenne>
                28.4598425615611
            </moyenne>
            <mode>
                28.5
            </mode>
            <mediane>
                28.4200000762939
            </mediane>
</temperature>"
