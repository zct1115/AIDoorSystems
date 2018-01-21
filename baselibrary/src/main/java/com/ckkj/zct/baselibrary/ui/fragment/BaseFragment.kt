package com.ckkj.zct.baselibrary.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

/**
 * @author zct
 * Created by zct11 on 2018/1/19.
 * fragment 基类
 */
open class BaseFragment:Fragment(){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }
}