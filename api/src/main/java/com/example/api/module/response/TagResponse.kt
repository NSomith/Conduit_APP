package com.example.api.module.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagResponse(
    @Json(name = "tags")
    val tags: List<String>
)