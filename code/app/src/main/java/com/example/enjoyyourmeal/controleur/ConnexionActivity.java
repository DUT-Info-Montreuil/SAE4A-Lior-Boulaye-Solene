package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Api;
import com.example.enjoyyourmeal.modele.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnexionActivity extends AppCompatActivity {

    private EditText pseudo, motDePasse;
    private Button connexionButton;
    private TextView lienActiviteInscription;
    private RetrofitClient mRetrofitClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        pseudo = findViewById(R.id.connexion_pseudo);
        motDePasse = findViewById(R.id.connexion_mot_de_passe);
        connexionButton = findViewById(R.id.connexionButton);
        mRetrofitClient = RetrofitClient.getInstance();

        lienActiviteInscription = findViewById(R.id.lien_activite_inscription);
        lienActiviteInscription.setTextColor(Color.BLUE);
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
        if(ConnexionActivity.getEditText(pseudo).isEmpty()
                ||ConnexionActivity.getEditText(motDePasse).isEmpty()){
            pseudo.setError("Merci de remplir tout les champs");
            pseudo.requestFocus();
            motDePasse.setError("Merci de remplir tout les champs");
            motDePasse.requestFocus();
        }
        else {
            // display a progress dialog
            final ProgressDialog progressDialog = new ProgressDialog(ConnexionActivity.this);
            progressDialog.setCancelable(false); // set cancelable to false
            progressDialog.setMessage("Chargement en cours merci de patienté"); // set message
            progressDialog.show(); // show progress dialog
            Api.LoginService loginService = mRetrofitClient.getLoginService();
            loginService.login(getEditText(pseudo), getEditText(motDePasse), new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(ConnexionActivity.this, response.body().message, Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                        Intent mainActivity = new Intent(ConnexionActivity.this, MainActivity.class);
                        startActivity(mainActivity);

                    }
                    else{
                        progressDialog.dismiss();
                        pseudo.setError("pseudo ou mot de passe incorrect");
                        motDePasse.setError("pseudo ou mot de passe incorrect");
                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    Log.d("response ", t.getStackTrace().toString());
                    progressDialog.dismiss();
                    pseudo.setError(t.getMessage());
                }
            });
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


    public class Login {
        String message;
        int succes;
    }

}