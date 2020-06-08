package com.nakano.forecastmvvm.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.nakano.forecastmvvm.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "e60faa65545ff9be6c5be27144d7fab1"

// http://api.weatherstack.com/current?access_key=e60faa65545ff9be6c5be27144d7fab1&query=London&Lang=en

interface ApixuWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String,
        @Query("lang") language: String = "en"
    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(): ApixuWeatherApiService {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)
        }
    }
}