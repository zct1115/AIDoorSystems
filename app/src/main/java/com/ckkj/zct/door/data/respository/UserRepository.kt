package com.ckkj.zct.door.data.respository

import com.ckkj.zct.baselibrary.data.net.RetrofitFactory
import com.ckkj.zct.baselibrary.data.protocol.BaseResp
import com.ckkj.zct.door.data.api.UserApi
import com.ckkj.zct.door.data.protocol.RegisterReq
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by zct11 on 2018/1/19.
 */
class UserRepository{
    /*
        用户注册
     */
    fun register(mobile:String,pwd:String,verifyCode:String): Flowable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile,pwd,verifyCode))
    }
}