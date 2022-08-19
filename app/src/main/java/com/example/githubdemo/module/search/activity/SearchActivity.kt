package com.example.githubdemo.module.search.activity

import com.example.githubdemo.R
import com.example.githubdemo.base.BaseActivity
import com.example.githubdemo.databinding.ActivityProfileBinding
import com.example.githubdemo.module.search.fragment.SearchFragment
import com.example.githubdemo.module.user.fragment.ProfileFragment

class SearchActivity : BaseActivity<ActivityProfileBinding>(){

    override fun getViewId(): Int = R.layout.activity_profile

    override fun dataBinding(binding: ActivityProfileBinding) {
        SearchFragment.addFragment(
            supportFragmentManager,
            R.id.fragmentContainer
        )
    }
}