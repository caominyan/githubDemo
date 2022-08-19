package com.example.githubdemo.base

interface CommonViewOp {

    fun showToast(text : String)

    fun showError(text : String)

    fun closeCurrentPage()

    fun checkPermission()

}