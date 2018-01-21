package com.ckkj.zct.door.service.impl

import com.ckkj.zct.baselibrary.ext.convertBoolean
import com.ckkj.zct.door.data.respository.UserRepository
import com.ckkj.zct.door.service.UserService
import io.reactivex.Flowable
import io.reactivex.Observable


/**
 * Created by zct11 on 2018/1/19.
 */

class UserServiceImpl : UserService {

    val userRepository=UserRepository()

    override fun register(mobile: String, pwd: String, verifyCode: String): Flowable<Boolean> {
        return userRepository.register(mobile,pwd,verifyCode).convertBoolean()
    }

}