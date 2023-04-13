package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enjoyyourmeal.API.APIService;
import com.example.enjoyyourmeal.API.ApiClient;
import com.example.enjoyyourmeal.API.RecetteResponse;
import com.example.enjoyyourmeal.API.RecetteResponse;
import com.example.enjoyyourmeal.R;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MesRecetteActivity extends AppCompatActivity {

    private ListView mesRecettesListView;
    private List<RecetteResponse> recettes;
    private List<String> titreRecette;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_recette);
        recettes = new ArrayList<>();
        titreRecette  = new ArrayList<>();
        mesRecettesListView = findViewById(R.id.mes_recette_listView);
        recupererMesRecette();

    }


    private void recupererMesRecette(){
        APIService apiService = ApiClient.getClient().create(APIService.class);
        Call<List<RecetteResponse>> call = apiService.getRecetteUser("recette", MainActivity.pseudoUserEnCours);
        call.enqueue(new Callback<List<RecetteResponse>>() {
            @Override
            public void onResponse(Call<List<RecetteResponse>> call, Response<List<RecetteResponse>> response) {
                if(response.isSuccessful()){
                    recettes.addAll(response.body());
                    remplirListView();
                    Toast.makeText(MesRecetteActivity.this, "Réussite", Toast.LENGTH_LONG).show();
                }
                else {
                    Log.e("API_Error", "Echec de la commande");
                }
            }

            @Override
            public void onFailure(Call<List<RecetteResponse>> call, Throwable t) {
                Log.e("API_ERROR", "Erreur de connexion à l'API onfailure", t);
            }
        });


    }

    public void remplirListView(){
        if(!recettes.isEmpty()) {
            for (RecetteResponse recette : recettes){
                titreRecette.add(recette.getTitre());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>
                    (this, android.R.layout.simple_list_item_1, android.R.id.text1, titreRecette);
            mesRecettesListView.setAdapter(adapter);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder
                    .setTitle("Vous n'avez pas de recette")
                    .setMessage("cliquer ci-dessous pour créer une recette")
                    .setPositiveButton("Suivant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(MesRecetteActivity.this, CreerRecetteActivity.class));
                        }
                    }).create().show();
        }
    }
}