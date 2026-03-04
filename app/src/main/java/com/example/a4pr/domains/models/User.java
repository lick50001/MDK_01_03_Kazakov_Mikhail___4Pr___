package com.example.a4pr.domains.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("firstname")
    public String firstname;

    @SerializedName("lastname")
    public String lastname;

    @SerializedName("surname")
    public String surname;

    @SerializedName("gender")
    public String gender;

    // Поле для токена (вернётся при логине)
    @SerializedName("token")
    public String token;
}