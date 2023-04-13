package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enjoyyourmeal.API.APIService;
import com.example.enjoyyourmeal.API.ApiClient;
import com.example.enjoyyourmeal.API.LoginResponse;
import com.example.enjoyyourmeal.R;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnexionActivity extends AppCompatActivity {

    private EditText pseudo;
    private EditText motDePasse;
    private Button connexionButton;
    private TextView lienActiviteInscription, errorTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        pseudo = findViewById(R.id.connexion_pseudo);
        motDePasse = findViewById(R.id.connexion_mot_de_passe);
        connexionButton = findViewById(R.id.connexionButton);
        errorTextView = findViewById(R.id.connexion_error_textview);
        lienActiviteInscription = findViewById(R.id.lien_activite_inscription);
        lienActiviteInscription.setPaintFlags(lienActiviteInscription.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        lienActiviteInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent connexionActivity = new Intent(ConnexionActivity.this, InscriptionActivity.class);
                startActivity(connexionActivity);
            }
        });

        connexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seConnecter();
            }
        });
    }

    private void seConnecter() {
        if(getEditText(pseudo).isEmpty() || getEditText(motDePasse).isEmpty()){
            errorTextView.setText("Merci de remplir tout les champs");
        } else {
                userLogin(getEditText(pseudo), getEditText(motDePasse));
        }
    }

    /**
     * 
     * @param editText un editText
     * @return le string entre par l'utilsiateur sans espaces au debut et a la fin
     */
    public static String getEditText(EditText editText){
        return editText.getText().toString().trim();
    }

    private void userLogin(String username, String password) {
        APIService apiService = ApiClient.getClient().create(APIService.class);

        Call<LoginResponse> call = apiService.userLogin(username, password,"connexion");
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse.isSuccess()) {
                        // Traitement de la réponse de l'API en cas de succès
                        try {
                            FileOutputStream out = openFileOutput(ProfilActivity.NOM_FICHIER_UTILISATEUR_CONNECTER, MODE_PRIVATE);
                            String user = getEditText(pseudo);
                            out.write(user.getBytes(StandardCharsets.UTF_8));
                        } catch (Exception e) {

                        }
                        Toast.makeText(ConnexionActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                        Intent MainActivityIntent = new Intent(ConnexionActivity.this, MainActivity.class);
                        startActivity(MainActivityIntent);
                    } else {
                        // Traitement de l'erreur en cas de connexion échouée
                        Toast.makeText(ConnexionActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                        errorTextView.setText(loginResponse.getMessage());
                    }
                } else {
                    // Traitement de l'erreur en cas d'échec de la connexion à l'API
                    Toast.makeText(ConnexionActivity.this, "Erreur de connexion à l'API", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // Traitement de l'erreur en cas d'échec de la connexion à l'API
                Toast.makeText(ConnexionActivity.this, "Erreur de connexion à l'API on Failure", Toast.LENGTH_SHORT) .show();
                Log.e("API_ERROR", "Erreur de connexion à l'API onfailure", t);

            }
        });
    }



}