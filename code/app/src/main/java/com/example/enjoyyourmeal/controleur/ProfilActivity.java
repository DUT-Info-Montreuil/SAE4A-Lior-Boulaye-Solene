package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.enjoyyourmeal.API.APIService;
import com.example.enjoyyourmeal.API.ApiClient;
import com.example.enjoyyourmeal.API.SessionResponse;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.enjoyyourmeal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends AppCompatActivity {

    Button btnDeco, mesRecetteButton;
    public static final String NOM_FICHIER_UTILISATEUR_CONNECTER = "sessionEnCours.txt";

    private Button frigoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        frigoButton = findViewById(R.id.frigo_button);
        frigoButton.setOnClickListener(new Button.OnClickListener() {

                public void onClick(View view) {
                Intent frigoActivityIntent = new Intent(ProfilActivity.this, FrigoActivity.class);
                startActivity(frigoActivityIntent);
            }
        });

        btnDeco = findViewById(R.id.button_deconnexion);
        mesRecetteButton = findViewById(R.id.mes_recette_button);

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
