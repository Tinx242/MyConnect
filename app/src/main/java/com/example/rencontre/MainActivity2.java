package com.example.rencontre;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rencontre.MainActivity;
import com.example.rencontre.R;
import com.example.rencontre.Utilisateur;
import com.example.rencontre.UtilisateurManager;

public class MainActivity2 extends AppCompatActivity {

    private EditText nom, prenom, email, motDePasse;
    private Button inscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        email = findViewById(R.id.email);
        motDePasse = findViewById(R.id.password);
        inscription = findViewById(R.id.inscrire);

        inscription.setOnClickListener(v -> inscrireUtilisateur());
    }

    private void inscrireUtilisateur() {
        String n = nom.getText().toString().trim();
        String p = prenom.getText().toString().trim();
        String e = email.getText().toString().trim();
        String mdp = motDePasse.getText().toString().trim();

        if (n.isEmpty() || p.isEmpty() || e.isEmpty() || mdp.isEmpty()) {
            Toast.makeText(this, "Tous les champs sont requis", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
            Toast.makeText(this, "Format d'email invalide", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mdp.length() < 6) {
            Toast.makeText(this, "Le mot de passe doit contenir au moins 6 caractères", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Utilisateur nouvelUtilisateur = new Utilisateur(n, p, e, mdp);
            UtilisateurManager.ajouterUtilisateur(nouvelUtilisateur);

            Toast.makeText(this, "Inscription réussie", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } catch (Exception ex) {
            Toast.makeText(this, "Erreur lors de l'inscription: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
