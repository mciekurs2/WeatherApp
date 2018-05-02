package com.mciekurs.materialdesign

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*
import java.text.SimpleDateFormat
import java.util.*


class MainAdapter (val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    //number of items
    override fun getItemCount(): Int {
        return  homeFeed.list.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val titles = titles[position]
        val weather = homeFeed.list[position]
        holder.view.textView_title.text = weather.main.temp + "°C"
        holder.view.textView_text.text = weather.main.humidity + "%"


        val temp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(weather.dt_txt)
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault()).format(temp)

        holder.view.textView_time.text = sdf

        val weatherIconImageView = holder.view.imageView_weatherIcon
        val iconURL = "http://openweathermap.org/img/w/" + weather.weather[0].icon +".png"
        Picasso.get().load(iconURL).resize(150, 150).centerCrop().into(weatherIconImageView)



    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view)














