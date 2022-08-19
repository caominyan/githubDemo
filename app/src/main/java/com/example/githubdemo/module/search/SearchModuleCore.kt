package com.example.githubdemo.module.search

import android.util.Log
import com.example.githubdemo.Module
import com.google.auto.service.AutoService

@AutoService(Module::class)
class SearchModuleCore : Module{
    override fun init() {
        Log.e(TAG,"SearchModuleCore is inited")
    }

    override fun destory() {
        Log.e(TAG,"SearchModuleCore is detroyed")
    }

    companion object{
        val TAG = "SearchModuleCore"
    }
}