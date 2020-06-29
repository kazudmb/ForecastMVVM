package com.nakano.forecastmvvm.data.network.response

import com.google.gson.annotations.SerializedName
import com.nakano.forecastmvvm.data.db.entity.CurrentWeatherEntry
import com.nakano.forecastmvvm.data.db.entity.WeatherLocation
import com.nakano.forecastmvvm.data.db.entity.Request


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: WeatherLocation,
    val request: Request
)