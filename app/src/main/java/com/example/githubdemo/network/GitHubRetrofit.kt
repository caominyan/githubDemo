package com.example.githubdemo.network

import com.example.githubdemo.BuildConfig
import com.example.githubdemo.const.AppConfig
import com.example.githubdemo.network.interceptor.TokenIntecptor
import com.example.githubdemo.module.user.http.UserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GitHubRetrofit {

    private val retrofitMap = HashMap<String, Retrofit>()

    private fun createRetrofit(baseUrl: String) {
        val timeOut: Int = AppConfig.HTTP_TIME_OUT
        val okhBuilder : OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(timeOut.toLong(), TimeUnit.MILLISECONDS)
        if(BuildConfig.BUILD_TYPE == "debug"){
            okhBuilder.addInterceptor(HttpLoggingInterceptor()
                .apply { level = HttpLoggingInterceptor.Level.BODY })
        }
        okhBuilder.addInterceptor(TokenIntecptor())
        val okHttpClient = okhBuilder.build();
        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
        builder.addConverterFactory(GsonConverterFactory.create())
        retrofitMap["$baseUrl"] = builder.build()
    }

    fun getRetrofit(baseUrl: String = AppConfig.GITHUB_API_BASE_URL): Retrofit {
        val key = "$baseUrl"
        if (!retrofitMap.containsKey(key)) {
            createRetrofit(baseUrl)
        }
        return retrofitMap[key]!!
    }

}