package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Etape;
import com.example.enjoyyourmeal.modele.Ingredient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class EtapePrepaActivity extends AppCompatActivity {

    FloatingActionButton mAjoutLigneEtape;
    Button mBoutonfinaliserRecette;
    private int idEtape = 0;
    LinearLayout layout;
    private List<Etape> listeEtapes = new ArrayList<Etape>();
    ArrayList<Ingredient> listeIngredients = new ArrayList<Ingredient>();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etape_prepa);

        listeIngredients = getIntent().getParcelableArrayListExtra("listeIngredients");

        layout = (LinearLayout) findViewById(R.id.ajout_ligne_étape);

        if(listeIngredients == null) {
            Log.e("EtapePrepaActivity", "La liste d'ingrédients est nulle");
        } else {
            Log.d("Touvabien","TOUVABIEN etape prepa");
        }
        ajouterLigneEtape();

        mAjoutLigneEtape = findViewById(R.id.fab_plus_etape);
        mBoutonfinaliserRecette = findViewById(R.id.button_finaliser);

        mAjoutLigneEtape.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ajouterLigneEtape();
            }
        });

        mBoutonfinaliserRecette.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < layout.getChildCount(); i++) {
                    LinearLayout subLayout = (LinearLayout) layout.getChildAt(i);

                    TextView text = subLayout.findViewById(1);
                    EditText editext = subLayout.findViewById(2);

                    int numEtape = i;

                    String description = editext.getText().toString();

                    // Créer l'objet ingrédient et l'ajouter à la liste
                    Etape etape = new Etape(numEtape,description);
                    listeEtapes.add(etape);
                }
                Intent intent = new Intent(EtapePrepaActivity.this, EtapeFinaleActivity.class);
                intent.putParcelableArrayListExtra("IngredientsListe", (ArrayList<Ingredient>) listeIngredients);
                intent.putParcelableArrayListExtra("EtapesListe", (ArrayList<Etape>) listeEtapes);
                startActivity(intent);
            }
        });
    }
    @SuppressLint("ResourceType")
    public void ajouterLigneEtape() {
        LinearLayout sousLayout = new LinearLayout(this);
        sousLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layoutParams;
        layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 20, 0, 0);
        sousLayout.setLayoutParams(layoutParams);

        // Ajout du numéro de l'étape
        TextView textViewEtape = new TextView(this);
        textViewEtape.setText("Etape " + (idEtape + 1));
        textViewEtape.setBackgroundResource(R.drawable.border); // Ajout d'un encadrement
        textViewEtape.setPadding(10, 10, 10, 10); // Ajout d'une marge intérieure
        textViewEtape.setId(1);
        sousLayout.addView(textViewEtape);

        EditText editText = new EditText(this);
        editText.setHint("");
        editText.setLayoutParams(new LinearLayout.LayoutParams(220, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
        editText.setId(2);
        sousLayout.addView(editText);

        idEtape++;
        layout.addView(sousLayout);
    }


}