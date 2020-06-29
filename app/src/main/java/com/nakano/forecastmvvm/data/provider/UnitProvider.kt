package com.nakano.forecastmvvm.data.provider

import com.nakano.forecastmvvm.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}