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
import com.example.enjoyyourmeal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends AppCompatActivity {

    Button btnDeco;
    public static final String NOM_FICHIER_UTILISATEUR_CONNECTER = "sessionEnCours.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        btnDeco = findViewById(R.id.button_deconnexion);

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

