package com.ckkj.zct.baselibrary.presenter.view


/**
 * @author zct
 * Created by zct11 on 2018/1/18.
 * MVP中视图回调 基类
 */
interface BaseView{
    /*展示加载框*/
    fun showLoading()
    /*隐藏加载框*/
    fun hideLoading()
    /*提示加载错误*/
    fun onError(text:String)
}