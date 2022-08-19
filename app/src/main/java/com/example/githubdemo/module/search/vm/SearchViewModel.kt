package com.example.githubdemo.module.search.vm

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.githubdemo.module.search.pojo.Repository
import com.example.githubdemo.module.search.repo.SearchFetcher
import com.example.githubdemo.module.search.repo.SearchFetcherImpl
import kotlinx.coroutines.flow.*

class SearchViewModel :ViewModel() {

    private val _searchFlow = MutableStateFlow<String>("") // 在 MainViewModel 内部使用
    val searchFlow = _searchFlow // 在外部使用
    val repo : SearchFetcher = SearchFetcherImpl()

    val searchResultNetWork =
        // 避免在单位时间内，快输入造成大量的请求
        searchFlow.debounce(200)
            .filter { result ->
                return@filter result.isNotEmpty()
            }
            .flatMapLatest {
                repo.searchRepositories(it).cachedIn(viewModelScope)
            }
            .catch { throwable ->
                //  异常捕获
            }
            .asLiveData()

    fun searchRepo(keyWord: String) {
        val lastResult = _searchFlow.value
        if (keyWord == lastResult) {  // 避免重复提交
            return
        }
        _searchFlow.value = keyWord
    }

}