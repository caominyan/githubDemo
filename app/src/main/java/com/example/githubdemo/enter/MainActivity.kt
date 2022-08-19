package com.example.githubdemo.enter

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.blankj.utilcode.util.SPStaticUtils
import com.example.githubdemo.ModuleManager
import com.example.githubdemo.R
import com.example.githubdemo.base.BaseActivity
import com.example.githubdemo.base.CommonViewOp
import com.example.githubdemo.databinding.ActivityMainBinding
import com.example.githubdemo.interfaces.SearchModuleService
import com.example.githubdemo.interfaces.UseModuleService
import com.example.githubdemo.module.user.vm.LoginViewModel

interface MainOp : CommonViewOp {
    fun gotoUserProfile()
    fun gotoSearch()
    fun gotoLogin()
}

class MainActivity : BaseActivity<ActivityMainBinding>() , MainOp {

    private val userService : UseModuleService = ModuleManager.getService(UseModuleService::class.java)
    private val searchService : SearchModuleService = ModuleManager.getService(SearchModuleService::class.java)
    lateinit var  viewModel : MainViewModel

    override fun getViewId(): Int = R.layout.activity_main

    override fun dataBinding(binding: ActivityMainBinding) {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java).also {
            it.op = this@MainActivity
        }
        binding.vm = viewModel
        lifecycle.addObserver(viewModel)
    }

    override fun gotoUserProfile() {
        userService.goToUserProfile(this)
    }

    override fun gotoSearch() {
        searchService.goToSearch(this)
    }

    override fun gotoLogin() {
        userService.goToLogin(this)
    }
}