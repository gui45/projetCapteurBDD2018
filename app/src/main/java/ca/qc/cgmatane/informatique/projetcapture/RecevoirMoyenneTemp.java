package ca.qc.cgmatane.informatique.projetcapture;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecevoirMoyenneTemp extends AsyncTask<String, String, String> {

    private double moyenneTemp;
    private Temperature temperature;

    public RecevoirMoyenneTemp(){}

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        Response reponse;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/temperature/moyenne/")
                .build();

        Log.d("LOGTEST","0");

        try
        {
            Log.d("LOGTEST","1");
            reponse = client.newCall(request).execute();

            if (!reponse.isSuccessful())
                throw new IOException("Code non attendu : " + reponse.toString());

            Log.d("LOGTEST","2");

            String jsonDonneesString = reponse.body().string();
            JSONArray jsonArray = new JSONArray(jsonDonneesString);

            JSONObject jsonObject = jsonArray.getJSONObject(1);
            String temperatureString = jsonObject.getString("temp");
            String date = jsonObject.getString("timestamp");

            this.temperature = new Temperature(temperatureString, date);



        } catch(Exception e)
        {
            e.printStackTrace();
            Log.d("LOGTEST","NON");
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    public Temperature getTemperature(){
        return temperature;
    }
}
