package com.mciekurs.materialdesign


class HomeFeed(val list: List<WeatherInfo>)

class WeatherInfo(val main: Main, val weather: List<Weather>, val dt_txt: String)

class Weather(val icon: String)

class Main(val temp: String, val humidity: String)


