package com.example.enjoyyourmeal.modele;

import android.os.Parcel;
import android.os.Parcelable;

public class Etape implements Parcelable {
    private int numeroEtape;
    private String descriptionEtape;
    
    public  Etape (int numeroEtape, String descriptionEtape){
        this.numeroEtape = numeroEtape;
        this.descriptionEtape = descriptionEtape;
    }

    protected Etape(Parcel in) {
        numeroEtape = in.readInt();
        descriptionEtape = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(numeroEtape);
        dest.writeString(descriptionEtape);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Etape> CREATOR = new Creator<Etape>() {
        @Override
        public Etape createFromParcel(Parcel in) {
            return new Etape(in);
        }

        @Override
        public Etape[] newArray(int size) {
            return new Etape[size];
        }
    };

    public int getNumeroEtape() {
        return numeroEtape;
    }

    public void setNumeroEtape(int numeroEtape) {
        this.numeroEtape = numeroEtape;
    }

    public String getDescriptionEtape() {
        return descriptionEtape;
    }

    public void setDescriptionEtape(String descriptionEtape) {
        this.descriptionEtape = descriptionEtape;
    }
}
