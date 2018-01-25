package com.ckkj.zct.door.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ckkj.zct.baselibrary.ui.fragment.BaseFragment
import com.ckkj.zct.baselibrary.widget.BannerImageLoading
import com.ckkj.zct.door.R
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by zct11 on 2018/1/24.
 */
class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_home,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
        initNew()
    }


    private fun initBanner() {
        val image1="http://img4.imgtn.bdimg.com/it/u=1948108738,2209615092&fm=27&gp=0.jpg"
        val image2="http://img1.imgtn.bdimg.com/it/u=2912778065,2464855524&fm=200&gp=0.jpg"

        /*设置图片加载器*/
        banner.setImageLoader(BannerImageLoading())
        /*设置图片*/
        banner.setImages(listOf(image1,image2))
        /*设置动画*/
        banner.setBannerAnimation(Transformer.ForegroundToBackground)
        /*设置自动轮播*/
        banner.isAutoPlay(true)
        /*设置轮播时间*/
        banner.setDelayTime(2500)
        /*设置指示器*/
        banner.setIndicatorGravity(BannerConfig.RIGHT)

        banner.start()

    }

    private fun initNew() {
        mNewFlipperView.setData(arrayOf("AI智慧人脸识别门禁系统上线啦！","各位用户们请注册人脸以便进出小区，多谢合作！"))
    }
}