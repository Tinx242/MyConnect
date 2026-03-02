package com.example.rencontre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button connexion, inscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        connexion = findViewById(R.id.se_connnecter);
        inscription = findViewById(R.id.inscription);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString().trim();
                String mdp = password.getText().toString().trim();

                if (e.isEmpty() || mdp.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    UtilisateurManager UtilisateurManager = new UtilisateurManager();
                    Utilisateur u = com.example.rencontre.UtilisateurManager.trouverParEmailEtMotDePasse(e, mdp);
                    if (u != null) {
                        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                        intent.putExtra("prenom", u.getPrenom());
                        intent.putExtra("nom", u.getNom());
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Identifiants incorrects", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        inscription.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        });
    }
}