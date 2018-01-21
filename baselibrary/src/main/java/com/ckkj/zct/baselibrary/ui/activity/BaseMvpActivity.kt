package com.ckkj.zct.baselibrary.ui.activity

import android.os.Bundle
import com.ckkj.zct.baselibrary.presenter.BasePresenter
import com.ckkj.zct.baselibrary.presenter.view.BaseView
import com.ckkj.zct.baselibrary.widget.ProgressLoading
import org.jetbrains.anko.toast

/**
 * @author zct
 * Created by zct11 on 2018/1/18.
 * MVP activity 基类
 */
abstract class BaseMvpActivity<T :BasePresenter<*>>:BaseAcitivity(),BaseView{

    private lateinit var mLoading: ProgressLoading

    lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mLoading= ProgressLoading.create(this)
    }
    override fun showLoading() {
       mLoading.showLoading()
    }

    override fun hideLoading() {
      mLoading.hideLoading()
    }

    override fun onError(text: String) {
       toast(text)
     }
}