package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.enjoyyourmeal.R;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.enjoyyourmeal.R;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageViewLogo;
    private ImageView mImageViewProfil;
    private EditText mEditTextBarreRecherche;
    private ImageView mImageViewLoupe;
    private Button mButtonCreerRecette;
    private ImageView mImageViewRecetteJour;
    private static final int THIS_REQUEST_CODE = 42;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewLogo = findViewById(R.id.imageView_logo);
        mImageViewProfil = findViewById(R.id.imageView_profil);
        mEditTextBarreRecherche = findViewById(R.id.editText_recherche);
        mImageViewLoupe = findViewById(R.id.imageView_loupe);
        mButtonCreerRecette = findViewById(R.id.button_creer_recette);
        mImageViewRecetteJour = findViewById(R.id.ImageButton_recette_jour);

        mImageViewLogo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ConsultProfilActivityIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivityForResult(ConsultProfilActivityIntent, THIS_REQUEST_CODE);
            }
        });

        mImageViewProfil.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfilActivityIntent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivityForResult(ProfilActivityIntent, THIS_REQUEST_CODE);
            }
        });

        mImageViewRecetteJour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RecetteJourActivityIntent = new Intent(MainActivity.this, RecetteActivity.class);
                startActivityForResult(RecetteJourActivityIntent, THIS_REQUEST_CODE);
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
            layout.addView(imageView);
        }

    }
}