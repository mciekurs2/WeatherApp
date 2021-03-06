package com.mciekurs.materialdesign.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mciekurs.materialdesign.MainActivity
import com.mciekurs.materialdesign.R
import com.mciekurs.materialdesign.TodayJson

class FragmentDetail: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)

        val rw = rootView.findViewById(R.id.recyclerView_main) as RecyclerView
        rw.layoutManager = LinearLayoutManager(activity)

        val activity = activity as MainActivity?
        activity!!.getJsonWeekly(rw, "forecast")

        return rootView
    }

}