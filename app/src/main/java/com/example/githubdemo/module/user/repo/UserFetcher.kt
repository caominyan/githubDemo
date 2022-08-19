package com.example.githubdemo.module.user.repo

import com.example.githubdemo.module.user.pojo.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserFetcher {
    suspend fun getUserProfile() : Flow<UserProfile>
}