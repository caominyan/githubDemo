package com.example.githubdemo.enter

import android.content.Context
import android.content.Intent
import com.example.githubdemo.interfaces.MainModuleService
import com.example.githubdemo.interfaces.SearchModuleService
import com.example.githubdemo.interfaces.UseModuleService
import com.example.githubdemo.module.search.activity.SearchActivity
import com.example.githubdemo.module.user.activity.ProfileActivity
import com.google.auto.service.AutoService

@AutoService(MainModuleService::class)
class MainModuleServiceImpl : MainModuleService {

    override fun goToMain(ctx: Context) {
        Intent(ctx, MainActivity::class.java)
            .apply {
                ctx.startActivity(this)
            }
    }
}