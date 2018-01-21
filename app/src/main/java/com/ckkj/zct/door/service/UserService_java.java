package com.ckkj.zct.door.service;

import io.reactivex.Flowable;

/**
 * Created by zct11 on 2018/1/21.
 */

public interface UserService_java {
    Flowable<Flowable<Boolean>> register(String mobile, String pwd, String verifyCode);
}
