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
}

