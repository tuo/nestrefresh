package com.todou.nestrefresh.example

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class FragmentAdapter(fm: FragmentManager, private val fmList: List<InnerFragment>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): InnerFragment {
        return fmList[position]
    }

    override fun getCount(): Int {
        return fmList.size
    }
}