package com.ckkj.zct.door.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ckkj.zct.baselibrary.ui.adapter.BaseRecyclerViewAdapter
import com.ckkj.zct.door.R
import com.ckkj.zct.door.bean.Item_me
import kotlinx.android.synthetic.main.item_me.view.*
import java.util.ArrayList

/**
 * Created by zct11 on 2018/1/25.
 */
class ItemMeAdapter (context: Context): BaseRecyclerViewAdapter<Item_me,ItemMeAdapter.ViewHolder>(context) {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_me,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.item_image.setBackgroundResource(dataList[position].icon)
        holder.itemView.item_text.text=dataList[position].name
    }

    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
       init {

       }
    }
}