package com.ckkj.zct.baselibrary.widget

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.ckkj.zct.baselibrary.R

/**
 * @author zct
 * Created by zct11 on 2018/1/24.
 * 底部菜单栏
 */
class BottomNavigation @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {

    private val mMessageBadge:TextBadgeItem

    init {
        /*首页*/
        val homeItem=BottomNavigationItem(R.drawable.bar_home_select,resources.getString(R.string.nar_home))
                .setInactiveIconResource(R.drawable.bar_home_not_select)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)
        /*动态*/
        val dynamicItem=BottomNavigationItem(R.drawable.bar_dynamic_select,resources.getString(R.string.nar_circle))
                .setInactiveIconResource(R.drawable.bar_dynamic_not_select)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)

        /*消息*/
        val messageItem=BottomNavigationItem(R.drawable.bar_message_select,resources.getString(R.string.nar_message))
                .setInactiveIconResource(R.drawable.bar_message_not_select)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)

        mMessageBadge= TextBadgeItem()
        messageItem.setBadgeItem(mMessageBadge)

        /*我的*/
        val meItem=BottomNavigationItem(R.drawable.bar_me_select,resources.getString(R.string.nar_me))
                .setInactiveIconResource(R.drawable.bar_me_not_select)
                .setActiveColorResource(R.color.common_blue)
                .setInActiveColorResource(R.color.text_normal)

        /*设置底部模式*/
        setMode(BottomNavigationBar.MODE_FIXED)
        /*设置背景风格*/
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        /*设置背景颜色*/
        setBarBackgroundColor(R.color.common_bg)

        /*初始化*/
        addItem(homeItem)
                .addItem(dynamicItem)
                .addItem(messageItem)
                .addItem(meItem)
                .setFirstSelectedPosition(0)
                .initialise()

    }

    fun checkedMessageBadge(count:Int){
        if (count==0){
           mMessageBadge.hide()
        }else{
            mMessageBadge.show()
            mMessageBadge.setText("${count}")
        }
    }



}
