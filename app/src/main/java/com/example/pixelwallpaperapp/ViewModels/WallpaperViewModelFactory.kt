package com.example.pixelwallpaperapp.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pixelwallpaperapp.Repository.WallpaperRepository

class WallpaperViewModelFactory(private val wallpaperRepository: WallpaperRepository,val value:String):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WallpaperViewsModel(wallpaperRepository,value) as T
    }

}