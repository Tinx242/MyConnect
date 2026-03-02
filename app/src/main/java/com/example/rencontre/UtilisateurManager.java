package com.example.rencontre;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurManager extends AppCompatActivity {

    private static List<Utilisateur> utilisateurs = new ArrayList<>();

    public static void ajouterUtilisateur(Utilisateur U) {
        utilisateurs.add(U);
    }

    public static Utilisateur trouverParEmailEtMotDePasse(String email, String mdp) {
        for (Utilisateur U : utilisateurs) {
            if (U.getEmail().equals(email) && U.getMotPasse().equals(mdp)) {
                return U;
            }
        }
        return null;
    }
}
