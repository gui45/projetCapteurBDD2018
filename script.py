import serial
import psycopg2
import datetime
import asyncio

adresseServeur = "54.39.144.87"
utilisateur = "postgres"
motDePasse = "9182"
baseDeDonnees = "capture"

port_serie = "COM3"
baud_rate = 9600
chemin_fichier = "data.txt"

maConnection = psycopg2.connect(
    host=adresseServeur, user=utilisateur, password=motDePasse, dbname=baseDeDonnees)
curseur = maConnection.cursor()

async def envoyerDonnesEnBDD(valeur):
    curseur.execute(
        "INSERT INTO raw(temp, timestamp) VALUES(%s, %s);", (valeur, datetime.datetime.utcnow()))

fichier_sortie = open(chemin_fichier, "w+")
serie = serial.Serial(port_serie, baud_rate)

loop = asyncio.get_event_loop()
loop.run_until_complete(envoyerDonnesEnBDD(25))

maConnection.commit()
curseur.close()
maConnection.close()

# while True:
#     ligne = serie.readline().decode("utf-8")
#     if not (ligne == ""):
#         print(ligne.rstrip() + "\n")
#         fichier_sortie.write(ligne.rstrip() + "\n")
