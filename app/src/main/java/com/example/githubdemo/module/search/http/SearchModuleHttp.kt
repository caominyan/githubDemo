package com.example.githubdemo.module.search.http

import com.example.githubdemo.network.GitHubRetrofit

object SearchModuleHttp {
    fun getRepository() : SearchService = GitHubRetrofit.getRetrofit()?.create(SearchService::class.java)
}