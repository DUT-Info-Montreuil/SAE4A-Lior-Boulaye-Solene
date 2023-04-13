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

        frigoButton = findViewById(R.id.frigo_button);
        listeDeCourse = (Button) findViewById(R.id.liste_de_course_button);
        frigoButton.setOnClickListener(new Button.OnClickListener() {

                public void onClick(View view) {
                Intent frigoActivityIntent = new Intent(ProfilActivity.this, FrigoActivity.class);
                startActivity(frigoActivityIntent);
            }
        });
        listeDeCourse.setOnClickListener(new Button.OnClickListener() {


            public void onClick(View view) {
                Intent ListeCourseActivityIntent = new Intent(ProfilActivity.this, AfficherListeDeCourseActivity.class);
                startActivity(ListeCourseActivityIntent);
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
