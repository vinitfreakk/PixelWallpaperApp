package com.example.pixelwallpaperapp.Api

import com.example.pixelwallpaperapp.Models.Wallpapers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//GET https://api.pexels.com/v1/search
interface ApiInterface {
    @GET("search")
    suspend fun getWallapers(
        @Header("Authorization") apiKey: String = "dmcjCZCR13uRJ2D9r1GQgJqWiwfQRn2LwOUjfjF4K7qH0NNC7r7geyi4", /*The @Header("Authorization") annotation is used to specify
                                                                                                                that the apiKey parameter should be included as a header
                                                                                                                with the key "Authorization" in the API request.*/
        @Query("query") query: String,
        @Query("per_page") perpage: Int = 150
    ): Response<Wallpapers>
}