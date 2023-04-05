package com.example.enjoyyourmeal.modele;

import java.util.ArrayList;

public class ListeDeCourse {
    private ArrayList<Ingredient> Ingredients;

    private ArrayList<String> adapter_Ingredients_String;

    public ListeDeCourse(ArrayList<Ingredient> ingredients) {
        Ingredients = ingredients;
        this.adapter_Ingredients_String = new ArrayList<>();
        for(Ingredient ingredient : Ingredients){
            String string = ingredient.getNom()+ " "+ ingredient.getQuantite();
            this.adapter_Ingredients_String.add(string);
        }
    }
    public ArrayList<String> getAdapter_Ingredients_String() {
        return adapter_Ingredients_String;
    }

    public void setAdapter_Ingredients_String(ArrayList<String> adapter_Ingredients_String) {
        this.adapter_Ingredients_String = adapter_Ingredients_String;
    }
    public ArrayList<Ingredient> getIngredients() {
        return Ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        Ingredients = ingredients;
    }

    public void AjouterIngredientDansLaListe(Ingredient ingredient){
        this.Ingredients.add(ingredient);
    }

    public void SupprimerIngredientDeLaListe(Ingredient ingredient){
        this.Ingredients.remove(ingredient);
    }

    public void AjouterListeIngredientDansLaListe(ArrayList<Ingredient> listeIngredients){
        for(Ingredient i : listeIngredients){
            this.Ingredients.add(i);
        }
    }

    public void SupprimerListeIngredientDeLaListe(ArrayList<Ingredient> listeIngredients){
        for(Ingredient i : listeIngredients){
            this.Ingredients.remove(i);
        }
    }

    @Override
    public String toString() {
        return "ListeDeCourse " +
                "Ingredients=" + adapter_Ingredients_String;
    }
}
