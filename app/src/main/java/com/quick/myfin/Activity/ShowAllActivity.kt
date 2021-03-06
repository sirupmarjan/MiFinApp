package com.quick.myfin.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.quick.myfin.Adapter.BalanceViewPagerAdapter
import com.quick.myfin.Fragment.ListAllFragment
import com.quick.myfin.Fragment.ListInFragment
import com.quick.myfin.Fragment.ListOutFragment
import com.quick.myfin.R

class ShowAllActivity : AppCompatActivity() {

    lateinit var tabAction :TabLayout
    lateinit var vp_list : ViewPager
    lateinit var mAdapter : BalanceViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all)
        supportActionBar?.hide()
        tabAction = findViewById(R.id.tab_actionList)
        vp_list = findViewById(R.id.vp_list)
        setupViewPager(vp_list)

    }

    private fun setupViewPager(vpList: ViewPager?) {
        mAdapter = BalanceViewPagerAdapter(supportFragmentManager)
        mAdapter.addFrag(ListAllFragment(), "SEMUA")
        mAdapter.addFrag(ListInFragment(), "MASUK")
        mAdapter.addFrag(ListOutFragment(), "KELUAR")
        vp_list.adapter = mAdapter
        vp_list.offscreenPageLimit = 1
        tabAction.setupWithViewPager(vpList)
    }
}