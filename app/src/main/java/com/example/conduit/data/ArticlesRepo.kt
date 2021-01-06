package com.example.conduit.data

import com.example.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient.publicapi

    suspend fun gelGlobalFeed() = api.getArticles()
}