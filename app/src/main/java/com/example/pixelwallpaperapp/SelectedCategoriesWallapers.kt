package com.example.pixelwallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pixelwallpaperapp.Adapters.WallpaperAdapter
import com.example.pixelwallpaperapp.Api.ApiInterface
import com.example.pixelwallpaperapp.Api.ApiUtilites
import com.example.pixelwallpaperapp.Repository.WallpaperRepository
import com.example.pixelwallpaperapp.ViewModels.WallpaperViewModelFactory
import com.example.pixelwallpaperapp.ViewModels.WallpaperViewsModel
import com.example.pixelwallpaperapp.Models.Photo

class SelectedCategoriesWallapers : AppCompatActivity() {
lateinit var wallpaperRepository: WallpaperRepository
lateinit var wallpaperViewsModel: WallpaperViewsModel
lateinit var recyclerView:RecyclerView
    lateinit var wallpaperAdapter: WallpaperAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_categories_wallapers)
        val categories  = intent.getStringExtra("categories")
        val txtView = findViewById<TextView>(R.id.textView3)
        recyclerView = findViewById(R.id.recyclerViewse)
        txtView.text = categories

        val apiInterface = ApiUtilites.getRetrofitInstance().create(ApiInterface::class.java)
        wallpaperRepository = WallpaperRepository(apiInterface)
        /*wallpaperViewsModel.fetchWallpapers(categories.toString())*/
        wallpaperViewsModel = ViewModelProvider(this,WallpaperViewModelFactory(wallpaperRepository,categories.toString())).get(WallpaperViewsModel::class.java)//instance edhar ban raha gandu


        wallpaperViewsModel.wallpaper.observe(this,{
            val response = it.photos
            val list = response as ArrayList<Photo>
            list.shuffle()
            wallpaperAdapter = WallpaperAdapter(list,this)
            recyclerView.adapter = wallpaperAdapter
            recyclerView.layoutManager = GridLayoutManager(this,2)

        })



    }
}