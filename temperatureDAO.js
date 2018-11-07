var postgresql = require('pg');
var chaineDeConnexion = 'postgres://postgres:9182@54.39.144.87:5432/capture';

const SQL_LISTE_TEMPERATURE = 'SELECT * FROM raw;';
const SQL_MOYENNE_TEMPERATURE = 'SELECT * FROM view ORDER BY ID DESC LIMIT 1;';
const SQL_MEDIANE_TEMPERATURE = 'SELECT * FROM raw OFFSET ((SELECT count(*) FROM raw) / 2) LIMIT 1;';
const SQL_MINIMUM_TEMPERATURE = 'SELECT * FROM raw WHERE temp = (SELECT MIN(temp) FROM raw);';
const SQL_MAXIMUM_TEMPERATURE = 'SELECT * FROM raw WHERE temp = (SELECT MAX(temp) FROM raw);';
/*const SQL_DONNER_ETUDIANT = 'SELECT * FROM etudiant WHERE id=$1;';
const SQL_AJOUTER_ETUDIANT = 'INSERT INTO etudiant VALUES(DEFAULT, $1, $2, $3, $4, $5);';
const SQL_SUPPRIMER_ETUDIANT = 'DELETE FROM etudiant WHERE id=$1;'
const SQL_MODIFIER_ETUDIANT = 'UPDATE etudiant SET nom = $1 , prenom = $2, age = $3, id_nationalite = $4, id_universite = $5 WHERE id = $6;';*/



exports.listerTemperatures = async function listerTemperatures() {
    const basededonnees = new postgresql.Client(chaineDeConnexion);

    await basededonnees.connect();
    var listeTemperature = await basededonnees.query(SQL_LISTE_TEMPERATURE);
    await basededonnees.end();

    return listeTemperature.rows;
};

exports.moyenneTemperature = async function moyenneTemperature(){
    const basededonnees = new postgresql.Client(chaineDeConnexion);

    await basededonnees.connect();
    var moyTemp = await basededonnees.query(SQL_MOYENNE_TEMPERATURE);
    await basededonnees.end();

    return moyTemp.rows;
};

exports.medianeTemperature = async function medianeTemperature(){
    const basededonnees = new postgresql.Client(chaineDeConnexion);

    await basededonnees.connect();
    var medTemp = await basededonnees.query(SQL_MEDIANE_TEMPERATURE);
    await basededonnees.end();

    return medTemp.rows;
};

exports.minimumTemperature = async function minimumTemperature(){
    const basededonnees = new postgresql.Client(chaineDeConnexion);

    await basededonnees.connect();
    var minTemp = await basededonnees.query(SQL_MINIMUM_TEMPERATURE);
    await basededonnees.end();

    return minTemp.rows;
};

exports.maximumTemperature = async function maximumTemperature(){
    const basededonnees = new postgresql.Client(chaineDeConnexion);

    await basededonnees.connect();
    var maxTemp = await basededonnees.query(SQL_MAXIMUM_TEMPERATURE);
    await basededonnees.end();

    return maxTemp.rows;
};


