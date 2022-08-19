package com.example.githubdemo.module.user.vm

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blankj.utilcode.util.SPStaticUtils
import com.example.githubdemo.module.user.LoginOp
import com.example.githubdemo.const.AppConfig
import java.util.*

class LoginViewModel : ViewModel() {

    val info = MutableLiveData<String>()

    var mLoginOp : LoginOp? = null


    fun onLogin(view : View){
        Log.e(TAG,"startLogin")
        SPStaticUtils.put("token","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")
        mLoginOp?.gotoUserProfile()
   }

    fun onNoLogin(view : View){
        Log.e(TAG,"startSearch")
        mLoginOp?.gotoSearch()
    }

    fun getOAuth2Url(): String? {
        val randomState = UUID.randomUUID().toString()
        return AppConfig.OAUTH2_URL.toString() +
                "?client_id=" + AppConfig.OPENHUB_CLIENT_ID +
                "&scope=" + AppConfig.OAUTH2_SCOPE +
                "&state=" + randomState
    }

    override fun onCleared() {
        super.onCleared()
        mLoginOp = null
    }


    companion object{
        val TAG = "LoginViewModel"
    }
}