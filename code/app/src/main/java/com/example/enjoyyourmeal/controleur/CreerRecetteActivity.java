package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.enjoyyourmeal.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class CreerRecetteActivity extends AppCompatActivity {

    private FloatingActionButton mButtonAjoutLigneIngredient;
    private int idEditText1 = 0, idEditText2 = 0, idSpinner = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_recette);

        ajouterLigneIngredient();

        mButtonAjoutLigneIngredient = findViewById(R.id.floatingActionButton2);

        mButtonAjoutLigneIngredient.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajouterLigneIngredient();
            }
        });
    }

    public void ajouterLigneIngredient() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.ajout_ligne_ingredient);
        LinearLayout sousLayout = new LinearLayout(this);
        sousLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layoutParams;
        layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 20, 0, 0);
        sousLayout.setLayoutParams(layoutParams);

        EditText editText1 = new EditText(this);
        editText1.setHint("ingrédient");
        editText1.setLayoutParams(new LinearLayout.LayoutParams(220, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        editText1.setId(idEditText1);
        sousLayout.addView(editText1);

        EditText editText2 = new EditText(this);
        editText2.setEms(10);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText2.setHint("quantité");
        editText2.setLayoutParams(new LinearLayout.LayoutParams(30, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        editText2.setId(idEditText2);
        sousLayout.addView(editText2);

        Spinner spinnerUnité = new Spinner(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Unité, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerUnité.setAdapter(adapter);
        spinnerUnité.setContentDescription("unités");
        spinnerUnité.setLayoutParams(new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        spinnerUnité.setId(idSpinner);
        sousLayout.addView(spinnerUnité);

        // creer ingrédient dans la bd ou liste avant nom ingr String, quantite int, unités String qui l'a créé
        idEditText1++;
        idEditText2++;
        idSpinner++;

        layout.addView(sousLayout);
    }
}


