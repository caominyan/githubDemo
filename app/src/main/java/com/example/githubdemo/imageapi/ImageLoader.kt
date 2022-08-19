package com.example.githubdemo.imageapi

import android.widget.ImageView
import java.net.URI

interface ImageLoader {

    fun init()

    fun loadImage(imageView : ImageView , data : String)

    fun destory()

}