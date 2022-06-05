package com.btssio.camerone.ppe4_android_2020_2021_g1.utilitaire;

import java.util.ArrayList;
import com.btssio.camerone.ppe4_android_2020_2021_g1.modele.Medecin;



public interface EventAsyncMedecin {
    public void onTacheTerminee(String resultat);
    public void onTacheTerminee(ArrayList<Medecin> resultat);
    public void onTacheTerminee(Medecin resultat);
}
