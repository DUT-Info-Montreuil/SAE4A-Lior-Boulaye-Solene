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
    private EditText pseudo, email, motDePasse, confirmMotDePasse;
    private Button inscriptionButton;
    private TextView lienActiviteConnection;
    protected Utilisateur mUtilisateur;
    private RetrofitClient mRetrofitClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        pseudo = findViewById(R.id.incription_pseudo);
        email = findViewById(R.id.incription_email);
        motDePasse = findViewById(R.id.incription_mot_de_passe);
        confirmMotDePasse = findViewById(R.id.confirme_mot_de_passe);
        inscriptionButton = findViewById(R.id.inscriptionButton);
        lienActiviteConnection = findViewById(R.id.lien_activite_connexion);
        lienActiviteConnection.setTextColor(Color.BLUE);
        mRetrofitClient = RetrofitClient.getInstance();
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

    private void inscrire() {
        try {
            inscriptionValide();
        } catch (pseudoDejaExistantException e) {
            pseudo.setError("le pseudo choisi est déjà pris  ! \nmerci d'en choisir un autre");
        } catch (ChampsNonRempliExecption e) {
            pseudo.setError("Merci de remplir tout les champs");
            pseudo.requestFocus();
            email.setError("Merci de remplir tout les champs");
            email.requestFocus();
            motDePasse.setError("Merci de remplir tout les champs");
            motDePasse.requestFocus();
            confirmMotDePasse.setError("Merci de remplir tout les champs");
            confirmMotDePasse.requestFocus();
        } catch (MotdePasseTropFaibleException e) {
            motDePasse.setError("Le mot de passe doit faire au moins 8 charactère");
        } catch (MotdePasseDifferentException e) {
            motDePasse.setError("Les mots de passe sont différents");
            confirmMotDePasse.setError("Les mots de passe sont différents");
        }
    }

    private void inscriptionValide() throws pseudoDejaExistantException,
            MotdePasseDifferentException, MotdePasseTropFaibleException, ChampsNonRempliExecption {

        if(estChampsVide())
            throw new ChampsNonRempliExecption();
        if(ConnexionActivity.getEditText(motDePasse).length() < TAILLE_MOT_DE_PASSE)
            throw new MotdePasseTropFaibleException();
        if (!ConnexionActivity.getEditText(motDePasse).equals(ConnexionActivity.getEditText(confirmMotDePasse))) {
            throw new MotdePasseDifferentException();
        }
    }

    private boolean estChampsVide() {
        return ConnexionActivity.getEditText(pseudo).isEmpty()
                ||ConnexionActivity.getEditText(email).isEmpty()
                ||ConnexionActivity.getEditText(motDePasse).isEmpty()
                ||ConnexionActivity.getEditText(confirmMotDePasse).isEmpty();
    }

}