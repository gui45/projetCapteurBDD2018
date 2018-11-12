package donnees;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Parametre;

public class ParametreDAO {

	String xml = null;
	
	public ParametreDAO() {
		
	}
	
	public Parametre rechercherParametre(){
		try
		{

			// TODO : URL

			URL urlListeParam = new URL("URL A METTRE");
			String derniereBalise = "</parametres>";
			InputStream flux = urlListeParam.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise);
			xml = lecteur.next() + derniereBalise;
			
		} catch(IOException e) {
			e.printStackTrace();

		}
		try
		{
			DocumentBuilder parseur =  DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(xml));
			String racine = document.getDocumentElement().getNodeName();
			System.out.println(racine);
			
			NodeList listeNoeudsParametre = document.getElementsByTagName("parametres");
			for(int position = 0; position < listeNoeudsParametre.getLength(); position++)
			{
				Parametre parametre = new Parametre();
				Element noeudParametres = (Element)listeNoeudsParametre.item(position);
				String nbHeure = noeudParametres.getElementsByTagName("nbHeure").item(0).getTextContent();
				parametre.setNbHeure(Float.valueOf(nbHeure));
				String nbElement = noeudParametres.getElementsByTagName("nbElement").item(0).getTextContent();
				parametre.setNbElement(Float.valueOf(nbElement));
				String minParam = noeudParametres.getElementsByTagName("minParam").item(0).getTextContent();
				parametre.setMinParam(Float.valueOf(minParam));
				String maxParam = noeudParametres.getElementsByTagName("maxParam").item(0).getTextContent();
				parametre.setMaxParam(Float.valueOf(maxParam));


				return parametre;
			}

	}catch (ParserConfigurationException e) 
		{	
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return null;
}
}