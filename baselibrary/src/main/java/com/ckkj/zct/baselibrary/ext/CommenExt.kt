package com.ckkj.zct.baselibrary.ext

import com.ckkj.zct.baselibrary.data.protocol.BaseResp
import com.ckkj.zct.baselibrary.rx.BaseSubscriber
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.ckkj.zct.baselibrary.rx.BaseFunc
import com.ckkj.zct.baselibrary.rx.BaseBooleanFunc

/**
 * @author zct
 * Created by zct11 on 2018/1/21.
 * kotlin 扩展函数
 */

/*扩展Flowable执行*/
fun<T> Flowable<T>.excute(subscriber: BaseSubscriber<T>){
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
}

/*扩展数据转换*/
fun<T>  Flowable<BaseResp<T>>.convert():Flowable<T>{
    return  this.flatMap(BaseFunc())
}

/*boolean数据转换*/
fun<T>  Flowable<BaseResp<T>>.convertBoolean():Flowable<Boolean>{
    return  this.flatMap(BaseBooleanFunc())
}