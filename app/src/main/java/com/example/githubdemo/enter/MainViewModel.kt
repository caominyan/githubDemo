package com.example.githubdemo.enter

import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blankj.utilcode.util.SPStaticUtils

class MainViewModel : ViewModel() , DefaultLifecycleObserver {

    var op : MainOp? = null

    val loginStatus = MutableLiveData<Boolean>(false)

    fun getLoginStatusMethod(){
        loginStatus.value = SPStaticUtils.getBoolean("loginin")
    }

    fun doLogin(view : View){
        op?.gotoLogin()
    }

    fun doUserProfile(view : View){
        op?.gotoUserProfile()
    }

    fun doSearch(view : View){
        op?.gotoSearch()
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        getLoginStatusMethod()
    }
}