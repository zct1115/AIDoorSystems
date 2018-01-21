package com.ckkj.zct.door.service

import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by zct11 on 2018/1/19.
 */
interface UserService{
    //用户注册
    fun register(mobile:String,pwd:String,verifyCode:String):Flowable<Boolean>
}