const temperatureDAO = require('./temperatureDAO');
const http = require('http');
const url = require('url');

var serveur = http.createServer(

    async function(requete, reponse) {

        if(requete.method === 'GET') {
            if(requete.url === '/temperature/moyenne' || requete.url === '/temperature/moyenne/') {
                const moyenne = await temperatureDAO.listerTemperatures();
                reponse.end(JSON.stringify(moyenne));
            }
        }
    }
);
serveur.listen(8080);