package com.ckkj.zct.door.ui.me

import android.os.Bundle
import android.view.View
import com.ckkj.zct.baselibrary.ext.enable
import com.ckkj.zct.baselibrary.ext.onClick
import com.ckkj.zct.baselibrary.ui.activity.BaseMvpActivity
import com.ckkj.zct.door.R
import com.ckkj.zct.door.presenter.UserPresenter
import com.ckkj.zct.door.presenter.view.UserView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 * Created by zct11 on 2018/1/19.
 */
class RegisterActivity:BaseMvpActivity<UserPresenter>(),UserView, View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mPresenter= UserPresenter()
        mPresenter.mView=this
        mPresenter.context=this

        initView()


    }

    private fun initView() {

        mRegisterBtn.enable(mMobileEt,{isEnable()})
        mRegisterBtn.enable(mVerifyCodeEt,{isEnable()})
        mRegisterBtn.enable(mPwdEt,{isEnable()})
        mRegisterBtn.enable(mPwdConfirmEt,{isEnable()})
        mRegisterBtn.onClick(this)

        mVerifyCodeBtn.onClick(this)


    }

    override fun result(text: String) {
        toast(text)
    }

    override fun onClick(view: View) {
       when(view.id){
           R.id.mRegisterBtn->{
               showLoading()
               mPresenter.register(mMobileEt.text.toString(),mPwdEt.text.toString(),mVerifyCodeEt.text.toString())
           }
           R.id.mVerifyCodeBtn->{
               mVerifyCodeBtn.requestSendVerifyNumber()
           }

       }
    }

    fun isEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not()&&
                mVerifyCodeEt.text.isNullOrEmpty().not()&&
                mPwdEt.text.isNullOrEmpty().not()&&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }

}