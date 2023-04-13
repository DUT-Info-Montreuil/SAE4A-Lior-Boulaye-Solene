package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enjoyyourmeal.API.APIService;
import com.example.enjoyyourmeal.API.ApiClient;
import com.example.enjoyyourmeal.API.LoginResponse;
import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Utilisateur;
import com.example.enjoyyourmeal.modele.exceptions.ChampsNonRempliExecption;
import com.example.enjoyyourmeal.modele.exceptions.MotdePasseDifferentException;
import com.example.enjoyyourmeal.modele.exceptions.MotdePasseTropFaibleException;
import com.example.enjoyyourmeal.modele.exceptions.pseudoDejaExistantException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InscriptionActivity extends AppCompatActivity {

    private static final int TAILLE_MOT_DE_PASSE = 8;

    private TextView ErrorTextView;
    private EditText pseudo;
    private EditText motDePasse;
    private EditText confirmMotDePasse;
    private Button inscriptionButton;
    private TextView lienActiviteConnection;
    private Utilisateur mUtilisateur;

    private String session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        pseudo = findViewById(R.id.incription_pseudo);
        motDePasse = findViewById(R.id.incription_mot_de_passe);
        confirmMotDePasse = findViewById(R.id.confirme_mot_de_passe);
        inscriptionButton = findViewById(R.id.inscriptionButton);
        ErrorTextView = findViewById(R.id.inscription_error_textview);
        lienActiviteConnection = findViewById(R.id.lien_activite_connexion);
        lienActiviteConnection.setPaintFlags(lienActiviteConnection.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        lienActiviteConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent connexionActivity = new Intent(InscriptionActivity.this, ConnexionActivity.class);
                startActivity(connexionActivity);
            }
        });

        inscriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inscrire();
            }
        });

    }
    public static String getEditText(EditText editText){
        return editText.getText().toString().trim();
    }

    private void inscrire() {
        try {
            inscriptionValide();
            userSignIn(getEditText(pseudo),getEditText(motDePasse));

        } catch (pseudoDejaExistantException e) {
            ErrorTextView.setText("le pseudo choisi est déjà pris  ! \nmerci d'en choisir un autre");
        } catch (ChampsNonRempliExecption e) {
            ErrorTextView.setText("Merci de remplir tout les champs");
        } catch (MotdePasseTropFaibleException e) {
            ErrorTextView.setText("Le mot de passe doit faire au moins 8 charactère");
        } catch (MotdePasseDifferentException e) {
            ErrorTextView.setText("Les mots de passe sont différents");
        }
    }

    private void inscriptionValide() throws pseudoDejaExistantException,
            MotdePasseDifferentException, MotdePasseTropFaibleException, ChampsNonRempliExecption {

        if(ConnexionActivity.getEditText(pseudo).isEmpty()
                ||ConnexionActivity.getEditText(motDePasse).isEmpty()
                ||ConnexionActivity.getEditText(confirmMotDePasse).isEmpty())
            throw new ChampsNonRempliExecption();
        if(ConnexionActivity.getEditText(motDePasse).length() < TAILLE_MOT_DE_PASSE)
            throw new MotdePasseTropFaibleException();
        if (!ConnexionActivity.getEditText(motDePasse).equals(ConnexionActivity.getEditText(confirmMotDePasse))) {
            throw new MotdePasseDifferentException();
        }
    }

    private void userSignIn(String username, String password) {
        APIService apiService = ApiClient.getClient().create(APIService.class);

        Call<LoginResponse> call = apiService.userSignIn(username, password,"inscription");
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse.isSuccess()) {
                        // Traitement de la réponse de l'API en cas de succès
                        Toast.makeText(InscriptionActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent MainActivityIntent = new Intent(InscriptionActivity.this, MainActivity.class);
                        startActivity(MainActivityIntent);
                    } else {
                        // Traitement de l'erreur en cas de inscription échouée
                        Toast.makeText(InscriptionActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        ErrorTextView.setText(loginResponse.getMessage());
                    }
                } else {
                    // Traitement de l'erreur en cas d'échec de la connexion à l'API
                    Toast.makeText(InscriptionActivity.this, "Erreur de connexion à l'API", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // Traitement de l'erreur en cas d'échec de la connexion à l'API
                Toast.makeText(InscriptionActivity.this, "Erreur de connexion à l'API", Toast.LENGTH_SHORT) .show();
            }
        });
    }

}