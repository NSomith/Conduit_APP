package com.example.conduit.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.module.entities.Article
import com.example.conduit.data.ArticlesRepo
import kotlinx.coroutines.launch

class FeedViewModel:ViewModel() {

    private val _feed = MutableLiveData<List<Article>>()

    val feed:LiveData<List<Article>> = _feed

    fun getGolobalFeed() = viewModelScope.launch {
        ArticlesRepo.gelGlobalFeed().body()?.let {
            _feed.postValue(it.articles)
            Log.d("Singh","${it.articlesCount}")
        }
    }
}