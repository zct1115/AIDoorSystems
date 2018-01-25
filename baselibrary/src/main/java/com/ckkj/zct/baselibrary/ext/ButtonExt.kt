package com.ckkj.zct.baselibrary.ext

import android.widget.Button
import android.widget.EditText
import com.ckkj.zct.baselibrary.widget.DefaultTextWatcher
import com.ckkj.zct.baselibrary.widget.VerifyButton

/**
 * @author zct
 * Created by zct11 on 2018/1/22.
 * button 扩展函数
 */
fun Button.enable(et:EditText,method:()->Boolean){

    val btn=this
    et.addTextChangedListener(object :DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled=method()

        }
    })

}
