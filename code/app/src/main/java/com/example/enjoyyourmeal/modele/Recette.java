package com.example.enjoyyourmeal.modele;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Recette implements Parcelable {
    private String titre;
    private String description;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> etapes;
    private int tempsTotal, tempsRepos, tempsCuisson, tempsPrepa, nbPersonnePourRecette;
    private ArrayList<String> adapter_Ingredints_String;

    public Recette(String titre, String description, ArrayList<Ingredient> ingredients, ArrayList<String> etapes, int tempsTotal, int tempsRepos, int tempsCuisson, int tempsPrepa, int nbPersonnePourRecette) {
        this.titre = titre;
        this.description = description;
        this.ingredients = ingredients;
        this.etapes = etapes;
        this.tempsTotal = tempsTotal;
        this.tempsRepos = tempsRepos;
        this.tempsCuisson = tempsCuisson;
        this.tempsPrepa = tempsPrepa;
        this.nbPersonnePourRecette = nbPersonnePourRecette;
        this.adapter_Ingredints_String = new ArrayList<>();
        for(Ingredient ingredient : ingredients){
            String string = ingredient.getNom()+ " "+ ingredient.getQuantite();
            this.adapter_Ingredints_String.add(string);
        }
    }

    public Recette(String titre, String description, ArrayList<Ingredient> ingredients, ArrayList<String> etapes, int tempsTotal, int tempsRepos, int tempsCuisson, int tempsPrepa) {
        this.titre = titre;
        this.description = description;
        this.ingredients = ingredients;
        this.etapes = etapes;
        this.tempsTotal = tempsTotal;
        this.tempsRepos = tempsRepos;
        this.tempsCuisson = tempsCuisson;
        this.tempsPrepa = tempsPrepa;
        this.nbPersonnePourRecette = 0;
        this.adapter_Ingredints_String = new ArrayList<>();
        for(Ingredient ingredient : ingredients){
            String string = ingredient.getNom()+ " "+ ingredient.getQuantite();
            this.adapter_Ingredints_String.add(string);
        }
    }

    protected Recette(Parcel in) {
        titre = in.readString();
        description = in.readString();
        ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        etapes = in.createStringArrayList();
        tempsTotal = in.readInt();
        tempsRepos = in.readInt();
        tempsCuisson = in.readInt();
        tempsPrepa = in.readInt();
        nbPersonnePourRecette = in.readInt();
        adapter_Ingredints_String = in.createStringArrayList();
    }

    public static final Creator<Recette> CREATOR = new Creator<Recette>() {
        @Override
        public Recette createFromParcel(Parcel in) {
            return new Recette(in);
        }

        @Override
        public Recette[] newArray(int size) {
            return new Recette[size];
        }
    };

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getEtapes() {
        return etapes;
    }

    public void setEtapes(ArrayList<String> etapes) {
        this.etapes = etapes;
    }

    public int getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(int tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

    public int getTempsRepos() {
        return tempsRepos;
    }

    public void setTempsRepos(int tempsRepos) {
        this.tempsRepos = tempsRepos;
    }

    public int getTempsCuisson() {
        return tempsCuisson;
    }

    public void setTempsCuisson(int tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    public int getTempsPrepa() {
        return tempsPrepa;
    }

    public void setTempsPrepa(int tempsPrepa) {
        this.tempsPrepa = tempsPrepa;
    }

    public int getNbPersonnePourRecette() {
        return nbPersonnePourRecette;
    }

    public void setNbPersonnePourRecette(int nbPersonnePourRecette) {
        this.nbPersonnePourRecette = nbPersonnePourRecette;
    }

    public ArrayList<String> getAdapter_Ingredints_String() {
        return adapter_Ingredints_String;
    }

    public void setAdapter_Ingredints_String(ArrayList<String> adapter_Ingredints_String) {
        this.adapter_Ingredints_String = adapter_Ingredints_String;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", etapes=" + etapes +
                ", tempsTotal=" + tempsTotal +
                ", tempsRepos=" + tempsRepos +
                ", tempsCuisson=" + tempsCuisson +
                ", tempsPrepa=" + tempsPrepa +
                ", nbPersonnePourRecette=" + nbPersonnePourRecette +
                ", adapter_Ingredints_String=" + adapter_Ingredints_String +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(titre);
        parcel.writeString(description);
        parcel.writeTypedList(ingredients);
        parcel.writeStringList(etapes);
        parcel.writeInt(tempsTotal);
        parcel.writeInt(tempsRepos);
        parcel.writeInt(tempsCuisson);
        parcel.writeInt(tempsPrepa);
        parcel.writeInt(nbPersonnePourRecette);
        parcel.writeStringList(adapter_Ingredints_String);
    }
}

