package com.ckkj.zct.door.presenter

import android.content.Context
import com.ckkj.zct.baselibrary.commen.BaseApplication.Companion.context
import com.ckkj.zct.baselibrary.ext.excute
import com.ckkj.zct.baselibrary.presenter.BasePresenter
import com.ckkj.zct.baselibrary.rx.BaseSubscriber
import com.ckkj.zct.door.presenter.view.UserView
import com.ckkj.zct.door.service.impl.UserServiceImpl
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.operators.flowable.FlowableFromObservable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.function.Consumer
import io.reactivex.Flowable


/**
 * Created by zct11 on 2018/1/19.
 */
class UserPresenter : BasePresenter<UserView>() {


    fun register(username: String, password: String, verityCode: String) {
        /*业务逻辑*/

        val userService = UserServiceImpl()

        if(!checkNetWork()){
            return
        }

        userService.register(username, password, verityCode)
                .excute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        if(t!!){
                            mView.result("注册成功")
                        }else{
                            mView.result("注册失败")
                        }
                    }
                })
               /* .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .safeSubscribe(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)

                    }
                })*/
                /*.subscribe(object : Subscriber<Boolean> {
                    override fun onComplete() {
                        //mView.hideLoading()
                    }

                    override fun onSubscribe(s: Subscription?) {
                        s?.request(Long.MAX_VALUE)
                    }

                    override fun onNext(t: Boolean?) {
                       // mView.hideLoading()
                        if(t!!){
                            mView.result("注册成功")
                        }else{
                            mView.result("注册失败")
                        }
                    }

                    override fun onError(t: Throwable?) {
                    }

                })*/


    }
}




