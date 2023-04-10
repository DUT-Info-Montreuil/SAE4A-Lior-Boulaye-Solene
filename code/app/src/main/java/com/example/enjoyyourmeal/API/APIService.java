package com.example.enjoyyourmeal.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> userLogin(@Field("username") String username, @Field("password") String password);
}
