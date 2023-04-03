package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Recette;

import java.io.Serializable;

public class EtapeRecetteActivity extends AppCompatActivity {
    private Recette recette;
    private ImageButton flecheRetour;
    private Button prochaine_etape;
    private Button accueil;
    private static final int THIS_REQUEST_CODE = 42;
    private int num_etape;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etape_recette);
        recette = (Recette) getIntent().getSerializableExtra("recette");
        if(num_etape>1) {
            num_etape = (int) getIntent().getSerializableExtra("num_etape");
        }
        flecheRetour = findViewById(R.id.imageButton_flecheRetour);
        prochaine_etape = findViewById(R.id.button_prochaine_etape);
        accueil = findViewById(R.id.button_accueil);

        flecheRetour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RecetteActivityIntent = new Intent(EtapeRecetteActivity.this, RecetteActivity.class);
                startActivityForResult(RecetteActivityIntent, THIS_REQUEST_CODE);
            }
        });

        prochaine_etape.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProchaineEtapeActivityIntent = new Intent(EtapeRecetteActivity.this, EtapeRecetteActivity.class);
                num_etape++;
                ProchaineEtapeActivityIntent.putExtra("num_etape", (Serializable) num_etape);
                startActivityForResult(ProchaineEtapeActivityIntent, THIS_REQUEST_CODE);
            }
        });

        accueil.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivityIntent = new Intent(EtapeRecetteActivity.this, MainActivity.class);
                startActivityForResult(MainActivityIntent, THIS_REQUEST_CODE);
            }
        });
    }
}