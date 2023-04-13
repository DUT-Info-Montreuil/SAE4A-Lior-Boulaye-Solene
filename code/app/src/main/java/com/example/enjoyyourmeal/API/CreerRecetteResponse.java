package com.example.enjoyyourmeal.API;

import com.google.gson.annotations.SerializedName;

public class CreerRecetteResponse {

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}

