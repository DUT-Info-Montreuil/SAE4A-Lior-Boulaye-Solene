package com.example.enjoyyourmeal.modele;

import android.os.Parcel;
import android.os.Parcelable;


import androidx.annotation.NonNull;

import java.io.Serializable;




public class Ingredient implements Parcelable {
    private String nom;
    private int quantite;
    private String unite;
    private Quantite mQuantite;


    public Ingredient(String nom, int quantite, String unite) {
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
    }
    public Ingredient(String nom, Quantite quantite) {
        this.nom = nom;
        this.mQuantite = quantite;
    }
    protected Ingredient(Parcel in) {
        nom = in.readString();
        mQuantite = in.readParcelable(Quantite.class.getClassLoader());

        quantite = in.readInt();
        unite = in.readString();
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



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeParcelable(mQuantite, i);
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
