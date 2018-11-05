package ca.qc.cgmatane.informatique.projetcapture;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecevoirMoyenneTemp extends AsyncTask<String, String, String> {

    private double moyenneTemp;
    private Temperature temperature;

    public RecevoirMoyenneTemp(){}

    @Override
    protected String doInBackground(String... params) {

        Response reponse;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("")
                .build();

        try
        {
            reponse = client.newCall(request).execute();

            String jsonDonneesString = reponse.body().string();
            JSONObject jsonDonneesObjet = new JSONObject(jsonDonneesString);

            String temperatureString = jsonDonneesObjet.getString("temperature");
            String date = jsonDonneesObjet.getString("timestamp");


            temperature = new Temperature(temperatureString, date);



        } catch(Exception e)
        {

        }

        return null;
    }

    public Temperature getTemperature(){
        return temperature;
    }
}
