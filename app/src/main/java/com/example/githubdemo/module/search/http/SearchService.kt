package com.example.githubdemo.module.search.http

import com.example.githubdemo.module.search.pojo.BaseSearchResult
import com.example.githubdemo.module.search.pojo.Repository
import com.example.githubdemo.module.user.pojo.UserProfile
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("/search/repositories")
    suspend fun searchRepositories(@Query(value = "q", encoded = true) query : String ,
                               @Query("sort")  sort : String = "stars",
                               @Query("order") order : String = "desc",
                               @Query("page")  page : Int) : BaseSearchResult<Repository>

}