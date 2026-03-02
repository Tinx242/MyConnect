package com.example.rencontre;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    TextView messageAccueil;
    Button deconnexion;
    Switch modeSombreSwitch;
    View rootView;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        messageAccueil = findViewById(R.id.bienvenue);
        deconnexion = findViewById(R.id.deconnexion);
        modeSombreSwitch = findViewById(R.id.modeSombreSwitch);
        videoView = findViewById(R.id.videoView);

        rootView = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        String prenom = getIntent().getStringExtra("prenom");
        String nom = getIntent().getStringExtra("nom");
        messageAccueil.setText("Bienvenue " + prenom + " " + nom);

        deconnexion.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity3.this, MainActivity.class));
            finish();
        });

        modeSombreSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                rootView.setBackgroundColor(Color.parseColor("#FF94B8"));
                messageAccueil.setTextColor(Color.BLACK);
                modeSombreSwitch.setTextColor(Color.BLACK);
            } else {
                rootView.setBackgroundColor(Color.BLACK);
                messageAccueil.setTextColor(Color.WHITE);
                modeSombreSwitch.setTextColor(Color.WHITE);
            }
        });


        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.lafraise;

        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        videoView.start();
    }
}
