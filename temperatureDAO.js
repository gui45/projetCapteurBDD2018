var postgresql = require('pg');
var chaineDeConnection = 'postgres://postgres:9182@54.39.144.87:5432/Capture';

const SQL_LISTE_ETUDIANT = 'SELECT * FROM etudiant;';
/*const SQL_DONNER_ETUDIANT = 'SELECT * FROM etudiant WHERE id=$1;';
const SQL_AJOUTER_ETUDIANT = 'INSERT INTO etudiant VALUES(DEFAULT, $1, $2, $3, $4, $5);';
const SQL_SUPPRIMER_ETUDIANT = 'DELETE FROM etudiant WHERE id=$1;'
const SQL_MODIFIER_ETUDIANT = 'UPDATE etudiant SET nom = $1 , prenom = $2, age = $3, id_nationalite = $4, id_universite = $5 WHERE id = $6;';*/



exports.listerEtudiants = async function listerEtudiants() {
    const basededonnees = new postgresql.Client(chaineDeConnection);

    await basededonnees.connect();
    var listeEtudiant = await basededonnees.query(SQL_LISTE_ETUDIANT);
    await basededonnees.end();

    return listeEtudiant.rows;
};



