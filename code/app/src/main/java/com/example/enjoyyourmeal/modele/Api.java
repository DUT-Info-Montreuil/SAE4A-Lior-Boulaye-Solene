package com.example.enjoyyourmeal.modele;

import com.example.enjoyyourmeal.controleur.ConnexionActivity;

import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    public interface LoginService extends Api {
        @FormUrlEncoded
        @POST("/login.php")
        void login(@Field("pseudo") String pseudo, @Field("motDePasse") String motDePasse, Callback<ConnexionActivity.Login> cb);

    }

}

