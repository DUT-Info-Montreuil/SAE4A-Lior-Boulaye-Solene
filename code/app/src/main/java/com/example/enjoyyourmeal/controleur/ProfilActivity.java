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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        btnDeco = findViewById(R.id.button_deconnexion);

            btnDeco.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                deconnexion("deconnexion");
                Intent ConsultMainActivityIntent = new Intent(ProfilActivity.this, MainActivity.class);
                startActivity(ConsultMainActivityIntent);
            }
        });
    }

    private void deconnexion(String deconnexion) {
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<SessionResponse> call = apiService.initSession(deconnexion);

        call.enqueue(new Callback<SessionResponse>() {
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                if (response.isSuccessful()) {
                    SessionResponse sessionResponse = response.body();
                    if (sessionResponse.isSuccess()) {
                        // Traitement de la réponse de l'API en cas de succès
                        Toast.makeText(ProfilActivity.this, sessionResponse.getMessage(), Toast.LENGTH_LONG).show();
                    } else {
                        // Traitement de l'erreur en cas de connexion échouée
                        Toast.makeText(ProfilActivity.this, sessionResponse.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    // Traitement de l'erreur en cas d'échec de la connexion à l'API
                    Toast.makeText(ProfilActivity.this, "Erreur de connexion à l'API(deconnexion)", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<SessionResponse> call, Throwable t) {
                Toast.makeText(ProfilActivity.this, "Erreur de connexion on Failure(deconnexion)", Toast.LENGTH_SHORT) .show();
                Log.e("API_ERROR", "Erreur de connexion à l'API onfailure", t);
            }
        });
    }
}

