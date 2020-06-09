package com.nakano.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

data class ImperialCurrentWeatherEntry(
    @ColumnInfo(name = "temperature")
    override val temperature: Int,
//    @ColumnInfo(name = "weatherDescriptions")
//    override val conditionText: String,
//    @ColumnInfo(name = "weatherIcons")
//    override val conditionIconUrl: String,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Int,
    @ColumnInfo(name = "windDir")
    override val windDirection: String,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Int,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Int,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Int
) : UnitSpecificCurrentWeatherEntry