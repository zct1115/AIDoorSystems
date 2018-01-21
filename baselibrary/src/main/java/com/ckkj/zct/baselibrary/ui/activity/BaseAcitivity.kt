package com.ckkj.zct.baselibrary.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ckkj.zct.baselibrary.commen.AppManager

/**
 * @author zct
 * Created by zct11 on 2018/1/18.
 * activity 基类
 */
open class BaseAcitivity :AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}