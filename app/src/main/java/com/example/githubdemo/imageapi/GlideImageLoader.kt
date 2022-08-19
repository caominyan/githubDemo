package com.example.githubdemo.imageapi

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader : ImageLoader{

    override fun init() {

    }

    override fun loadImage(imageView: ImageView, data: String) {
        Glide.with(imageView.context)
            .load(data)
            .into(imageView)
    }



    override fun destory() {

    }
}