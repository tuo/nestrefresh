package com.todou.nestrefresh.example.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.todou.nestrefresh.example.R

import java.util.ArrayList

class RecyclerAdapterScroll : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mDatas: MutableList<Any> = ArrayList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater.inflate(R.layout.list_item_test, viewGroup, false)
        return TestViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        (viewHolder as TestViewHolder).bind(i)
    }

    fun updateDatas(datas: List<Any>?) {
        if (datas == null) return
        mDatas.clear()
        mDatas.addAll(datas)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    private class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var textPosition: TextView

        init {
            textPosition = itemView.findViewById(R.id.text_position)
        }

        fun bind(position: Int) {
            textPosition.text = "#$position"
        }
    }

}
