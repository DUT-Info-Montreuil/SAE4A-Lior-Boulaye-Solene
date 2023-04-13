package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.ListeDeCourse;

public class AfficherListeDeCourseActivity extends AppCompatActivity {

    private ImageButton mButton_retour;
    private EditText mEditText_listeDeCourse;
    private ImageButton mButton_accueil;
    private Button mButton_modifierListeDeCourse;
    private ListView mListView_listeDeCourse;
    private ListeDeCourse listeDeCourse;
    private static final int THIS_REQUEST_CODE = 42;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_liste_de_course);

        mButton_accueil = (ImageButton) findViewById(R.id.imageButton_accueil);
        mButton_retour = (ImageButton) findViewById(R.id.imageButton_retour);
        mEditText_listeDeCourse = (EditText) findViewById(R.id.editText_listeDeCourse);
        mButton_modifierListeDeCourse = (Button) findViewById(R.id.button_modifierListeDeCourse);
        mListView_listeDeCourse = (ListView) findViewById(R.id.listeView_listeDeCourse);
        //récuperer liste de course dans la bd
//        mEditText_listeDeCourse.setText(listeDeCourse.toString());

        mButton_retour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent RecetteActivityIntent = new Intent(AfficherListeDeCourseActivity.this, RecetteActivity.class);
                startActivityForResult(RecetteActivityIntent, THIS_REQUEST_CODE);
            }
        });

        mButton_accueil.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AccueilActivityIntent = new Intent(AfficherListeDeCourseActivity.this, MainActivity.class);
                startActivityForResult(AccueilActivityIntent, THIS_REQUEST_CODE);
            }
        });

        mButton_modifierListeDeCourse.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ModifierListeDeCourseActivityIntent = new Intent(AfficherListeDeCourseActivity.this, ModifierListeDeCourseActivity.class);
                startActivityForResult(ModifierListeDeCourseActivityIntent, THIS_REQUEST_CODE);
            }
        });
    }
}