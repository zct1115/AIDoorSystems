package com.ckkj.zct.door.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ckkj.zct.baselibrary.commen.AppManager
import com.ckkj.zct.baselibrary.ui.activity.BaseAcitivity
import com.ckkj.zct.door.R
import com.ckkj.zct.door.ui.home.DynamicFragment
import com.ckkj.zct.door.ui.home.HomeFragment
import com.ckkj.zct.door.ui.home.MeFragment
import com.ckkj.zct.door.ui.home.MessageFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : BaseAcitivity() {


    private var pressTime:Long = 0

    //Fragment 栈管理
    private val mStack = Stack<Fragment>()
    //主界面Fragment
    private val mHomeFragment by lazy { HomeFragment() }
    //小区动态Fragment
    private val mDynamicFragment by lazy { DynamicFragment() }
    //消息Fragment
    private val mMessageFragment by lazy { MessageFragment() }
    //我的Fragment
    private val mMeFragment by lazy { MeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initFragment()
        initBottomNav()
        changeFragment(0)
        mBottomNavBar.checkedMessageBadge(0)

    }

    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object :BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })

        
    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack){
            manager.hide(fragment)
        }

        manager.show(mStack[position])
        manager.commit()
    }

    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.FlContent,mHomeFragment)
        manager.add(R.id.FlContent,mDynamicFragment)
        manager.add(R.id.FlContent,mMessageFragment)
        manager.add(R.id.FlContent,mMeFragment)
        manager.commit()
        mStack.add(mHomeFragment)
        mStack.add(mDynamicFragment)
        mStack.add(mMessageFragment)
        mStack.add(mMeFragment)

    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000){
            toast("再按一次退出程序")
            pressTime = time
        } else{
            AppManager.instance.exitApp(this)
        }
    }
}
