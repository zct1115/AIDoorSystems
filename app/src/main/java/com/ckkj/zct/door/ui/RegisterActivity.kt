package com.ckkj.zct.door.ui

import android.os.Bundle
import com.ckkj.zct.baselibrary.ui.activity.BaseMvpActivity
import com.ckkj.zct.door.R
import com.ckkj.zct.door.presenter.UserPresenter
import com.ckkj.zct.door.presenter.view.UserView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 * Created by zct11 on 2018/1/19.
 */
class RegisterActivity:BaseMvpActivity<UserPresenter>(),UserView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter= UserPresenter()
        mPresenter.mView=this
        mRegisterBtn.isEnabled=true
        mRegisterBtn.setOnClickListener {
            showLoading()
            mPresenter.register(mMobileEt.text.toString(),mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
        }

        mVerifyCodeBtn.setOnClickListener {
            if(mMobileEt.text.toString()!=null){
                mVerifyCodeBtn.requestSendVerifyNumber()
            }else{
                toast("请输入你的手机号码！")
            }

        }

    }

    override fun result(text: String) {
        toast(text)
    }
}