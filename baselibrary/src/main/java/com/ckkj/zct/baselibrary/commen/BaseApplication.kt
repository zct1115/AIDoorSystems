package com.ckkj.zct.baselibrary.commen

import android.app.Application
import android.content.Context

/**
 * @author zct
 * Created by zct11 on 2018/1/18.
 * Application 基类
 */
open class BaseApplication:Application(){

    override fun onCreate() {
        super.onCreate()
        context=this

    }

    companion object {
        lateinit var context: Context
    }
}