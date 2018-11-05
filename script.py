import serial
import psycopg2

adresseServeur = '54.39.144.87'
utilisateur = 'postgres'
motDePasse = '9182'
baseDeDonnees = 'capture'

maConnection = psycopg2.connect(host=adresseServeur, user=utilisateur, password=motDePasse, dbname=baseDeDonnees)
curseur = maConnection.cursor()
curseur.execute("INSERT INTO raw (temp) VALUES (54)")
maConnection.commit()

#doQuery( myConnection )

maConnection.close()

""" port_serie = "COM4"
baud_rate = 9600
chemin_fichier = "data.txt"

fichier_sortie = open(chemin_fichier, "w+")
serie = serial.Serial(port_serie, baud_rate)
while True:
    ligne = serie.readline()
    if not (ligne == ""):
        print(ligne.rstrip())
        fichier_sortie.write(ligne.rstrip()+"\n")
 """

#doQuery( maConnection )

