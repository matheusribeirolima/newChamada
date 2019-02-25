package com.example.matheus.chamada.data.model.service.login

import com.example.matheus.chamada.data.model.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("accessToken")
    val accessToken: String?,
    @SerializedName("user")
    val user: User?
)