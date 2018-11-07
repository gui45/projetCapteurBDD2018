const temperatureDAO = require('./temperatureDAO');
const http = require('http');
const url = require('url');

var serveur = http.createServer(

    async function(requete, reponse) {

        if(requete.method === 'GET') {
            if(requete.url === '/temperature/liste-temperature' || requete.url === '/temperature/liste-temperature/') {
                const temperature = await temperatureDAO.listerTemperatures();
                reponse.end(JSON.stringify(temperature));
            }
        }

        if(requete.method === 'GET') {
            if(requete.url === '/temperature/moyenne' || requete.url === '/temperature/moyenne/') {
                const moyenne = await temperatureDAO.moyenneTemperature();
                reponse.end(JSON.stringify(moyenne));
            }
        }

        if(requete.method === 'GET') {
            if(requete.url === '/temperature/mediane' || requete.url === '/temperature/mediane/') {
                const mediane = await temperatureDAO.medianeTemperature();
                reponse.end(JSON.stringify(mediane));
            }
        }
    }
    
);
serveur.listen(8080);