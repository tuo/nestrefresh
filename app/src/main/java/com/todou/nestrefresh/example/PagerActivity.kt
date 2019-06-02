package com.todou.nestrefresh.example

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.todou.nestrefresh.NestRefreshLayout

import java.util.Collections

class PagerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerAdapterTest
    private lateinit var fragmentAdapter: FragmentAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nest_refresh_viewpager)

        recyclerView = findViewById(R.id.recycler_view_inner)
        viewPager = findViewById(R.id.view_pager)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapterTest()
        recyclerView.adapter = adapter
        adapter.updateDatas(Collections.nCopies(10, Any()))
        findViewById<View>(R.id.text_tab_one).setOnClickListener {
            val view = findViewById<View>(R.id.view_test_relayout)
            view.visibility = if (view.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        }

        val pullRefreshHoverLayout = findViewById<NestRefreshLayout>(R.id.pull_refresh_hover)

        pullRefreshHoverLayout.setOnRefreshListener(object:NestRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                Toast.makeText(this@PagerActivity, "Refresh Start", Toast.LENGTH_SHORT).show()
                pullRefreshHoverLayout.postDelayed({
                    Toast.makeText(this@PagerActivity, "Refresh End", Toast.LENGTH_SHORT).show()
                    pullRefreshHoverLayout.setRefresh(false)
                    adapter.updateDatas(Collections.nCopies(20, Any()))
                }, 2000)
            }
        })


        val list = arrayListOf<InnerFragment>()
        for (i in 0..4) {
            val f = InnerFragment.newInstance()
            list.add(f)
        }
        fragmentAdapter = FragmentAdapter(supportFragmentManager, list)
        viewPager.adapter = fragmentAdapter
    }

}
