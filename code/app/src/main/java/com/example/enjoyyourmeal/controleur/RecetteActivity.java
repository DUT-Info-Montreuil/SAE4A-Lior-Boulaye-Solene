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
import android.os.Bundle;
import android.widget.TextView;

public class RecetteActivity extends AppCompatActivity {

    private ImageButton flecheRetour;
    private TextView nomRecette;
    private TextView editText_tempsTotal;
    private TextView editText_tempsPrepa;
    private TextView editText_tempsCuisson;
    private TextView editText_tempsRepos;
    private TextView mEditTextTime_tempsTotal;
    private TextView mEditTextTime_tempsPrepa;
    private TextView mEditTextTime_tempsCuisson;
    private TextView mEditTextTime_tempsRepos;
    private TextView mEditText_ingredients;
    private ListView mListView_ingredients;
    private Button mButton_commencerRecette;
    private static final int THIS_REQUEST_CODE = 42;
    private ArrayList<Ingredient> mIngredients;
    private Ingredient ing1, ing2, ing3;
    private Quantite mQuantite = new Quantite("unite", 1);
    private ArrayList<String> etapes;
    private Recette recette;
    private ArrayAdapter<String> mAdapter_ingredients;
    Intent intent;

    private Recette mRecette;
    private Quantite quantiteFarine;
    private Quantite quantiteSucre;
    private Quantite quantiteOeufs;
    private Quantite quantiteLait;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_recette_activity);

        mIngredients = new ArrayList<>();
        //ing1 = new Ingredient("ing1", mQuantite);
        //ing2 = new Ingredient("ing2", mQuantite);
        //ing3 = new Ingredient("ing3", mQuantite);
        mIngredients.add(ing1);
        mIngredients.add(ing2);
        mIngredients.add(ing3);
        etapes = new ArrayList<>();
        etapes.add("premiere etape");
        etapes.add("deuxieme etapes");
        recette = new Recette("recette","description",mIngredients,etapes,30,10,5,15,1);

        flecheRetour = findViewById(R.id.ImageButton_retour);
        nomRecette = findViewById(R.id.nomRecette);
        editText_tempsTotal = findViewById(R.id.textView_tempsTotal);
        editText_tempsPrepa = findViewById(R.id.textView_tempsPrepa);
        editText_tempsCuisson = findViewById(R.id.textView_tempsCuisson);
        editText_tempsRepos = findViewById(R.id.textText_tempsRepos);
        mEditTextTime_tempsTotal = findViewById(R.id.textTextTime_tempsTotal);
        mEditTextTime_tempsPrepa = findViewById(R.id.textTextTime_tempsPrepa);
        mEditTextTime_tempsCuisson = findViewById(R.id.textTextTime_tempsCuisson);
        mEditTextTime_tempsRepos = findViewById(R.id.textTextTime_tempsRepos);
        mEditText_ingredients = findViewById(R.id.textView_ingredient);
        mListView_ingredients = findViewById(R.id.listeView_ingredients);
        mButton_commencerRecette = findViewById(R.id.button_commencer_recette);

        ingredients = new ArrayList<>();
        quantiteFarine = new Quantite("g", 200);
        quantiteSucre = new Quantite("g", 100);
        quantiteOeufs = new Quantite("", 2);
        quantiteLait = new Quantite("ml", 250);
        ingredients.add(new Ingredient("Farine", quantiteFarine));
        ingredients.add(new Ingredient("Sucre", quantiteSucre));
        ingredients.add(new Ingredient("Oeufs", quantiteOeufs));
        ingredients.add(new Ingredient("Lait", quantiteLait));
        etapes.add("Mélanger la farine et le sucre dans un saladier.");
        etapes.add("Ajouter les œufs et le lait, et bien mélanger jusqu'à obtention d'une pâte lisse.");
        etapes.add("Faire chauffer une poêle antiadhésive et y verser une petite louche de pâte.");
        etapes.add("Cuire la crêpe des deux côtés jusqu'à ce qu'elle soit dorée.");
        mRecette = new Recette("Crêpes", "Délicieuses crêpes pour le petit déjeuner", ingredients,
                etapes, 20, 0, 10, 10, 4);

        intent = getIntent();


        if (intent != null && intent.hasExtra("recette_du_jour")){

            //recette = (Recette) intent.getParcelableExtra("recette_du_jour"); // Récupérez l'objet à partir de l'intent avec la clé

            // Récupérer les valeurs des champs de saisie
            //String nom1 ="recette";
            //nomRecette.setText(nom1);
            /*
            nomRecette.setText(recette.getTitre());
            String nom = nomRecette.getText().toString();
            int tempsTotal = Integer.parseInt(editText_tempsTotal.getText().toString());
            int tempsPrepa = Integer.parseInt(editText_tempsPrepa.getText().toString());
            int tempsCuisson = Integer.parseInt(editText_tempsCuisson.getText().toString());
            int tempsRepos = Integer.parseInt(editText_tempsRepos.getText().toString());

            // Mettre à jour les valeurs de la recette
            recette.setTitre(nom);
            recette.setTempsTotal(tempsTotal);
            recette.setTempsPrepa(tempsPrepa);
            recette.setTempsCuisson(tempsCuisson);
            recette.setTempsRepos(tempsRepos);
*/
            //nomRecette.setText(recette.getTitre());

           // mEditTextTime_tempsTotal.setText(recette.getTempsTotal());
           // mEditTextTime_tempsPrepa.setText(recette.getTempsPrepa());
           // mEditTextTime_tempsCuisson.setText(recette.getTempsCuisson());
           // mEditTextTime_tempsRepos.setText(recette.getTempsRepos());

            mAdapter_ingredients = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,recette.getAdapter_Ingredints_String());
            mListView_ingredients.setAdapter(mAdapter_ingredients);
            mAdapter_ingredients.notifyDataSetChanged();
        }

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
                EtapeRectteActivityIntent.putExtra("recette_du_jour_etape", recette);
               // EtapeRectteActivityIntent.putExtra("recette", (Serializable) recette);
                startActivityForResult(EtapeRectteActivityIntent, THIS_REQUEST_CODE);
                startActivity(EtapeRectteActivityIntent);
            }
        });
    }
}