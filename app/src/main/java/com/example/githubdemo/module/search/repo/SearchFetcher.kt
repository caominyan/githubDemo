package com.example.githubdemo.module.search.repo

import androidx.paging.PagingData
import com.example.githubdemo.module.search.pojo.BaseSearchResult
import com.example.githubdemo.module.search.pojo.Repository
import com.example.githubdemo.module.user.pojo.UserProfile
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface SearchFetcher {
    suspend fun searchRepositories(query : String,
                                   sort : String = "stars",
                                   order : String = "desc") : Flow<PagingData<Repository>>
}