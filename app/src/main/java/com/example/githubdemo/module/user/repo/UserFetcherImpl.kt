package com.example.githubdemo.module.user.repo
import com.example.githubdemo.module.user.http.UserModuleHttp
import com.example.githubdemo.network.GitHubRetrofit
import com.example.githubdemo.module.user.pojo.UserProfile
import com.example.githubdemo.utils.netCheckFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class UserFetcherImpl : UserFetcher {

    override suspend fun getUserProfile() : Flow<UserProfile> = netCheckFlow {
        delay(500)
        UserModuleHttp.getUserService()?.getUserProfile()!!
    }.flowOn(Dispatchers.IO)
}