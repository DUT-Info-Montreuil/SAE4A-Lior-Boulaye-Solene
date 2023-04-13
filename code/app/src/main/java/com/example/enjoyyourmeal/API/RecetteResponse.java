package com.example.enjoyyourmeal.API;

import com.google.gson.annotations.SerializedName;

public class RecetteResponse {

    @SerializedName("id_recette")
    private int id;

    @SerializedName("titre")
    private String titre;

    @SerializedName("description")
    private String description;

    @SerializedName("temps_prep")
    private int temps_prep;

    @SerializedName("temps_cuisson")
    private int temps_cuisson;

    @SerializedName("temps_repos")
    private int temps_repos;


    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getTemps_prep() {
        return temps_prep;
    }

    public int getTemps_cuisson() {
        return temps_cuisson;
    }

    public int getTemps_repos() {
        return temps_repos;
    }
}
