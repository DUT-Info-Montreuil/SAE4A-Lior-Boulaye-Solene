package com.example.enjoyyourmeal.modele;

import java.util.ArrayList;

public class Recette {
    private String titre;
    private String description;
    private ArrayList<Ingredient> mIngredients;
    private ArrayList<String> etapes;
    private int tempsTotal, tempsRepos, tempsCuisson, tempsPrepa, nbPersonnePourRecette;
    private ArrayList<String> adapter_Ingredints_String;

    public Recette(String titre, String description, ArrayList<Ingredient> ingredients, ArrayList<String> etapes, int tempsTotal, int tempsRepos, int tempsCuisson, int tempsPrepa, int nbPersonnePourRecette) {
        this.titre = titre;
        this.description = description;
        mIngredients = ingredients;
        this.etapes = etapes;
        this.tempsTotal = tempsTotal;
        this.tempsRepos = tempsRepos;
        this.tempsCuisson = tempsCuisson;
        this.tempsPrepa = tempsPrepa;
        this.nbPersonnePourRecette = nbPersonnePourRecette;
        this.adapter_Ingredints_String = new ArrayList<>();
        for(Ingredient ingredient : mIngredients){
            String string = ingredient.getNom()+ " "+ ingredient.getQuantite();
            this.adapter_Ingredints_String.add(string);
        }
    }

    public Recette(String titre, String description, ArrayList<Ingredient> ingredients, ArrayList<String> etapes, int tempsTotal, int tempsRepos, int tempsCuisson, int tempsPrepa) {
        this.titre = titre;
        this.description = description;
        mIngredients = ingredients;
        this.etapes = etapes;
        this.tempsTotal = tempsTotal;
        this.tempsRepos = tempsRepos;
        this.tempsCuisson = tempsCuisson;
        this.tempsPrepa = tempsPrepa;
        this.adapter_Ingredints_String = new ArrayList<>();
        for(Ingredient ingredient : mIngredients){
            String string = ingredient.getNom()+ " "+ ingredient.getQuantite();
            this.adapter_Ingredints_String.add(string);
        }
    }

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
        return mIngredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        mIngredients = ingredients;
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
}
