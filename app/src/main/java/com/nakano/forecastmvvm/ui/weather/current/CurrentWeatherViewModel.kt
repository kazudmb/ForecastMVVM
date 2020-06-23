package com.nakano.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel
import com.nakano.forecastmvvm.data.internal.UnitSystem
import com.nakano.forecastmvvm.data.internal.lazyDeferred
import com.nakano.forecastmvvm.data.repository.ForecastRepository

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC //get from settings later

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}