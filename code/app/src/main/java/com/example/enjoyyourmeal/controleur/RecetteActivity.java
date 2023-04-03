package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Ingredient;
import com.example.enjoyyourmeal.modele.Quantite;
import com.example.enjoyyourmeal.modele.Recette;

import java.io.Serializable;
import java.util.ArrayList;

public class RecetteActivity extends AppCompatActivity {

    private ImageButton flecheRetour;
    private EditText nomRecette;
    private EditText editText_tempsTotal;
    private EditText editText_tempsPrepa;
    private EditText editText_tempsCuisson;
    private EditText editText_tempsRepos;
    private EditText mEditTextTime_tempsTotal;
    private EditText mEditTextTime_tempsPrepa;
    private EditText mEditTextTime_tempsCuisson;
    private EditText mEditTextTime_tempsRepos;
    private EditText mEditText_ingredients;
    private ListView mListView_ingredients;
    private Button mButton_commencerRecette;
    private static final int THIS_REQUEST_CODE = 42;
    private ArrayList<Ingredient> mIngredients;
    private Ingredient ing1, ing2, ing3;
    private Quantite mQuantite = new Quantite("unite", 1);
    private ArrayList<String> etapes;
    private Recette recette;
    private ArrayAdapter<String> mAdapter_ingredients;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        mIngredients = new ArrayList<>();
        ing1 = new Ingredient("ing1", mQuantite);
        ing2 = new Ingredient("ing2", mQuantite);
        ing3 = new Ingredient("ing3", mQuantite);
        mIngredients.add(ing1);
        mIngredients.add(ing2);
        mIngredients.add(ing3);
        etapes = new ArrayList<>();
        etapes.add("premiere etape");
        etapes.add("deuxieme etapes");
        recette = new Recette("recette","description",mIngredients,etapes,30,10,5,15,1);

        flecheRetour = findViewById(R.id.flecheRetour);
        nomRecette = findViewById(R.id.nomRecette);
        editText_tempsTotal = findViewById(R.id.editText_tempsTotal);
        editText_tempsPrepa = findViewById(R.id.editText_tempsPrepa);
        editText_tempsCuisson = findViewById(R.id.editText_tempsCuisson);
        editText_tempsRepos = findViewById(R.id.editText_tempsRepos);
        mEditTextTime_tempsTotal = findViewById(R.id.editTextTime_tempsTotal);
        mEditTextTime_tempsPrepa = findViewById(R.id.editTextTime_tempsPrepa);
        mEditTextTime_tempsCuisson = findViewById(R.id.editTextTime_tempsCuisson);
        mEditTextTime_tempsRepos = findViewById(R.id.editTextTime_tempsRepos);
        mEditText_ingredients = findViewById(R.id.editText_ingredients);
        mListView_ingredients = findViewById(R.id.listIngredients);
        mButton_commencerRecette = findViewById(R.id.commencerRecette);

        mAdapter_ingredients = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,recette.getAdapter_Ingredints_String());
        mListView_ingredients.setAdapter(mAdapter_ingredients);

        flecheRetour.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivityIntent = new Intent(RecetteActivity.this, MainActivity.class);
                startActivityForResult(MainActivityIntent, THIS_REQUEST_CODE);
            }
        });

        mButton_commencerRecette.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent EtapeRectteActivityIntent = new Intent(RecetteActivity.this, EtapeRecetteActivity.class);
                EtapeRectteActivityIntent.putExtra("recette", (Serializable) recette);
                startActivityForResult(EtapeRectteActivityIntent, THIS_REQUEST_CODE);
            }
        });
    }
}