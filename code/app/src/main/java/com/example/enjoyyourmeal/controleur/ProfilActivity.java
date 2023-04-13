package com.example.enjoyyourmeal.controleur;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enjoyyourmeal.R;

public class ProfilActivity extends AppCompatActivity {

    Button btnDeco, mesRecetteButton;
    public static final String NOM_FICHIER_UTILISATEUR_CONNECTER = "sessionEnCours.txt";

    private Button frigoButton;
    private Button listeDeCourse;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        mesRecetteButton = findViewById(R.id.mes_recette_button);
        btnDeco = findViewById(R.id.button_deconnexion);
                mesRecetteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(ProfilActivity.this, MesRecetteActivity.class));
                    }
                });

                btnDeco.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteFile(NOM_FICHIER_UTILISATEUR_CONNECTER);
                        Intent ConsultMainActivityIntent = new Intent(ProfilActivity.this, MainActivity.class);
                        startActivity(ConsultMainActivityIntent);
                    }
                });
            }
    }
