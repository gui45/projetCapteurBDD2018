package controleur;

import donnees.ParametreDAO;
import donnees.ParametreDAORedis;
import donnees.TemperatureDAO;
import model.Parametre;
import model.Temperature;

public class ControleurPrincipal {

    private static ControleurPrincipal INSTANCE = new ControleurPrincipal();

    /** Point d'accès pour l'instance unique du singleton */
    public static ControleurPrincipal getInstance()
    {   
    	ParametreDAORedis parametreDAORedis = new ParametreDAORedis();
    	return INSTANCE;
    }

    public Parametre rechercherParametre(){
        //ParametreDAO parametreDAO = new ParametreDAO();

        //Parametre parametre = parametreDAO.rechercherParametre();
        ParametreDAORedis parametreDAORedis = new ParametreDAORedis();
        
    	Parametre parametre = parametreDAORedis.rechercherParametre();
        return  parametre;
    }

    public Temperature rechercherTemperature(){
        TemperatureDAO temperatureDAO = new TemperatureDAO();
        Temperature temperature = temperatureDAO.rechercherTemperature();
    	
        return  temperature;
    }

    public void modifierParametre(int heure, int element, double superieur, double inferieur, boolean boolHeure){
        ParametreDAO parametreDAO = new ParametreDAO();

        parametreDAO.modifierParametre(heure, element, superieur, inferieur, boolHeure);
    }
}
