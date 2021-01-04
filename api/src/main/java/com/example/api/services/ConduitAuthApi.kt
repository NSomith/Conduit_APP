package com.example.api.services

import com.example.api.module.request.UserUpdateRequest
import com.example.api.module.response.ArticlesResponse
import com.example.api.module.response.ProfileResponse
import com.example.api.module.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAuthApi {

    @GET("user")
    suspend fun getCurrentUser():Response<UserResponse>

    @PUT("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest:UserUpdateRequest
    ):Response<UserResponse>

    @GET("profiles/{username}")
    suspend fun getProfile(
        @Path("username") username:String
    ):Response<ProfileResponse>

    @POST("profiles/{username}/follow")
    suspend fun followProfile(
        @Path("username") username:String
    ):Response<ProfileResponse>

    @DELETE("profiles/{username}/follow")
    suspend fun unfollowProfile(
        @Path("username") username: String
    ):Response<ProfileResponse>

    @GET("articles/feed")
    suspend fun getFeedArticles():Response<ArticlesResponse>

    @POST("articles/{slug}/favorite")
    suspend fun favouriteArticle(
        @Path("slug") slug:String
    ):Response<ArticlesResponse>

    @DELETE("articles/{slug}/favorite")
    suspend fun unfavouriteArticle(
        @Path("slug") slug:String
    ):Response<ArticlesResponse>
}