package com.example.enjoyyourmeal.modele;

public class Ingredient {
    private String nom;
    private Quantite mQuantite;

    public Ingredient(String n, Quantite q) {
        this.nom = nom;
        this.mQuantite = q;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Quantite getQuantite() {
        return mQuantite;
    }

    public void setQuantite(Quantite quantite) {
        mQuantite = quantite;
    }

    @Override
    public String toString() {
        return mQuantite.toString() + " " + nom;
    }



}

