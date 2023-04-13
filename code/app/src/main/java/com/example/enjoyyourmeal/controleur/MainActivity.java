package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.enjoyyourmeal.API.APIService;
import com.example.enjoyyourmeal.API.ApiClient;
import com.example.enjoyyourmeal.API.LoginResponse;
import com.example.enjoyyourmeal.API.SessionResponse;
import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Utilisateur;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageViewLogo, mImageViewProfil, mImageViewLoupe, mImageViewRecetteJour;
    private EditText mEditTextBarreRecherche;
    private Button mButtonCreerRecette;
    private static final int THIS_REQUEST_CODE = 42;
    private FileInputStream in;

    public static String pseudoUserEnCours = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewLogo = findViewById(R.id.imageView_logo);
        mImageViewProfil = findViewById(R.id.imageView_profil);
        mEditTextBarreRecherche = findViewById(R.id.editText_recherche);
        mImageViewLoupe = findViewById(R.id.imageView_loupe);
        mButtonCreerRecette = findViewById(R.id.button_creer_recette);
        mImageViewRecetteJour = findViewById(R.id.ImageButton_recette_jour);

        try {
            in = openFileInput(ProfilActivity.NOM_FICHIER_UTILISATEUR_CONNECTER);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            pseudoUserEnCours = br.readLine().split(" ")[0];
        } catch (Exception e) {
            pseudoUserEnCours = "";
        }
        //sessionEnCours("session");
        mImageViewLogo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ConsultMainActivityIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(ConsultMainActivityIntent);
            }
        });

        mImageViewProfil.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pseudoUserEnCours.isEmpty()){
                    Intent ConnexionActivityIntent = new Intent(MainActivity.this, ConnexionActivity.class);
                    startActivity(ConnexionActivityIntent);
                }else{
                    Intent ProfilActivityIntent = new Intent(MainActivity.this, ProfilActivity.class);
                    startActivity(ProfilActivityIntent);
                }
            }
        });
        mButtonCreerRecette.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pseudoUserEnCours.isEmpty()){
                    Intent ConnexionActivityIntent = new Intent(MainActivity.this, ConnexionActivity.class);
                    startActivity(ConnexionActivityIntent);
                }else{
                    Intent CreerRecetteActivityIntent = new Intent(MainActivity.this, CreerRecetteActivity.class);
                    startActivity(CreerRecetteActivityIntent);
                }

            }
        });

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(10, 10, 10, 10);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.photo_profil));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setClickable(true);
            layout.addView(imageView);
        }

    }

}
