package com.example.githubdemo.module.user

import android.util.Log
import com.example.githubdemo.Module
import com.google.auto.service.AutoService

@AutoService(Module::class)
class UserModuleCore : Module{
    override fun init() {
        Log.e(TAG,"UserModuleCore is inited")
    }

    override fun destory() {
        Log.e(TAG,"UserModuleCore is detroyed")
    }

    companion object{
        val TAG = "UserModuleCore"
    }
}