package com.ckkj.zct.baselibrary.widget

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

/**
 * @author zct
 * Created by zct11 on 2018/1/24.
 * 轮播图加载
 */
class BannerImageLoading :ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        Glide.with(context).load(path.toString()).into(imageView)
    }
}