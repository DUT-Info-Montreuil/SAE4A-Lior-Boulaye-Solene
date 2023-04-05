package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Recette;

import java.io.Serializable;

public class EtapeRecetteActivity extends AppCompatActivity {
    private Recette recette;
    private ImageButton flecheRetour;
    private Button prochaine_etape;
    private Button mButton_etape_precedente;
    private Button accueil;
    private static final int THIS_REQUEST_CODE = 42;
    private int num_etape;
    private EditText mEditTextNumber_numEtape;
    private EditText mEditText_nomRecette;
    private EditText mEditText_numEtape;
    private TextView mTextView_etape;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etape_recette);
        recette = (Recette) getIntent().getSerializableExtra("recette");
        num_etape = 1;
        flecheRetour = findViewById(R.id.imageButton_flecheRetour);
        prochaine_etape = findViewById(R.id.button_prochaine_etape);
        accueil = findViewById(R.id.button_accueil);
        mEditText_nomRecette = findViewById(R.id.editText_nomRecette);
        mEditText_numEtape = findViewById(R.id.editText_numEtape);
        mTextView_etape = findViewById(R.id.textView_etape);
        mEditTextNumber_numEtape = findViewById(R.id.editTextNumber_numEtape);
        mButton_etape_precedente = findViewById(R.id.button_etapePrecedente);

        mEditText_nomRecette.setText(recette.getTitre());
        mEditTextNumber_numEtape.setText(num_etape);
        mTextView_etape.setText(recette.getEtapes().get(num_etape-1));
        mEditText_numEtape.setText("Etape : ");

        flecheRetour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RecetteActivityIntent = new Intent(EtapeRecetteActivity.this, RecetteActivity.class);
                startActivityForResult(RecetteActivityIntent, THIS_REQUEST_CODE);
            }
        });

        prochaine_etape.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_etape++;
                mEditTextNumber_numEtape.setText(num_etape);
                mTextView_etape.setText(recette.getEtapes().get(num_etape-1));
                if(mButton_etape_precedente.getVisibility() == View.INVISIBLE){
                    mButton_etape_precedente.setVisibility(View.VISIBLE);
                }


            }
        });
        mButton_etape_precedente.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_etape--;
                mEditTextNumber_numEtape.setText(num_etape);
                mTextView_etape.setText(recette.getEtapes().get(num_etape-1));
                if(mButton_etape_precedente.getVisibility() == View.VISIBLE && num_etape==1){
                    mButton_etape_precedente.setVisibility(View.INVISIBLE);
                }


            }
        });
        accueil.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivityIntent = new Intent(EtapeRecetteActivity.this, MainActivity.class);
                startActivityForResult(MainActivityIntent, THIS_REQUEST_CODE);
            }
        });
    }
}