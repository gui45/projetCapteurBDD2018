function BruteDAOMongo() {
    const mongo = require('mongodb');
    const MongoClient = mongo.MongoClient;
    const { urlBaseDeDonnees, NOM_BASE_DE_DONNEES, NOM_COLLECTION } = require('./InformationsMongoDB');

    function initialiser() {
        console.log("initialiserBruteDAOMongo");
    }

    this.listerTemperature = async function () {
        MongoClient.connect(urlBaseDeDonnees, { useNewUrlParser: true }, function (erreur, connexionBaseDeDonnees) {
            if (erreur)
                throw erreur;

            var baseDeDonnees = connexionBaseDeDonnees.db(NOM_BASE_DE_DONNEES);
            baseDeDonnees.collection(NOM_COLLECTION).find({}).toArray(function (erreur, resultat) {
                if (erreur)
                    throw erreur;

                connexionBaseDeDonnees.close();
                return resultat;

            });
        });
    }
}

initialiser();

module.exports = BruteDAOMongo;
