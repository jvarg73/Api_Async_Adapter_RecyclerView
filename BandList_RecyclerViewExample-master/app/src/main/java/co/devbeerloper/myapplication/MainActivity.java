package co.devbeerloper.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import model.Band;
import providers.ReadInformation;

public class MainActivity extends AppCompatActivity {

    private RecyclerView bandsRecyclerView;
    private RecyclerView.Adapter myBandAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Band> bandsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bandsRecyclerView= findViewById(R.id.bandsRecyclerView);

        Async d = new Async();
        d.execute();

        layoutManager = new LinearLayoutManager(this);
        bandsRecyclerView.setLayoutManager(layoutManager);


        myBandAdapter = new MyBandAdapter(bandsList);
        bandsRecyclerView.setAdapter(myBandAdapter);
    }

    private class Async extends AsyncTask<Void,Void,Void>{
        String output;
        @Override
        protected Void doInBackground(Void... Voids) {
            Log.d("Cliente RSS", "se esta ejecutando");

            try{
                String webService = "https://swapi.co/api/people";
                URL url = new URL(webService);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() ==200){
                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    output = br.readLine();
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void param) {
            ReadInformation readerOfInfo = new ReadInformation();
            bandsList = readerOfInfo.getAllBandsInTown (output);
            myBandAdapter.notifyDataSetChanged();
        }
    }
}
