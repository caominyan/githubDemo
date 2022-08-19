package com.example.githubdemo.utils

import android.app.Activity
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.NetworkUtils
import com.example.githubdemo.module.user.pojo.UserProfile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> netCheckFlow(block:suspend () -> T): Flow<T> {
    return flow {
        if(!NetworkUtils.isAvailable()){
            throw RuntimeException("网络未连接")
        }else{
            emit(block())
        }
    }
}

fun <T> Gson.typedToJson(src: T): String = toJson(src)

inline fun <reified T : Any> Gson.fromJson(json: String): T =
    fromJson(json, object : TypeToken<T>() {}.type)





