package com.nakano.forecastmvvm.ui.weather.current

import androidx.lifecycle.ViewModel
import com.nakano.forecastmvvm.data.provider.UnitProvider
import com.nakano.forecastmvvm.internal.UnitSystem
import com.nakano.forecastmvvm.internal.lazyDeferred
import com.nakano.forecastmvvm.data.repository.ForecastRepository

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}