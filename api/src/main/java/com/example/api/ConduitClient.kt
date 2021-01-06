package com.example.api

import com.example.api.services.ConduitApi
import com.example.api.services.ConduitAuthApi
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ConduitClient {

    var authToken:String?=null
    private val authIntercpetor = Interceptor { chain ->
        var req = chain.request()
        authToken?.let {
            req = req.newBuilder().addHeader("Authorization","Token $it").build()
        }
        chain.proceed(req)
    }

    val okHtttpBuilder = OkHttpClient.Builder()
        .readTimeout(5,TimeUnit.SECONDS)
        .callTimeout(2,TimeUnit.SECONDS )

    val retrofit = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())

    val publicapi = retrofit.client(okHtttpBuilder.build()).build().create(ConduitApi::class.java)
    val authapi = retrofit.client(okHtttpBuilder.build()).build().create(ConduitAuthApi::class.java)
}