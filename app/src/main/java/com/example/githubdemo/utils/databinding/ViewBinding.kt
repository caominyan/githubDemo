package com.example.githubdemo.utils.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.githubdemo.imageapi.ImageFx
import com.wang.avi.AVLoadingIndicatorView


@BindingAdapter("bindingAvator")
fun bindingAvator(imageView: ImageView, url: String?) {
    url?.run {
        ImageFx.getLoader()?.loadImage(imageView,url)
    }

}

@BindingAdapter("bindingLoading")
fun bindLoading(view : AVLoadingIndicatorView, ishow : Boolean ){
    if(ishow){
        view.smoothToShow()
    }else{
        view.smoothToHide()
    }
}
