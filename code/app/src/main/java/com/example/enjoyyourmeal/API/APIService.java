package com.example.enjoyyourmeal.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @FormUrlEncoded
    @POST("index.php")
    Call<LoginResponse> userLogin(@Field("username") String username, @Field("password") String password, @Field("connexion") String connexion);

    @FormUrlEncoded
    @POST("index.php")
    Call<LoginResponse> userSignIn(@Field("username") String username, @Field("password") String password, @Field("inscription") String inscription);

    @FormUrlEncoded
    @POST("index.php")
    Call<SessionResponse> initSession(@Field("session") String session);

    @FormUrlEncoded
    @POST("index.php")
    Call<SessionResponse> deconnexion(@Field("deconnexion") String deconnexion);

    @FormUrlEncoded
    @POST("index.php")
    Call<CreerRecetteResponse> ajoutIngredient(
            @Field("creerIngredient") String creerIngredient,
            @Field("nomIngredient") String nomIngredient,
            @Field("unite") String unite,
            @Field("nombre") int nombre,
            @Field("idRecetteIngr") int idRecette);

    @FormUrlEncoded
    @POST("index.php")
    Call<CreerRecetteResponse> ajoutEtapePrepa(
            @Field("creerEtapePrep") String creerEtapePrep,
            @Field("descriptionEtape") String descriptionEtape,
            @Field("ordre") int ordre,
            @Field("idRecettePrep") int idRecette);

    @FormUrlEncoded
    @POST("index.php")
    Call<CreerRecetteResponse> ajoutRecette(
            @Field("creerRecette") String creerRecette,
            @Field("nomRecette") String nom,
            @Field("descriptionRecette") String description,
            @Field("pseudo") String pseudo,
            @Field("tempPrep") int tempPrep,
            @Field("tempCuisson") int tempCuisson,
            @Field("tempRepos") int tempRepos);
}

