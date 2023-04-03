package com.example.enjoyyourmeal.modele;

public class Quantite {
    private String unite;
    private int quantite;

    public Quantite(String n, int u) {
        this.unite =n;
        this.quantite =u;
    }
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

}
