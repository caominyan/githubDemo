package com.example.githubdemo.utils.databinding

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> AppCompatActivity.binding() =
    ActivityDataBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> FragmentActivity.binding() =
    ActivityDataBindingDelegate(T::class.java, this)

inline fun <reified T : ViewBinding> Activity.binding() =
    ActivityDataBindingDelegate(T::class.java, this)