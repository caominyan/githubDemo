package com.example.githubdemo.module.user.http

import com.example.githubdemo.module.user.pojo.UserProfile
import retrofit2.http.GET

interface UserService {

    @GET("/user")
    suspend fun getUserProfile() : UserProfile

}