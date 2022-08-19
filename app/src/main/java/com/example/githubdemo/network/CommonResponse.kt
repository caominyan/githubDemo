package com.example.githubdemo.network

sealed class CommonResponse{
    class Success<T>(var data: T?) : CommonResponse()
    class Failure(var exception: Throwable?) : CommonResponse()
}


