package com.example.githubdemo.module.search

import android.content.Context
import android.content.Intent
import com.example.githubdemo.interfaces.SearchModuleService
import com.example.githubdemo.interfaces.UseModuleService
import com.example.githubdemo.module.search.activity.SearchActivity
import com.example.githubdemo.module.user.activity.ProfileActivity
import com.google.auto.service.AutoService

@AutoService(SearchModuleService::class)
class SearchModuleServiceImpl : SearchModuleService {

    override fun goToSearch(ctx: Context) {
        Intent(ctx, SearchActivity::class.java)
            .apply {
                ctx.startActivity(this)
            }
    }
}