package com.ckkj.zct.baselibrary.commen

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * @author zct
 * Created by zct11 on 2018/1/18.
 * activity 管理
 */
class AppManager private constructor(){

    private val activityStack:Stack<Activity> = Stack()

    companion object {
        val instance:AppManager by lazy{ AppManager()}
    }

    /*activity进栈*/
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    /*结束activity*/
    fun finishActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }
    /*结束所有activity*/
    fun finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }

     /*退出app*/
    @SuppressLint("MissingPermission")
    fun exitApp(context: Context){
        finishAllActivity()
        val activityManager=context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}