package com.example.githubdemo.module.search.repo

import androidx.annotation.AnyThread
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubdemo.module.search.http.SearchModuleHttp
import com.example.githubdemo.module.search.paging.repository.RepositoryDataSource
import com.example.githubdemo.module.search.pojo.Repository
import kotlinx.coroutines.flow.Flow

class SearchFetcherImpl : SearchFetcher {

    val globalPagingConfig: PagingConfig
        @AnyThread get() = PagingConfig(
            pageSize = 30,
            enablePlaceholders = false             // 定义[PagingData]是否可以显示“null”占位符
        )

    override suspend fun searchRepositories(
        query: String,
        sort: String,
        order: String
    ): Flow<PagingData<Repository>> {
        return Pager(
            config = globalPagingConfig,
            pagingSourceFactory = { RepositoryDataSource(query, sort,order,SearchModuleHttp.getRepository()) }
        ).flow

    }
}