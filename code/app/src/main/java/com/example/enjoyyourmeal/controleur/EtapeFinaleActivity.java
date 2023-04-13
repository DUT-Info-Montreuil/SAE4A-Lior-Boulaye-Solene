package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enjoyyourmeal.API.APIService;
import com.example.enjoyyourmeal.API.ApiClient;
import com.example.enjoyyourmeal.API.CreerRecetteResponse;
import com.example.enjoyyourmeal.API.LoginResponse;
import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Etape;
import com.example.enjoyyourmeal.modele.Ingredient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EtapeFinaleActivity extends AppCompatActivity {

    TextView text1,text2,text3,text4,text5;
    EditText edit1,edit2,edit3,edit4,edit5;

    Button mCreerRecette;
    LinearLayout layout;

    private List<Etape> listeEtapes = new ArrayList<Etape>();
    private List<Ingredient> listeIngredients = new ArrayList<Ingredient>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etape_finale);
        layout = findViewById(R.id.linear_du_scroll);
        text1 = findViewById(R.id.Text1);
        text2 = findViewById(R.id.Text2);
        text3 = findViewById(R.id.Text3);
        text4 = findViewById(R.id.Text4);
        text5 = findViewById(R.id.Text5);

        edit1 = findViewById(R.id.editTextNomRecette);
        edit2 = findViewById(R.id.editTextDescription);
        edit3 = findViewById(R.id.temp_prepa);
        edit4 = findViewById(R.id.temp_cuisson);
        edit5 = findViewById(R.id.temp_repos);
        mCreerRecette = findViewById(R.id.button_creer);

        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof EditText) {
                ((EditText) child).setBackgroundResource(R.drawable.border);
                ((EditText) child).setPadding(10, 10, 10, 10);
            }
        }

        listeIngredients = getIntent().getParcelableArrayListExtra("IngredientsListe");
        listeEtapes = getIntent().getParcelableArrayListExtra("EtapesListe");

        Log.d("app",listeIngredients.get(0).getNom());
        //Log.d("app",listeIngredients.get(1).getNom());
        Log.d("app",listeEtapes.get(0).getDescriptionEtape());
        //Log.d("app",listeEtapes.get(1).getDescriptionEtape());

        mCreerRecette.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < layout.getChildCount(); i++) {
                    View child = layout.getChildAt(i);
                    if (child instanceof EditText) {
                        if (((EditText) child).getText().toString().isEmpty()) {
                            ((EditText) child).setError("Entrez tous les champs");
                        }
                    }
                }
                String texte1 = edit1.getText().toString();
                String texte2 = edit2.getText().toString();
                String texte3 = edit3.getText().toString();
                String texte4 = edit4.getText().toString();
                String texte5 = edit5.getText().toString();

                int entier3 = Integer.parseInt(texte3);
                int entier4 = Integer.parseInt(texte4);
                int entier5 = Integer.parseInt(texte5);


                ajouterRecette(texte1,texte2,"boul",entier3,entier4,entier5);
            }
        });
    }

    public void ajouterRecette(String nom,String description,String pseudo,int tempPrep,int tempCuisson,int tempRepos) {
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<CreerRecetteResponse> call = apiService.ajoutRecette("creerRecette",nom,description,pseudo,tempPrep,tempCuisson,tempRepos);

        call.enqueue(new Callback<CreerRecetteResponse>() {
            @Override
            public void onResponse(Call<CreerRecetteResponse> call, Response<CreerRecetteResponse> response) {
                if (response.isSuccessful()) {
                    CreerRecetteResponse creerRecetteResponse = response.body();
                    if (creerRecetteResponse.isSuccess()) {
                        // Traitement de la réponse de l'API en cas de succès
                        Toast.makeText(EtapeFinaleActivity.this, creerRecetteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        // Traitement de l'erreur en cas de inscription échouée
                        Toast.makeText(EtapeFinaleActivity.this, creerRecetteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    // Traitement de l'erreur en cas d'échec de la connexion à l'API
                    Toast.makeText(EtapeFinaleActivity.this, "Erreur de connexion à l'API recette", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CreerRecetteResponse> call, Throwable t) {
                // Traitement de l'erreur en cas d'échec de la connexion à l'API
                Toast.makeText(EtapeFinaleActivity.this, "Erreur de recette on failure", Toast.LENGTH_SHORT) .show();
            }
        });
    }

    public void ajouterIngredient(String nom,String unite,int nombre,int idRecette) {
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<CreerRecetteResponse> call = apiService.ajoutIngredient("creerIngredient",nom,unite,nombre,idRecette);

        call.enqueue(new Callback<CreerRecetteResponse>() {
            @Override
            public void onResponse(Call<CreerRecetteResponse> call, Response<CreerRecetteResponse> response) {
                if (response.isSuccessful()) {
                    CreerRecetteResponse creerRecetteResponse = response.body();
                    if (creerRecetteResponse.isSuccess()) {
                        // Traitement de la réponse de l'API en cas de succès
                        Toast.makeText(EtapeFinaleActivity.this, creerRecetteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        // Traitement de l'erreur en cas de inscription échouée
                        Toast.makeText(EtapeFinaleActivity.this, creerRecetteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    // Traitement de l'erreur en cas d'échec de la connexion à l'API
                    Toast.makeText(EtapeFinaleActivity.this, "Erreur de connexion à l'API ingr", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CreerRecetteResponse> call, Throwable t) {
                // Traitement de l'erreur en cas d'échec de la connexion à l'API
                Toast.makeText(EtapeFinaleActivity.this, "Erreur ingr on failure", Toast.LENGTH_SHORT) .show();
            }
        });
    }

    public void ajouterEtape(String description,int ordre,int idRecette) {
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<CreerRecetteResponse> call = apiService.ajoutEtapePrepa("creerEtapePrep",description,ordre,idRecette);

        call.enqueue(new Callback<CreerRecetteResponse>() {
            @Override
            public void onResponse(Call<CreerRecetteResponse> call, Response<CreerRecetteResponse> response) {
                if (response.isSuccessful()) {
                    CreerRecetteResponse creerRecetteResponse = response.body();
                    if (creerRecetteResponse.isSuccess()) {
                        // Traitement de la réponse de l'API en cas de succès
                        Toast.makeText(EtapeFinaleActivity.this, creerRecetteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        // Traitement de l'erreur en cas de inscription échouée
                        Toast.makeText(EtapeFinaleActivity.this, creerRecetteResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    // Traitement de l'erreur en cas d'échec de la connexion à l'API
                    Toast.makeText(EtapeFinaleActivity.this, "Erreur de connexion à l'API ingr", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<CreerRecetteResponse> call, Throwable t) {
                // Traitement de l'erreur en cas d'échec de la connexion à l'API
                Toast.makeText(EtapeFinaleActivity.this, "Erreur ingr on failure", Toast.LENGTH_SHORT) .show();
            }
        });
    }

    public static String getEditText(EditText editText){
        return editText.getText().toString().trim();
    }
}