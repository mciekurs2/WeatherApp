package com.mciekurs.materialdesign

/**Today json*/
class TodayJson(val weather: List<WeatherToday>, val main: MainToday)

class WeatherToday(val description: String, val icon: String)

class MainToday(val temp: String)



/**Weekly json*/
class HomeFeed(val list: List<WeatherInfo>)

class WeatherInfo(val main: Main, val weather: List<Weather>, val dt_txt: String)

class Weather(val icon: String)

class Main(val temp: String, val humidity: String)


