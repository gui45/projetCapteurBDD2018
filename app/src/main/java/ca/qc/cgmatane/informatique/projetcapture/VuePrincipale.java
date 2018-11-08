package ca.qc.cgmatane.informatique.projetcapture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class VuePrincipale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitee_vue_principale);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                RecevoirMoyenneTemp recevoirMoyenneTemp = new RecevoirMoyenneTemp();
                try {
                    recevoirMoyenneTemp.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Temperature temperature = recevoirMoyenneTemp.getTemperature();

                TextView dateTV = (TextView)findViewById(R.id.date);
                dateTV.setText(temperature.getDate());

                TextView temperatureTV = (TextView)findViewById(R.id.temperature);
                temperatureTV.setText(temperature.getTemperature());
            }
        };

        timer.scheduleAtFixedRate(timerTask,0,10000);







    }
}
