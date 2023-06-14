package com.example.pixelwallpaperapp.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilites {
    val BASE_URL = " https://api.pexels.com/v1/"

    fun getRetrofitInstance():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}