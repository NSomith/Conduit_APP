package com.example.api.services

import com.example.api.module.request.LoginUser
import com.example.api.module.request.SignUpRequest
import com.example.api.module.response.ArticlesResponse
import com.example.api.module.response.TagResponse
import com.example.api.module.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitApi {

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author:String? = null,
        @Query("favorited") favourated:String? =null,
        @Query("tag") tag:String?=null
    ):Response<ArticlesResponse>

    @POST("users")
    suspend fun signupUser(
        @Body userCred: SignUpRequest
    ):Response<UserResponse>

    @POST("users/login")
    suspend fun loginuser(
        @Body userCred: LoginUser
    ):Response<UserResponse>

    @GET("articles/{slug}")
    suspend fun getArticleBySlug(
        @Path("slug") slug:String
    ) : Response<ArticlesResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagResponse>
}