package com.example.githubdemo.module.search.pojo

import com.google.gson.annotations.SerializedName

data class BaseSearchResult<T>(
    @SerializedName("total_count")
    var totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults : Boolean = false,
    @SerializedName("items")
    val items : List<T>
)


