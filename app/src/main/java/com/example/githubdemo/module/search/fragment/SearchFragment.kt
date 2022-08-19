package com.example.githubdemo.module.search.fragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubdemo.R
import com.example.githubdemo.base.BaseDataBindingFragment
import com.example.githubdemo.databinding.FragmentProfileBinding
import com.example.githubdemo.databinding.FragmentSearchBinding
import com.example.githubdemo.module.search.adapter.ReposAdapter
import com.example.githubdemo.module.search.vm.SearchViewModel
import com.example.githubdemo.module.user.fragment.ProfileFragment
import com.example.githubdemo.module.user.vm.UserViewModel

class SearchFragment :BaseDataBindingFragment(R.layout.fragment_search){

    private val mBinding: FragmentSearchBinding by binding()
    private val mViewModel: SearchViewModel by viewModels()
    private val adapter : ReposAdapter = ReposAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding.apply {
            rvData.adapter = adapter
            rvData.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            vm = mViewModel.apply {
                searchRepo("android")
                searchResultNetWork.observe(viewLifecycleOwner) {
                    adapter.submitData(lifecycle, it)
                }
            }
            lifecycleOwner = this@SearchFragment
            mBinding.etSearch.addTextChangedListener {
                mViewModel.searchRepo(it.toString())
            }
        }
    }


    companion object {
        private val TAG = "SearchFragment"

        fun addFragment(
            manager: FragmentManager,
            fragmentContainerId: Int
        ) {
            manager.commit {
                replace(fragmentContainerId, SearchFragment::class.java, null)
            }
        }
    }
}