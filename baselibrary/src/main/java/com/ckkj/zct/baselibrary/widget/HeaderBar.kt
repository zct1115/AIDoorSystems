package com.ckkj.zct.baselibrary.widget

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.ckkj.zct.baselibrary.R
import com.ckkj.zct.baselibrary.ext.onClick

import kotlinx.android.synthetic.main.layout_header_bar.view.*

/**
 * @author zct
 * Created by zct11 on 2018/1/19.
 * 自定义标题栏
 * 用法在xml文件中
 *
 */
class HeaderBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var isShowBack = true
    private var titleText: String? = null
    private var rightText: String? = null

    init {
        /*获取自定义HeadBar*/
        val typeArray = context.obtainStyledAttributes(attrs,R.styleable.HeaderBar)
        /*获取自定义HeadBar的属性值*/
        isShowBack = typeArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        titleText = typeArray.getString(R.styleable.HeaderBar_titleText)
        rightText = typeArray.getString(R.styleable.HeaderBar_rightText)
        /*初始化布局*/
        initView()
        /*方法回收*/
        typeArray.recycle()
    }

    private fun initView() {
        View.inflate(context, R.layout.layout_header_bar, this)
        mLeftIv.visibility= if(isShowBack) View.VISIBLE else View.GONE
        /*kotlin 不为空用法？.let*/
        titleText?.let {
            mTitleTv.text=it
        }
        rightText?.let {
            mRightTv.text=it
            mRightTv.visibility= View.VISIBLE
        }


        mLeftIv.onClick {
            if(context is Activity){
                (context as Activity).finish()
            }
        }

    }

    fun getRightView():View{
        return mRightTv
    }
}