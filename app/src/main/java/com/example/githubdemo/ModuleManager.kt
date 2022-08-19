package com.example.githubdemo

import java.util.*

object ModuleManager {

    init {
        ServiceLoader.load(Module::class.java).toList().forEach{
            it.init()
        }
    }

    fun destroy(){
        ServiceLoader.load(Module::class.java).toList().forEach{
            it.destory()
        }
    }

    fun <T> getService(moduleClass: Class<T>) : T{
        return ServiceLoader.load(moduleClass).toList().get(0)
    }
}

interface Module{
    fun init()
    fun destory()
}

