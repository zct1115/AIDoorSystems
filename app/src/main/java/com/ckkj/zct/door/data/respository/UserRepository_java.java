package com.ckkj.zct.door.data.respository;

import com.ckkj.zct.baselibrary.data.net.RetrofitFactory;
import com.ckkj.zct.baselibrary.data.protocol.BaseResp;
import com.ckkj.zct.door.data.api.UserApi_java;
import com.ckkj.zct.door.data.protocol.RegisterReq_java;

import io.reactivex.Flowable;

/**
 * Created by zct11 on 2018/1/21.
 */

public class UserRepository_java {

    public Flowable<BaseResp<String>> register(String mobile,String pwd,String verifyCode){
        return RetrofitFactory.Companion.getInstance().create(UserApi_java.class).register(new RegisterReq_java(mobile,pwd,verifyCode));
    }
}
