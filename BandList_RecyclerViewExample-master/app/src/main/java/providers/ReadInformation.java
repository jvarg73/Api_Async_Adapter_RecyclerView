package providers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import model.Band;

public class ReadInformation {


    public ArrayList<Band> getAllBandsInTown (String jsonString) {
       // Band(String name, String height, String mass, String hair_color, String skin_color, String birth_year)

        //prueba
        ArrayList <Band>listOfBands = new ArrayList<>();
        JSONArray json;
        try {
            json = new JSONObject(jsonString).getJSONArray("results");
            for (int i=0; i<json.length();i++){
                JSONObject jsonIterator = (JSONObject) json.get(i);
                Band iterator = new Band (jsonIterator.getString("name"),jsonIterator.getString("height"),jsonIterator.getString("mass"),
                        jsonIterator.getString("hair_color"), jsonIterator.getString("skin_color"),jsonIterator.getString("birth_year"));
                listOfBands.add(iterator);
            }
            System.out.println(listOfBands.get(0).getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //fin prueba*/

        return listOfBands;
    }
}
