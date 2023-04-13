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
import com.example.enjoyyourmeal.modele.Ingredient;
import com.example.enjoyyourmeal.modele.ListeDeCourse;
import com.example.enjoyyourmeal.modele.Quantite;

public class ModifierListeDeCourseActivity extends AppCompatActivity {

    private ImageButton mButton_retour;
    private Button mButton_ajoutIngredientListeDeCourse;
    private TextView mTextView_modifierListeDeCourse;
    private EditText mEditText_nomIngredient;
    private EditText mEditText_quantite;
    private EditText mEditText_unite;
    private static final int THIS_REQUEST_CODE = 42;
    private Ingredient mIngredient;
    private Quantite mQuantite;
    private String nomIngredient, unite, string_quantite="0";
    private int quantite;
    private ListeDeCourse mListeDeCourse;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_liste_de_course);

        mButton_ajoutIngredientListeDeCourse = (Button) findViewById(R.id.button_modifierListeDeCourse);
        mButton_retour = (ImageButton) findViewById(R.id.Button_retour);
        mTextView_modifierListeDeCourse = (TextView) findViewById(R.id.textView_modifierListeDeCourse);
        mEditText_nomIngredient = (EditText) findViewById(R.id.editText_nomIngredient);
        mEditText_quantite = (EditText) findViewById(R.id.editText_quantite);
        mEditText_unite = (EditText) findViewById(R.id.editText_unite);
        nomIngredient = mEditText_nomIngredient.getText().toString();




        mButton_retour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                unite = mEditText_unite.getText().toString();
                string_quantite = mEditText_quantite.getText().toString();
                quantite = Integer.parseInt(string_quantite);
                mQuantite = new Quantite(unite,quantite);
                //mIngredient = new Ingredient(nomIngredient,mQuantite);
                mListeDeCourse.AjouterIngredientDansLaListe(mIngredient);

                Intent MainActivityIntent = new Intent(ModifierListeDeCourseActivity.this, MainActivity.class);
                startActivityForResult(MainActivityIntent, THIS_REQUEST_CODE);
            }
        });

        mButton_ajoutIngredientListeDeCourse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent AjouterIngredientListeDeCourse = new Intent(ModifierListeDeCourseActivity.this, MainActivity.class);
                startActivityForResult(AjouterIngredientListeDeCourse, THIS_REQUEST_CODE);
            }
        });
    }
}