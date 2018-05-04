package com.mciekurs.materialdesign

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.google.gson.GsonBuilder
import com.mciekurs.materialdesign.fragments.FragmentAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.item_row.view.*
import okhttp3.*
import java.io.IOException
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = FragmentAdapter(supportFragmentManager)
        pager.adapter = adapter

    }

    fun getJsonWeekly( rw: RecyclerView, type: String){
        val url = "http://api.openweathermap.org/data/2.5/$type?q=Cesis&units=metric&appid=65b9e5e5bf3289000b4d663073142565"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                //.string NOT toString
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)
                runOnUiThread { rw.adapter = MainAdapter(homeFeed) }
            }
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed!")
            }
        })
    }

    fun getJsonToday(type: String){
        val url = "http://api.openweathermap.org/data/2.5/$type?q=Cesis&units=metric&appid=65b9e5e5bf3289000b4d663073142565"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call?, response: Response?) {
                //.string NOT toString
                val body = response?.body()?.string()
                val gson = GsonBuilder().create()
                val todayJson = gson.fromJson(body, TodayJson::class.java)

                runOnUiThread {
                    /*CurrentTemp*/
                    /*TODO: Need to change color*/
                    val value = todayJson.main.temp.toDouble()
                    val df = DecimalFormat("#")
                    textView_mainTemp.text = "${df.format(value)}°C"

                    /*CurrentImg*/
                    /*TODO: Need to change default icons */
                    val weatherIconImageView = imageView_mainIcon
                    val iconURL = "http://openweathermap.org/img/w/${todayJson.weather[0].icon}.png"
                    Picasso.get().load(iconURL).resize(200, 200).centerCrop().into(weatherIconImageView)

                }

                //runOnUiThread { rw.adapter = MainAdapter(todayJson) }
            }
            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed!")
            }
        })
    }


}
