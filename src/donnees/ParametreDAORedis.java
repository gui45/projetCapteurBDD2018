package donnees;
import java.util.List;

import model.Parametre;
import redis.clients.jedis.Jedis;

public class ParametreDAORedis {
	Jedis jedis;

	public ParametreDAORedis() {
		jedis = new Jedis("localhost"); 
	
	}
	
	public Parametre rechercherParametre() {
		
		Parametre parametre = new Parametre();
	    List<String> nbHeure = jedis.hmget("parametre", "heures");
	    parametre.setNbHeure(Integer.parseInt(nbHeure.get(0)));
	    List<String> nbElement = jedis.hmget("parametre", "quantite_entree");
	    parametre.setNbElement(Integer.parseInt(nbElement.get(0)));
	    List<String> superieurA = jedis.hmget("parametre", "superieur_a");
	    parametre.setSuperieurA(Integer.parseInt(superieurA.get(0)));
	    List<String> inferieurA = jedis.hmget("parametre", "inferieur_a");
	    parametre.setInferieurA(Integer.parseInt(inferieurA.get(0)));

	    return parametre;
	    
	}
}
