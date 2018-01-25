package com.ckkj.zct.door.ui.home

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ckkj.zct.baselibrary.ui.fragment.BaseFragment
import com.ckkj.zct.door.R
import com.ckkj.zct.door.adapter.ItemMeAdapter
import com.ckkj.zct.door.bean.Item_me
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.support.v4.act
import java.util.ArrayList

/**
 * Created by zct11 on 2018/1/24.
 */
class MeFragment: BaseFragment()  {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_me,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val manager=GridLayoutManager(context,4)
        mRecycleView.layoutManager=manager
        val itemMeAdapter=ItemMeAdapter(act)
        mRecycleView.adapter=itemMeAdapter

        itemMeAdapter.setData(mutableListOf(Item_me(R.mipmap.authentication,"户主认证"),Item_me(R.mipmap.door,"门禁"),Item_me(R.mipmap.register,"人脸注册"),Item_me(R.mipmap.people,"成员")))
    }
}