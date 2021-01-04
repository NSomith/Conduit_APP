package com.example.api.module.request


import com.example.api.module.entities.User
import com.example.api.module.entities.UserUpdatedData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
    @Json(name = "user")
    val user: UserUpdatedData
)