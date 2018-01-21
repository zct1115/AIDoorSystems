package com.ckkj.zct.baselibrary.rx

import com.ckkj.zct.baselibrary.commen.ResultCode
import com.ckkj.zct.baselibrary.data.protocol.BaseResp
import io.reactivex.Flowable
import io.reactivex.functions.Function

/**
 * @author zct
 * Created by zct11 on 2018/1/21.
 * Boolean类型转换封装
 * Flowable返回true
 */
class BaseBooleanFunc<T>:Function<BaseResp<T>,Flowable<Boolean>>{

    override fun apply(t: BaseResp<T>): Flowable<Boolean> {
        if(t.status!=ResultCode.SUCCESS){
            return Flowable.error(BaseException(t.status,t.message))
        }
        return Flowable.just(true)
    }

}