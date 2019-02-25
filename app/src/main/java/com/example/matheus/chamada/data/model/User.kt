package com.example.matheus.chamada.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("code")
    private var code: String?,
    @SerializedName("name")
    private var name: String?,
    @SerializedName("login")
    private var login: String?,
    @SerializedName("photo")
    private var photo: String?
)