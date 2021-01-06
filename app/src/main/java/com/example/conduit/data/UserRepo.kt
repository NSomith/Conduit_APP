package com.example.conduit.data

import com.example.api.ConduitClient
import com.example.api.module.entities.LoginData
import com.example.api.module.request.LoginUser
import com.example.api.module.response.UserResponse

object UserRepo {

    val api = ConduitClient.publicapi
    val authApi = ConduitClient.authapi
    suspend fun login(email:String,password:String):UserResponse? {
        val response =
             api.loginuser(LoginUser(LoginData(email = email,password = password)))
            ConduitClient.authToken = response.body()?.user?.token

        return response.body()
    }

    suspend fun getUserProfile() = authApi.getCurrentUser().body()?.user
}