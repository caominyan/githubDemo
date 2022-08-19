package com.example.githubdemo.module.user.vm

import android.app.Activity
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.SPStaticUtils
import com.example.githubdemo.module.user.pojo.UserProfile
import com.example.githubdemo.module.user.repo.UserFetcher
import com.example.githubdemo.module.user.repo.UserFetcherImpl
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    val userFecher : UserFetcher = UserFetcherImpl()
    private val _uiState = MutableLiveData<UserProfile>()
    val uiState: LiveData<UserProfile> = _uiState
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun getUserProfile(){
        viewModelScope.launch {
            userFecher.getUserProfile()
                .onStart {
                    _loading.postValue(true)
                }
                .catch { exception : Throwable? ->
                    _loading.postValue(false)
                }.collect {
                    _loading.postValue(false)
                    _uiState.postValue(it)
                }
        }
    }

    fun logout(view : View){
        SPStaticUtils.put("loginin",false)
        (view.context as Activity).finish()
    }
}