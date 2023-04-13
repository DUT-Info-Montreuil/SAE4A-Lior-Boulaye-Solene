package com.example.enjoyyourmeal.modele;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Quantite implements Parcelable {
    private String unite;
    private int quantite;

    public Quantite(String n, int u) {
        this.unite =n;
        this.quantite =u;
    }

    protected Quantite(Parcel in) {
        unite = in.readString();
        quantite = in.readInt();
    }

    public static final Creator<Quantite> CREATOR = new Creator<Quantite>() {
        @Override
        public Quantite createFromParcel(Parcel in) {
            return new Quantite(in);
        }

        @Override
        public Quantite[] newArray(int size) {
            return new Quantite[size];
        }
    };

    public String getUnite() {
        return unite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public String toString(){
        return quantite + " " + unite;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(unite);
        parcel.writeInt(quantite);
    }
}

