package com.example.pixelwallpaperapp.Repository

import android.app.DownloadManager.Query
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pixelwallpaperapp.Api.ApiInterface
import com.example.pixelwallpaperapp.Models.Wallpapers

class WallpaperRepository(private val apiInterface: ApiInterface) {
    private val mutableLiveData = MutableLiveData<Wallpapers>()

            val liveData:LiveData<Wallpapers>
                get() = mutableLiveData

    suspend fun getwallpapersfromWallpaperRepository(query: String){
        val result = apiInterface.getWallapers(query=query)
         if(result.body()!=null){
            mutableLiveData.postValue(result.body())
         }
    }
}