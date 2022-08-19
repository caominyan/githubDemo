package com.example.githubdemo.module.search.paging.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.githubdemo.module.search.http.SearchService
import com.example.githubdemo.module.search.pojo.Repository
import com.example.githubdemo.module.search.repo.SearchFetcher
import com.example.githubdemo.module.search.repo.SearchFetcherImpl

class RepositoryDataSource(private val query: String,
                           private val sort: String,
                           private val order: String,
                           private val searchService : SearchService) : PagingSource<Int,Repository>(){

    val searchFecher : SearchFetcher = SearchFetcherImpl()

    override fun getRefreshKey(state: PagingState<Int, Repository>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repository> {
        return try {
            //页码未定义置为1
            var currentPage = params.key ?: 1
            //仓库层请求数据
            var responseData = searchService.searchRepositories(query
                ,sort,order,currentPage)
            //当前页码 小于 总页码 页面加1
            var nextPage = if (responseData?.incompleteResults == true) {
                currentPage + 1
            } else {
                //没有更多数据
                null
            }

            if (responseData != null) {
                LoadResult.Page(
                    data = responseData.items,
                    prevKey = null,
                    nextKey = nextPage
                )
            } else {
                LoadResult.Error(throwable = Throwable())
            }


        } catch (e: Exception) {
            LoadResult.Error(throwable = e)
        }
    }
}