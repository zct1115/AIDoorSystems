package com.ckkj.zct.baselibrary.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * @author zct
 * Created by zct11 on 2018/1/24.
 *
 */
object GlideUtils {

    /**
     * 该方法需要自己实现RequestOptions
     * @context 上下文
     * @url 图片地址
     * @imageView 图片的视图
     * @options 自定义的RequestOptions
     */
    fun LoadingByCustom(context: Context,url:String,imageView: ImageView,options:RequestOptions){
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView)


    }



}