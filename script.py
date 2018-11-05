import serial
import pgdb

adresseServeur = '54.39.144.87'
utilisateur = 'postgres'
motDePasse = '9182'
baseDeDonnees = 'capture'

maConnection = pgdb.connect( host=adresseServeur, user=utilisateur, password=motDePasse, database=baseDeDonnees )
doQuery( maConnection )
maConnection.close()

port_serie = "COM3"
baud_rate = 9600
chemin_fichier = "data.txt"

fichier_sortie = open(chemin_fichier, "w+")
serie = serial.Serial(port_serie, baud_rate)
while True:
    ligne = serie.readline()
    if not (ligne == ""):
        print(ligne.rstrip())
        fichier_sortie.write(ligne.rstrip()+"\n")
