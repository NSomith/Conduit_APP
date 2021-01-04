package com.example.api.module.response


import com.example.api.module.entities.Errors
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorRsponse(
    @Json(name = "errors")
    val errors: Errors
)