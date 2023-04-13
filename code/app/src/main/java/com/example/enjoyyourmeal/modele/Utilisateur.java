package com.example.enjoyyourmeal.modele;

public class Utilisateur {

    private static Utilisateur instance;
    private String pseudo;

    private Utilisateur(String pseudo) {
        this.pseudo = pseudo;
    }

    public static Utilisateur getInstance(String pseudo) {
        if (instance == null) {
            instance = new Utilisateur(pseudo);
        }
        return instance;
    }
    public static void deconnexion() {
        instance = null;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
