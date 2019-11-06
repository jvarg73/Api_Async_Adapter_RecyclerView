package providers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


import model.Band;

public class ReadInformation {


    public ArrayList<Band> getAllBandsInTown () {
       // Band(String bandName, String bandGenre, String bandDescription, int bandMusicNumber)
       // Band(String name, String height, String mass, String hair_color, String skin_color, String birth_year)


       /* Band fooFigthers = new Band ("Foo Fighters", "Post-grunge", "Foo Fighters es una banda estadounidense de rock alternativo formada en la ciudad de Seattle en 1994 por Dave Grohl, exbaterista de Nirvana y Scream.", 6);
        Band theKillers = new Band ("The Killers", "Indie Rock", "The Killers es una banda de rock estadounidense formada en 2001 en Las Vegas (Nevada) por el vocalista, teclista y bajista Brandon Flowers y el guitarrista Dave Keuning.", 4);
        Band theOffspring = new Band ("The Offspring", "Post-grunge", "The Offspring es una banda de punk rock estadounidense, formada en Huntington Beach, California, en 1984 bajo el nombre de Manic Subsidal.", 4);

        listOfBands.add(fooFigthers);
        listOfBands.add(theKillers);
        listOfBands.add(theOffspring);
*/
        ArrayList <Band>listOfBands = new ArrayList<>();
       //prueba

        try{
                String webService = "https://swapi.co/api/people";
                URL url = new URL(webService);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                if (conn.getResponseCode() ==200){
                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    String output;
                    while ((output = br.readLine()) != null){
                        System.out.println(output);
                        JSONArray json = new JSONObject(output).getJSONArray("results");
                        System.out.println(json);

                        for (int i=0; i<json.length();i++){
                            JSONObject jsonIterator = (JSONObject) json.get(i);
                            Band iterator = new Band (jsonIterator.getString("name"),jsonIterator.getString("height"),jsonIterator.getString("mass"),
                                                        jsonIterator.getString("hair_color"), jsonIterator.getString("skin_color"),jsonIterator.getString("birth_year"));
                            listOfBands.add(iterator);
                        }
                    }
                }
            }
            catch (IOException e) {
                System.out.println(e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        //fin prueba*/


        return listOfBands;
    }

}
