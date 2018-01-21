package com.ckkj.zct.baselibrary.rx

import com.ckkj.zct.baselibrary.presenter.view.BaseView
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * @author zct
 * Created by zct11 on 2018/1/19.
 * Rx订阅者默认实现
 */
open class BaseSubscriber<T>(val baseView:BaseView):Subscriber<T> {
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(s: Subscription?) {
        s?.request(Long.MAX_VALUE)
    }


    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
        if (e is BaseException){
            baseView.onError(e.msg)
        }
    }
}