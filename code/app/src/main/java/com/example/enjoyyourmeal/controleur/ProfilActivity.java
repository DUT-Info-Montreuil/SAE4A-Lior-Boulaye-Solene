package com.example.enjoyyourmeal.controleur;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.enjoyyourmeal.R;
import com.example.enjoyyourmeal.modele.ListeDeCourse;

public class ProfilActivity extends AppCompatActivity {


    private Button frigoButton;
    private Button listeDeCourse;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        frigoButton = findViewById(R.id.frigo_button);
        listeDeCourse = (Button) findViewById(R.id.liste_de_course_button);
        frigoButton.setOnClickListener(new Button.OnClickListener() {

                public void onClick(View view) {
                Intent frigoActivityIntent = new Intent(ProfilActivity.this, FrigoActivity.class);
                startActivity(frigoActivityIntent);
            }
        });
        listeDeCourse.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View view) {
                Intent ListeCourseActivityIntent = new Intent(ProfilActivity.this, AfficherListeDeCourseActivity.class);
                startActivity(ListeCourseActivityIntent);
            }
        });
    }
}