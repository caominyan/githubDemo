package com.example.githubdemo.imageapi

object ImageFx {

    val loaderMapper = HashMap<ImageLoaderType,ImageLoader>()

    fun getLoader(type : ImageLoaderType = ImageLoaderType.DEFAULT): ImageLoader? = if(loaderMapper.containsKey(type)){
        loaderMapper.get(type)
    }else{
        when(type){
            ImageLoaderType.GLIDE,ImageLoaderType.DEFAULT -> {
                val imageLoader = GlideImageLoader()
                loaderMapper.put(type,imageLoader)
                imageLoader
            }
            ImageLoaderType.FRESCO->{
                val imageLoader = FrescoImageLoader()
                loaderMapper.put(type,imageLoader)
                imageLoader
            }

        }
    }

}