package com.mciekurs.materialdesign.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mciekurs.materialdesign.MainActivity
import com.mciekurs.materialdesign.R


class FragmentMain: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)

        val activity = activity as MainActivity?
        activity!!.getJsonToday("weather")

        return rootView
    }


}