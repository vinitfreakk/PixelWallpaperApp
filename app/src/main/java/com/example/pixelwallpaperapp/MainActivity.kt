package com.example.pixelwallpaperapp

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pixelwallpaperapp.Adapters.HorizontalWallpaperAdapter
import com.example.pixelwallpaperapp.Adapters.WallpaperAdapter
import com.example.pixelwallpaperapp.Api.ApiInterface
import com.example.pixelwallpaperapp.Api.ApiUtilites
import com.example.pixelwallpaperapp.Models.Photo
import com.example.pixelwallpaperapp.Repository.WallpaperRepository
import com.example.pixelwallpaperapp.ViewModels.WallpaperViewModelFactory
import com.example.pixelwallpaperapp.ViewModels.WallpaperViewsModel

class MainActivity : AppCompatActivity() {
    lateinit var wallpaperViewsModel: WallpaperViewsModel
    lateinit var wallpaperAdapter: WallpaperAdapter
    lateinit var horizontalWallpaperAdapter: HorizontalWallpaperAdapter
   lateinit var  recyclerView:RecyclerView
   lateinit var recyclerView1:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        recyclerView1 = findViewById<RecyclerView>(R.id.recyclerViewHOR)
        val search = findViewById<Button>(R.id.imageButton)
        val searchTxt = findViewById<TextView>(R.id.editTextText)

        //code for horizontal recyclerview
        val numbers = mutableListOf(R.drawable.toon,R.drawable.code,R.drawable.krishna,R.drawable.love,R.drawable.maldives,R.drawable.nature,R.drawable.bike)
        val names = mutableListOf("Cartoon","Code","Krishna","Love","Maldives","Nature","Bike")
        horizontalWallpaperAdapter = HorizontalWallpaperAdapter(this,numbers,names)
        recyclerView1.adapter = horizontalWallpaperAdapter
        recyclerView1.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)



        //code for fetching wallpaper from api and displaying it in recyclerview
        search.setOnClickListener {
           val txtxSearch = searchTxt.text.toString()
            wallpaperViewsModel.fetchWallpapers(txtxSearch)

        }
           val apiInterface =ApiUtilites.getRetrofitInstance().create(ApiInterface::class.java)
           val wallpaperRepository = WallpaperRepository(apiInterface)

           wallpaperViewsModel = ViewModelProvider(this,WallpaperViewModelFactory(wallpaperRepository,"cars")).get(WallpaperViewsModel::class.java)//instance edhar ban raha gandu

           wallpaperViewsModel.wallpaper.observe(this,{
              val response = it.photos
               val list = response as ArrayList<Photo>
               if(list!= emptyList<Photo>()){
                   list.shuffle()
                   wallpaperAdapter = WallpaperAdapter(list,this)
                   recyclerView.adapter = wallpaperAdapter
                   recyclerView.layoutManager = GridLayoutManager(this@MainActivity,2)
               }else{
                   Toast.makeText(this@MainActivity, "No Result Found", Toast.LENGTH_SHORT).show()
               }

           })
    }

}