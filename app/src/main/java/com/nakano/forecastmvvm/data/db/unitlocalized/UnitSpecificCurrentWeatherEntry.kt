package com.nakano.forecastmvvm.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature: Int
    val conditionText: String
    val conditionIconUrl: String
    val windSpeed: Int
    val windDirection: String
    val precipitationVolume: Int
    val feelsLikeTemperature: Int
    val visibilityDistance: Int
}