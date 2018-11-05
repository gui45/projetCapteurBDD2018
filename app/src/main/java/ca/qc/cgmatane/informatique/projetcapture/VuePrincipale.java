package ca.qc.cgmatane.informatique.projetcapture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VuePrincipale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RecevoirMoyenneTemp recevoirMoyenneTemp = new RecevoirMoyenneTemp();
        Temperature temperature = recevoirMoyenneTemp.getTemperature();

        TextView dateTV = (TextView)findViewById(R.id.date);
        dateTV.setText(temperature.getDate());

        TextView temperatureTV = (TextView)findViewById(R.id.temperature);
        temperatureTV.setText(temperature.getTemperature());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitee_vue_principale);
    }
}
