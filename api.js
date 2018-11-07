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
    }
);
serveur.listen(8080);