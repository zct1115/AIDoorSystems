package com.ckkj.zct.door.ui.welcome

import android.os.Bundle
import android.view.WindowManager
import com.ckkj.zct.baselibrary.ui.activity.BaseAcitivity
import com.ckkj.zct.door.ui.MainActivity
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.jetbrains.anko.startActivity
import java.util.concurrent.TimeUnit

/**
 * @author zct
 * Created by zct11 on 2018/1/23.
 * 采用冷启动形式实现起始页
 */
class WelcomeActivity : BaseAcitivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        /*自定义线程*/
       /* Handler().postDelayed(object :Runnable{
            override fun run() {
                startActivity<RegisterActivity>()
                finish()
            }

        },1000)*/
        /*rxjava线程*/
        Flowable.timer(2,TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    startActivity<MainActivity>()
                    finish()
                })

    }
}
