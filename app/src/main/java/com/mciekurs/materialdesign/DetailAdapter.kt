package com.mciekurs.materialdesign

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class MainAdapter (private val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_row, parent, false)
        return CustomViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val titles = titles[position]
        val weather = homeFeed.list[position]

        val value = weather.main.temp.toDouble()
        val df = DecimalFormat("#")

        holder.view.textView_title.text = "${df.format(value)}°C"
        holder.view.textView_text.text = weather.main.humidity + "%"


        //can get days by calling temp.day
        val temp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(weather.dt_txt)
        val sdf = SimpleDateFormat("EEEE HH:mm", Locale.getDefault()).format(temp)

        holder.view.textView_time.text = sdf

        //gets weather icon img
        val weatherIconImageView = holder.view.imageView_weatherIcon
        val iconURL = "http://openweathermap.org/img/w/" + weather.weather[0].icon +".png"
        Picasso.get().load(iconURL).resize(150, 150).centerCrop().into(weatherIconImageView)


    }

    //number of items
    override fun getItemCount() = homeFeed.list.count()

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view)














