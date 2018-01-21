package com.ckkj.zct.baselibrary.presenter

import android.content.Context
import com.ckkj.zct.baselibrary.presenter.view.BaseView
import com.ckkj.zct.baselibrary.utils.NetWorkUtils

/**
 * @author zct
 * Created by zct11 on 2018/1/18.
 * MVP中P层 基类
 */
open class BasePresenter<T :BaseView>{
    lateinit var mView: T

    lateinit var context:Context

    /*
        检查网络是否可用
     */
    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }

}