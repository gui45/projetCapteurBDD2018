package controleur;

import donnees.ParametreDAO;
import donnees.TemperatureDAO;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Parametre;
import model.Temperature;

public class ControleurVueTableauDeBord {
    protected TemperatureDAO temperatureDAO;
    private ControleurPrincipal controleurPrincipal = ControleurPrincipal.getInstance();

    public ControleurVueTableauDeBord() {
        temperatureDAO = new TemperatureDAO();
    }

    public void initialize() {

        Parametre parametre = controleurPrincipal.rechercherParametre();

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

            controleurPrincipal.modifierParametre(heure, element, superieur,inferieur,boolHeure);

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

        Temperature temperature = controleurPrincipal.rechercherTemperature();

        moyenne.setText((temperature.getMoyenne() != 999999) ? "" + temperature.getMoyenne() : "Valeur erronée");
        mode.setText((temperature.getMode() != 999999) ? "" + temperature.getMode() : "Valeur erronée");
        min.setText((temperature.getMinimum() != 999999) ? "" + temperature.getMinimum() : "Valeur erronée");
        max.setText((temperature.getMaximum() != 999999) ? "" + temperature.getMaximum() : "Valeur erronée");
        mediane.setText((temperature.getMediane() != 999999) ? "" + temperature.getMediane() : "Valeur erronée");
    }

    private void initChoixSelect() {
        boolHeure = heureChoix.isSelected();
    }

    public Text getErreur() {
        return erreur;
    }
}