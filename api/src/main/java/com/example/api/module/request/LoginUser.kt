package com.example.api.module.request


import com.example.api.module.entities.LoginData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginUser(
    @Json(name = "user")
    val user: LoginData
)