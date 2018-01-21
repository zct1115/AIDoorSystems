package com.ckkj.zct.door.data.api;

import com.ckkj.zct.baselibrary.data.protocol.BaseResp;
import com.ckkj.zct.door.data.protocol.RegisterReq_java;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by zct11 on 2018/1/21.
 */

public interface UserApi_java {

    @POST("userCenter/register")
    Flowable<BaseResp<String>> register(@Body RegisterReq_java registerReq_java);

}
