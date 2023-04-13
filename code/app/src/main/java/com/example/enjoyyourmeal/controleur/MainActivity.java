package com.example.enjoyyourmeal.controleur;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Ingredient;
import com.example.enjoyyourmeal.modele.Quantite;
import com.example.enjoyyourmeal.modele.Recette;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ImageView mImageViewLogo;
    private ImageView mImageViewProfil;
    private EditText mEditTextBarreRecherche;
    private ImageView mImageViewLoupe;
    private Button mButtonCreerRecette;
    private ImageView mImageViewRecetteJour;
    private static final int THIS_REQUEST_CODE = 42;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    private ArrayList<String> etapes = new ArrayList<>();
    private Recette mRecette;
    private Quantite quantiteFarine;
    private Quantite quantiteSucre;
    private Quantite quantiteOeufs;
    private Quantite quantiteLait;

    private FileInputStream in;

    public static String pseudoUserEnCours = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewLogo = findViewById(R.id.imageView_logo);
        mImageViewProfil = findViewById(R.id.imageView_profil);
        mEditTextBarreRecherche = findViewById(R.id.editText_recherche);
        mImageViewLoupe = findViewById(R.id.imageView_loupe);
        mButtonCreerRecette = findViewById(R.id.button_creer_recette);
        mImageViewRecetteJour = findViewById(R.id.ImageButton_recette_jour);


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

        try {
            in = openFileInput(ProfilActivity.NOM_FICHIER_UTILISATEUR_CONNECTER);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            pseudoUserEnCours = br.readLine().split(" ")[0];
        } catch (Exception e) {
            pseudoUserEnCours = "";
        }
        //sessionEnCours("session");

        mImageViewLogo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ConsultMainActivityIntent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(ConsultMainActivityIntent);
            }
        });
        
        mImageViewProfil.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ProfilActivityIntent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivityForResult(ProfilActivityIntent, THIS_REQUEST_CODE);
            }
        });
        mImageViewRecetteJour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent AfficherRecetteActivityIntent = new Intent(MainActivity.this, RecetteActivity.class);
                AfficherRecetteActivityIntent.putExtra("recette_du_jour", mRecette);
                startActivity(AfficherRecetteActivityIntent);
            }
        });

        mImageViewProfil.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (pseudoUserEnCours.isEmpty()) {
                        Intent ConnexionActivityIntent = new Intent(MainActivity.this, ConnexionActivity.class);
                        startActivity(ConnexionActivityIntent);
                    } else {
                        Intent ProfilActivityIntent = new Intent(MainActivity.this, ProfilActivity.class);
                        startActivity(ProfilActivityIntent);
                    }
                }
        });
        mButtonCreerRecette.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pseudoUserEnCours.isEmpty()){
                    Intent ConnexionActivityIntent = new Intent(MainActivity.this, ConnexionActivity.class);
                    startActivity(ConnexionActivityIntent);
                }else{
                    Intent CreerRecetteActivityIntent = new Intent(MainActivity.this, CreerRecetteActivity.class);
                    startActivity(CreerRecetteActivityIntent);
                }

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

            imageView.setClickable(true);

            layout.addView(imageView);
        }

    }






}
