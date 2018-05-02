package com.mciekurs.materialdesign

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        getJson()

    }

    private fun getJson(){

        val url = "http://api.openweathermap.org/data/2.5/forecast?q=Cesis&units=metric&appid=65b9e5e5bf3289000b4d663073142565"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                //.string NOT toString
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(homeFeed)
                }

            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed!")
            }
        })



    }
}
