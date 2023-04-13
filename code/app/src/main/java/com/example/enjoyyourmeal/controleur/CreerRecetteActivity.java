package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Ingredient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CreerRecetteActivity extends AppCompatActivity {

    private FloatingActionButton mButtonAjoutLigneIngredient;
    Button mEtapePrepa;

    LinearLayout layout;

    private List<Ingredient> listeIngredients;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_recette);

        layout = findViewById(R.id.ajout_ligne_ingredient);

        listeIngredients = new ArrayList<>();
        mButtonAjoutLigneIngredient = findViewById(R.id.floatingActionButton2);
        mEtapePrepa = findViewById(R.id.button_etape_prepa);

        ajouterLigneIngredient();

        mButtonAjoutLigneIngredient.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajouterLigneIngredient();
            }
        });

        mEtapePrepa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < layout.getChildCount(); i++) {
                    LinearLayout subLayout = (LinearLayout) layout.getChildAt(i);

                    EditText editText1 = subLayout.findViewById(1);
                    EditText editText2 = subLayout.findViewById(2);
                    Spinner spinnerUnité = subLayout.findViewById(3);

                    String nomIngredient = editText1.getText().toString();
                    int quantiteIngredient;
                    if (!TextUtils.isEmpty(editText2.getText().toString())) {
                        quantiteIngredient = Integer.parseInt(editText2.getText().toString());
                    } else {
                        quantiteIngredient = 0;
                    }
                    String uniteIngredient = spinnerUnité.getSelectedItem().toString();

                    // Créer l'objet ingrédient et l'ajouter à la liste
                    Ingredient ingredient = new Ingredient(nomIngredient, quantiteIngredient, uniteIngredient);
                    listeIngredients.add(ingredient);
                }


                Intent intent = new Intent(CreerRecetteActivity.this, EtapePrepaActivity.class);
                intent.putParcelableArrayListExtra("listeIngredients", (ArrayList<Ingredient>) listeIngredients);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("ResourceType")
    public void ajouterLigneIngredient() {
        LinearLayout sousLayout = new LinearLayout(this);
        sousLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 20, 0, 0);
        sousLayout.setLayoutParams(layoutParams);

        EditText editText1 = new EditText(this);
        editText1.setHint("ingrédient");
        editText1.setLayoutParams(new LinearLayout.LayoutParams(220, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        editText1.setId(1);
        editText1.setBackgroundResource(R.drawable.border);
        editText1.setPadding(10, 10, 10, 10);
        sousLayout.addView(editText1);

        EditText editText2 = new EditText(this);
        editText2.setEms(10);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText2.setHint("quantité");
        editText2.setLayoutParams(new LinearLayout.LayoutParams(30, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        editText2.setId(2);
        editText2.setBackgroundResource(R.drawable.border);
        editText2.setPadding(10, 10, 10, 10);
        sousLayout.addView(editText2);

        Spinner spinnerUnité = new Spinner(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Unité, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerUnité.setAdapter(adapter);
        spinnerUnité.setContentDescription("unités");
        spinnerUnité.setLayoutParams(new LinearLayout.LayoutParams(150, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        spinnerUnité.setId(3);
        sousLayout.addView(spinnerUnité);

        layout.addView(sousLayout);
    }


}


