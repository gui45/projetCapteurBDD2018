package controleur;

import javafx.event.ActionEvent;
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

    @FXML
    private void update(){
        int i=1;
    }
}
