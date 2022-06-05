package com.btssio.camerone.ppe4_android_2020_2021_g1.modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.btssio.camerone.ppe4_android_2020_2021_g1.utilitaire.BdSQLiteOpenHelper;


import java.util.ArrayList;



public class DepartementHorsLigneDAO{


    private static String base = "BDDepartement"; //Static = 'membre de class'
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public DepartementHorsLigneDAO(){}

    public DepartementHorsLigneDAO(Context ct){
        accesBD = new BdSQLiteOpenHelper(ct, base, null, version);
    }

    // récupère tout les départements
    public ArrayList<Departement> getDepartement(){
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        Cursor curseur;
        String req = "select * from DEPARTEMENT;";
        curseur = bd.rawQuery(req,null);
        ArrayList<Departement> resultat = cursorToDepartementArrayList(curseur);
        bd.close();
        curseur.close();
        return resultat;
    }


    // parcours les informations d'un département grâce à un curseur
    private ArrayList<Departement> cursorToDepartementArrayList(Cursor curseur){
        ArrayList<Departement> listeDepartement = new ArrayList<Departement>();
        String numDepartement;
        int numeroRegion;
        String nomDepartement;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()){
            numDepartement = curseur.getString(0);
            numeroRegion = curseur.getInt(1);
            nomDepartement = curseur.getString(2);

            listeDepartement.add(new Departement(numDepartement, 2, nomDepartement));
            curseur.moveToNext();
        }
        return listeDepartement;
    }

    // méthode qui permet d'ajouter un département à la bdsqlite
    public void addDepartement(Departement departement){
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NUM_DEPARTEMENT", departement.getnumdepartement());
        values.put("NOM_DEPARTEMENT", departement.getnomdepartement());
        bd.insert("DEPARTEMENT",null,values);
        bd.close();
    }

    // méthode qui permet de supprimer tout les départements
    public void deleteDepartements(){
        SQLiteDatabase bd = accesBD.getWritableDatabase();
        String req = "DELETE FROM DEPARTEMENT;";
        bd.execSQL(req);
        bd.close();
    }
}

