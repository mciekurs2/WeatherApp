package com.mciekurs.materialdesign.fragments

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class FragmentAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> FragmentMain()
            else -> FragmentDetail()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}