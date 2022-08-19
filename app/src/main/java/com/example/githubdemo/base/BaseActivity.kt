package com.example.githubdemo.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.LogUtils.a
import com.blankj.utilcode.util.PermissionUtils


abstract class BaseActivity<T : ViewDataBinding?> : AppCompatActivity() , CommonViewOp {

    protected var activityDataBinding : T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDataBinding = DataBindingUtil.setContentView<T>(this,getViewId()).also {
            it?.lifecycleOwner = this@BaseActivity
            dataBinding(it)
        }
    }

    abstract fun getViewId(): Int
    abstract fun dataBinding(binding : T)

    override fun showToast(text: String) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }

    override fun showError(text: String) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }

    override fun closeCurrentPage() {
        onBackPressed()
    }

    @SuppressLint("WrongConstant")
    override fun checkPermission() {
        val permissions : List<String> = PermissionUtils.getPermissions()
        val permissionArray : Array<String> = permissions.toTypedArray()
        val permissionCheck = PermissionUtils.permission(*permissionArray)
        permissionCheck.callback(object : PermissionUtils.FullCallback{
            override fun onGranted(granted: MutableList<String>) {

            }

            override fun onDenied(deniedForever: MutableList<String>, denied: MutableList<String>) {

            }
        })
        permissionCheck.request()
    }
}