package com.ckkj.zct.baselibrary.rx

import com.ckkj.zct.baselibrary.commen.ResultCode
import com.ckkj.zct.baselibrary.data.protocol.BaseResp
import io.reactivex.Flowable
import io.reactivex.functions.Function

/**
 * @author zct
 * Created by zct11 on 2018/1/21.
 * 通用数据类型转换封装
 * Flowable返回数据类型
 */
class BaseFunc<T>:Function<BaseResp<T>,Flowable<T>>{

    override fun apply(t: BaseResp<T>): Flowable<T> {
        if(t.status!=ResultCode.SUCCESS){
            return Flowable.error(BaseException(t.status,t.message))
        }
        return Flowable.just(t.data)
    }

}