package com.ckkj.zct.baselibrary.ext

import android.view.View

/**
 * @author zct
 * Created by zct11 on 2018/1/22.
 * view扩展类
 */
fun View.onClick (listener:View.OnClickListener):View{
    setOnClickListener(listener)
    return this
}

fun View.onClick(method:()->Unit):View{
    setOnClickListener{method()}
    return this
}