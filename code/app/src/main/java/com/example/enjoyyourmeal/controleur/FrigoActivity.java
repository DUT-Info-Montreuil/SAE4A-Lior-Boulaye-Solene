package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.Ingredient;

public class FrigoActivity extends AppCompatActivity {

    private TextView mFrigoVideErrorTextView, lien_remplir_Ingrediant;
    private TableLayout mTableLayout;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frigo);
        mFrigoVideErrorTextView = findViewById(R.id.FrigoVideErrorTextView);
        lien_remplir_Ingrediant = findViewById(R.id.Lien_remplir_Ingrediant);
        mTableLayout = findViewById(R.id.tableFrigo);
        lien_remplir_Ingrediant.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProfilActivityIntent = new Intent(FrigoActivity.this, ProfilActivity.class);
                startActivity(ProfilActivityIntent);
            }
        });
        remplirTableau();
    }

    private void remplirTableau() {
        //TODO Appeler l'API pour récupérer le frigo
        //TODO convertir l'ARRAYLIST en un TREESET pour avoir les ingrediant par ordre alaphabetic
        if(false){
            mFrigoVideErrorTextView.setVisibility(View.VISIBLE);
            lien_remplir_Ingrediant.setVisibility(View.VISIBLE);
        }
        else {
            mFrigoVideErrorTextView.setVisibility(View.INVISIBLE);
            lien_remplir_Ingrediant.setVisibility(View.INVISIBLE);
            //mTableLayout.removeAllViewsInLayout();
            for(int i = 0 ; i<5 ; i++){
                TableRow ligne = new TableRow(FrigoActivity.this);
                ligne.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT));
                for(int j = 0 ; j<15 ; j++ ) {
                    TextView textView = new TextView(FrigoActivity.this);
                    textView.setText(/*mettreEnFormeString(*/"5 cuilliere à soupe de Vinaigre balsamique") ;//);
                    textView.setTextSize(20);
                    textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    textView.setPadding(50, 50, 50, 50);
                    ligne.addView(textView);
                }
                this.mTableLayout.addView(ligne);

            }
        }
    }

    private String mettreEnFormeString(Ingredient ingrédiant){
        //return ingrédiant.getQuantite().toString() + "\n" + ingrédiant.getNom();
        return null;
    }


}