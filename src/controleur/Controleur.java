package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controleur {

    @FXML
    private Text min;

    @FXML
    private Text max;

    @FXML
    private Text average;

    @FXML
    private Text mode;

    @FXML
    private Text mediane;

    @FXML
    private Text lastHours;

    @FXML
    private Text lastIntakes;

    @FXML
    private Text erreur;

    @FXML
    private TextField nbIntakes;

    @FXML
    private TextField nbHours;

    @FXML
    private TextField over;

    @FXML
    private TextField under;

    @FXML
    private RadioButton hoursChoice;

    @FXML
    private RadioButton intakesChoice;

    @FXML
    private Button buttonUpdate;

    private boolean boolHour;
    private boolean boolExit = false;
    private int hours, intakes;
    private double limitOver, limitUnder;


    @FXML
    private void update() {

        initValueUpdate();
        initSelectedChoice();
        
        if (areValuesCorrect()) {
            // TODO: Call API

            //TEST:
            System.out.println(intakes + " - " + hours + " - " + limitOver + " - " + limitUnder);
        }
        else{
            erreur.setVisible(true);
        }
    }

    private void initValueUpdate(){
        limitOver = 0.0;
        limitUnder = 0.0;
        hours = 0;
        intakes = 0;
        boolExit = false;
        erreur.setVisible(false);
    }

    private void initSelectedChoice(){
        if (hoursChoice.isSelected()) {
            boolHour = true;
        } else {
            boolHour = false;
        }
    }

    private boolean areValuesCorrect(){
        try {

            String tempIntakes = nbIntakes.getText();
            String tempHours = nbHours.getText();
            String tempLimitOver = over.getText();
            String tempLimitUnder = under.getText();

            if (tempLimitOver.equals("")) {
                limitOver = 0;
            } else {
                limitOver = Double.parseDouble(tempLimitOver);
            }

            if (tempLimitUnder.equals("")) {
                limitUnder = 0;
            } else {
                limitUnder = Double.parseDouble(tempLimitUnder);
            }

            if (boolHour) {
                if (tempHours.equals("")) {
                    boolExit = true;
                } else {
                    hours = Integer.parseInt(tempHours);
                }
            } else {
                if (tempIntakes.equals("")) {
                    boolExit = true;
                } else {
                    intakes = Integer.parseInt(tempIntakes);
                }
            }
        } catch (NumberFormatException numberFormatException) {
            boolExit = true;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return !boolExit;
    }
}
