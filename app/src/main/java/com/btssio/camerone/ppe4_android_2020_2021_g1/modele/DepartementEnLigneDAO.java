package com.btssio.camerone.ppe4_android_2020_2021_g1.modele;

import android.util.Log;

import com.btssio.camerone.ppe4_android_2020_2021_g1.utilitaire.AccesHTTP;
import com.btssio.camerone.ppe4_android_2020_2021_g1.utilitaire.EventAsyncDepartement;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by morin on 14/12/2020.
 */

public abstract class DepartementEnLigneDAO implements EventAsyncDepartement {
    private static final String serveur="192.168.1.19";
    private static final String chemin="/gsb_context_android/";
    public void getDepartements(){
        AccesHTTP objAsyncTask = new AccesHTTP(){
            @Override
            protected void onPostExecute(Long result) {
                Log.d("log","onPostExecute departement dao");
                onTacheTerminee(jsonStringToDepartementArrayList(this.ret));
            }
        };
        objAsyncTask.execute("http://"+serveur+chemin+"lesdepartements.php");
    }

    private ArrayList<Departement> jsonStringToDepartementArrayList(String jsonString){
        Log.d("log","conversion jsonToDepartementArray : "+jsonString);

        ArrayList<Departement> listeDepartement = new ArrayList<Departement>();
         String numdepartement;
         String nomdepartement;

        try {
            JSONArray tabJson = new JSONArray(jsonString);
            for(int i=0;i<tabJson.length();i++){
                numdepartement=tabJson.getJSONObject(i).getString("departement_code");
                nomdepartement= tabJson.getJSONObject(i).getString("departement_nom");


                listeDepartement.add(new Departement(numdepartement, 2, nomdepartement));
            }
        }
        catch (JSONException e){
            Log.d("log","pb decodage JSON");
        }
        Log.d("log",Integer.toString(listeDepartement.size()));
        return listeDepartement;
    }

}


