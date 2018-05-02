package com.mciekurs.materialdesign

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

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

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val titles = titles[position]
        val weather = homeFeed.list[position]
        holder.view.textView_title.text = weather.main.temp + "°C"
        holder.view.textView_text.text = weather.main.humidity + "%"
        holder.view.textView_time.text = weather.dt_txt

        val weatherIconImageView = holder.view.imageView_weatherIcon
        val iconURL = "http://openweathermap.org/img/w/" + weather.weather[0].icon +".png"
        Picasso.get().load(iconURL).resize(150, 150).centerCrop().into(weatherIconImageView)



    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view)














