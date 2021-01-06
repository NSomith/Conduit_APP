package com.example.conduit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.module.entities.User
import com.example.conduit.data.UserRepo
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private  val _user = MutableLiveData<User?>()
    val user:LiveData<User?> = _user

    fun login(email:String,password:String) = viewModelScope.launch {
        UserRepo.login(email,password)?.let {
            _user.postValue(it.user)
        }
    }
}