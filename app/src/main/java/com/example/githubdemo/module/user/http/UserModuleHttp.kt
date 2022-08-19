package com.example.githubdemo.module.user.http

import com.example.githubdemo.network.GitHubRetrofit

object UserModuleHttp {
    fun getUserService() : UserService? = GitHubRetrofit.getRetrofit()?.create(UserService::class.java)
}