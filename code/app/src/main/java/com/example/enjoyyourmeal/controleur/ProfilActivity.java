package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.enjoyyourmeal.R;

public class ProfilActivity extends AppCompatActivity {

    private Button frigoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        frigoButton = findViewById(R.id.frigo_button);
        frigoButton.setOnClickListener(new Button.OnClickListener() {

                public void onClick(View view) {
                Intent frigoActivityIntent = new Intent(ProfilActivity.this, FrigoActivity.class);
                startActivity(frigoActivityIntent);
            }
        });
    }
}