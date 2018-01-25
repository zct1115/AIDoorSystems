package com.ckkj.zct.baselibrary.widget

import android.text.Editable
import android.text.TextWatcher

/**
 * @author zct
 * Created by zct11 on 2018/1/22.
 * textView文本改变
 */
open class DefaultTextWatcher: TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}
