package com.example.githubdemo.network.interceptor

import com.blankj.utilcode.util.SPStaticUtils
import okhttp3.Interceptor
import okhttp3.Response

class TokenIntecptor : Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "token ${SPStaticUtils.getString("token")}")
            .build()
        return chain.proceed(request)
    }
}