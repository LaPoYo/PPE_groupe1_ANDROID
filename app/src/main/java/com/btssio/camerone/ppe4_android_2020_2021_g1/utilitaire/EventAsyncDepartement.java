package com.btssio.camerone.ppe4_android_2020_2021_g1.utilitaire;

import com.btssio.camerone.ppe4_android_2020_2021_g1.modele.Departement;

import java.util.ArrayList;



public interface EventAsyncDepartement {
    public void onTacheTerminee(String resultat);
    public void onTacheTerminee(ArrayList<Departement> resultat);
    public void onTacheTerminee(Departement resultat);
}
