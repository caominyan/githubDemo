package com.example.githubdemo.module.user

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.githubdemo.R
import com.example.githubdemo.base.BaseActivity
import com.example.githubdemo.base.CommonViewOp
import com.example.githubdemo.ModuleManager
import com.example.githubdemo.databinding.ActivityLoginBinding
import com.example.githubdemo.interfaces.MainModuleService
import com.example.githubdemo.interfaces.SearchModuleService
import com.example.githubdemo.interfaces.UseModuleService
import com.example.githubdemo.module.user.vm.LoginViewModel

interface LoginOp : CommonViewOp {
    fun goToMain()
}

class LoginActivity : BaseActivity<ActivityLoginBinding>() , LoginOp {

    lateinit var  loginViewModel : LoginViewModel
    private val userService : MainModuleService = ModuleManager.getService(MainModuleService::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermission()
    }

    override fun getViewId(): Int = R.layout.activity_login

    override fun dataBinding(binding: ActivityLoginBinding) {
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java).also {
            it.mLoginOp = this@LoginActivity
        }
        binding.loginVM = loginViewModel
    }

    override fun goToMain() {
        userService.goToMain(this)
        finish()

    }
}

