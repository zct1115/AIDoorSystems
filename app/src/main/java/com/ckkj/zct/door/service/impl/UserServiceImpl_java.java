package com.ckkj.zct.door.service.impl;

import com.ckkj.zct.baselibrary.commen.ResultCode;
import com.ckkj.zct.baselibrary.data.protocol.BaseResp;
import com.ckkj.zct.baselibrary.rx.BaseException;
import com.ckkj.zct.door.data.respository.UserRepository_java;
import com.ckkj.zct.door.service.UserService_java;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * Created by zct11 on 2018/1/21.
 */

public class UserServiceImpl_java implements UserService_java {


    UserRepository_java userRepository_java=new UserRepository_java();

    @Override
    public Flowable<Flowable<Boolean>> register(String mobile, String pwd, String verifyCode) {
        return userRepository_java.register(mobile,pwd,verifyCode).map(new Function<BaseResp<String>, Flowable<Boolean>>() {
            @Override
            public Flowable<Boolean> apply(BaseResp<String> stringBaseResp) throws Exception {
                if(stringBaseResp.getStatus()== ResultCode.SUCCESS){
                    return Flowable.just(true);
                }
                return Flowable.error(new BaseException(stringBaseResp.getStatus(),stringBaseResp.getMessage()));
            }
        });
    }
}
