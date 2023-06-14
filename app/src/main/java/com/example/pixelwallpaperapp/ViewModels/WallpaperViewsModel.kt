package com.example.pixelwallpaperapp.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixelwallpaperapp.Models.Wallpapers
import com.example.pixelwallpaperapp.Repository.WallpaperRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WallpaperViewsModel(private val wallpaperRepository: WallpaperRepository,val value:String):ViewModel() {
    val wallpaper: LiveData<Wallpapers>
        get()=wallpaperRepository.liveData

    init {
        fetchWallpapers(value)
    }

    fun fetchWallpapers(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            wallpaperRepository.getwallpapersfromWallpaperRepository(value)
        }
    }
}

