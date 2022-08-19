package com.example.githubdemo.module.user.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.githubdemo.R
import com.example.githubdemo.databinding.FragmentProfileBinding
import com.example.githubdemo.base.BaseDataBindingFragment
import com.example.githubdemo.module.user.vm.UserViewModel

class ProfileFragment : BaseDataBindingFragment(R.layout.fragment_profile){

    private val mBinding: FragmentProfileBinding by binding()
    private val mViewModel: UserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.apply {
            uservm = mViewModel.apply {
                getUserProfile()
            }
            lifecycleOwner = this@ProfileFragment
        }
    }


    companion object {
        private val TAG = "ProfileFragment"

        fun addFragment(
            manager: FragmentManager,
            fragmentContainerId: Int
        ) {
            manager.commit {
                replace(fragmentContainerId, ProfileFragment::class.java, null)
            }
        }
    }
}