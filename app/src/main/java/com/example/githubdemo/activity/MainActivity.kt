package com.example.githubdemo.activity

import com.example.githubdemo.R
import com.example.githubdemo.base.BaseActivity
import com.example.githubdemo.databinding.ActivityMainBinding



class MainActivity : BaseActivity<ActivityMainBinding>(){

    override fun getViewId(): Int = R.layout.activity_login

    override fun dataBinding(binding: ActivityMainBinding) {}


}