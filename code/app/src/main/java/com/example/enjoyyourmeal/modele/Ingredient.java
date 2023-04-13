package com.example.enjoyyourmeal.modele;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Ingredient implements Parcelable {
    private String nom;
    private Quantite mQuantite;

    public Ingredient(String n, Quantite q) {
        this.nom = nom;
        this.mQuantite = q;
    }

    protected Ingredient(Parcel in) {
        nom = in.readString();
        mQuantite = in.readParcelable(Quantite.class.getClassLoader());
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nom);
        parcel.writeParcelable(mQuantite, i);
    }
}

