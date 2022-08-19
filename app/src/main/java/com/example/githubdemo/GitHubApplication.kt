package com.example.githubdemo

import android.app.Application
import android.content.Context

class GitHubApplication : Application(){

    companion object{
        private var application: GitHubApplication? = null
        fun getInstance() : GitHubApplication? = application

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

}