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

        if(requete.method === 'GET') {
            if(requete.url === '/temperature/minimum' || requete.url === '/temperature/minimum/') {
                const minimum = await temperatureDAO.minimumTemperature();
                reponse.end(JSON.stringify(minimum));
            }
        }

        if(requete.method === 'GET') {
            if(requete.url === '/temperature/maximum' || requete.url === '/temperature/maximum/') {
                const maximum = await temperatureDAO.maximumTemperature();
                reponse.end(JSON.stringify(maximum));
            }
        }

        if(requete.method === 'GET') {
            if(requete.url === '/temperature/mode' || requete.url === '/temperature/mode/') {
                const mode = await temperatureDAO.modeTemperature();
                reponse.end(JSON.stringify(mode));
            }
        }
    }
    
);
serveur.listen(8080);