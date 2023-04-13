package com.example.enjoyyourmeal.modele;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable {
    private String nom;
    private int quantite;
    private String unite;

    public Ingredient(String nom, int quantite, String unite) {
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
    }

    protected Ingredient(Parcel in) {
        nom = in.readString();
        quantite = in.readInt();
        unite = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeInt(quantite);
        dest.writeString(unite);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
