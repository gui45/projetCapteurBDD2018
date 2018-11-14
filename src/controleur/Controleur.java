package controleur;

import donnees.ParametreDAO;
import donnees.TemperatureDAO;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Parametre;
import model.Temperature;

public class Controleur {
    protected TemperatureDAO temperatureDAO;

    public Controleur() {
        temperatureDAO = new TemperatureDAO();
    }

    public void initialize() {

        ParametreDAO parametreDAO = new ParametreDAO();
        Parametre parametre = parametreDAO.rechercherParametre();
        superieurA.setText("" + parametre.getSuperieurA());
        inferieurA.setText("" + parametre.getInferieurA());
        nbElement.setText("" + parametre.getNbElement());
        nbHeure.setText("" + parametre.getNbHeure());

        actualiser();
    }

    @FXML
    private Text min;

    @FXML
    private Text max;

    @FXML
    private Text moyenne;

    @FXML
    private Text mode;

    @FXML
    private Text mediane;

    @FXML
    private Text derniereHeure;

    @FXML
    private Text dernierElement;

    @FXML
    private Text erreur;

    @FXML
    private TextField nbElement;

    @FXML
    private TextField nbHeure;

    @FXML
    private TextField superieurA;

    @FXML
    private TextField inferieurA;

    @FXML
    private RadioButton heureChoix;

    @FXML
    private RadioButton elementChoix;

    private boolean boolHeure;

    @FXML
    private void modifier() {

        try {
            int heure = Integer.parseInt(nbHeure.getText());
            int element = Integer.parseInt(nbElement.getText());
            double superieur = Double.parseDouble(superieurA.getText());
            double inferieur = Double.parseDouble(inferieurA.getText());

            initChoixSelect();
            ParametreDAO parametreDAO = new ParametreDAO();

            parametreDAO.modifierParametre(heure, element, superieur, inferieur, boolHeure);

            if (boolHeure) {
                derniereHeure.setText("" + heure);
                dernierElement.setText("XXX");
            } else {
                derniereHeure.setText("XXX");
                dernierElement.setText("" + element);
            }
            erreur.setVisible(false);
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            erreur.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            erreur.setVisible(true);
        }

        actualiser();


    }

    @FXML
    private void actualiser() {

        Temperature temperature = temperatureDAO.rechercherTemperature();

        moyenne.setText("" + temperature.getMoyenne());
        mode.setText("" + temperature.getMode());
        min.setText("" + temperature.getMinimum());
        max.setText("" + temperature.getMaximum());
        mediane.setText("" + temperature.getMediane());
    }

    private void initChoixSelect() {
        boolHeure = heureChoix.isSelected();
    }

}
