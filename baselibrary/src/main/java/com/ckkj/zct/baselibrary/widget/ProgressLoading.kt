package com.ckkj.zct.baselibrary.widget

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.ckkj.zct.baselibrary.R

/**
 * @author zct
 * Created by zct11 on 2018/1/19.
 * 自定义加载框
 */
class ProgressLoading private constructor(context: Context, themeResId: Int): Dialog(context, themeResId) {

    companion object {
        private lateinit var mDialog: ProgressLoading
        private var animDrawable: AnimationDrawable? = null

        fun create(context: Context?):ProgressLoading {
            mDialog = ProgressLoading(context!!, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            /*设置触碰加载外面不能取消*/
            mDialog.setCanceledOnTouchOutside(false)
            /*设置布局居中*/
            mDialog.window.attributes.gravity = Gravity.CENTER

            val lp = mDialog.window.attributes
            /*灰度0.2*/
            lp.dimAmount = 0.2f
            mDialog.window.attributes = lp
            /*获取动画的背景*/
            val loadingView = mDialog.findViewById<ImageView>(R.id.iv_loading)
            animDrawable = loadingView.background as AnimationDrawable

            return mDialog
        }
    }
    /*设置动画开始*/
    fun showLoading() {
        super.show()
        animDrawable?.start()
    }
     /*设置动画暂停*/
    fun hideLoading() {
        super.hide()
        animDrawable?.stop()
    }
}