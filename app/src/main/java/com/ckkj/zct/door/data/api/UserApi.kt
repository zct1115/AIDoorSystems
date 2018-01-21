package com.ckkj.zct.door.data.api

import com.ckkj.zct.baselibrary.data.protocol.BaseResp
import com.ckkj.zct.door.data.protocol.RegisterReq
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by zct11 on 2018/1/19.
 */
interface UserApi{
    /*
        用户注册
     */
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Flowable<BaseResp<String>>
}