package com.nakano.forecastmvvm.data.repository

import androidx.lifecycle.LiveData
import com.nakano.forecastmvvm.data.db.entity.WeatherLocation
import com.nakano.forecastmvvm.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}