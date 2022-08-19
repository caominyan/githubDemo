package com.example.githubdemo.module.user

import android.content.Context
import android.content.Intent
import com.example.githubdemo.interfaces.UseModuleService
import com.example.githubdemo.module.user.activity.ProfileActivity
import com.google.auto.service.AutoService

@AutoService(UseModuleService::class)
class UserModuleServiceImpl : UseModuleService {

    override fun goToUserProfile(ctx: Context) {
        Intent(ctx, ProfileActivity::class.java)
            .apply {
                ctx.startActivity(this)
            }
    }

    override fun goToLogin(ctx: Context) {
        Intent(ctx, LoginActivity::class.java)
            .apply {
                ctx.startActivity(this)
            }
    }
}