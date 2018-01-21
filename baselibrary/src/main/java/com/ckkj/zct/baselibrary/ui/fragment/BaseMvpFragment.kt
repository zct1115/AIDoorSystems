package com.ckkj.zct.baselibrary.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ckkj.zct.baselibrary.presenter.BasePresenter
import com.ckkj.zct.baselibrary.presenter.view.BaseView
import com.ckkj.zct.baselibrary.widget.ProgressLoading
import org.jetbrains.anko.support.v4.toast

/**
 * @author zct
 * Created by zct11 on 2018/1/19.
 * ＭＶＰ　fragment 基类
 */
abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //初始加载框
        mLoadingDialog = ProgressLoading.create(context)
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    /*
        显示加载框，默认实现
     */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /*
        错误信息提示，默认实现
     */
    override fun onError(text:String) {
        toast(text)
    }


}