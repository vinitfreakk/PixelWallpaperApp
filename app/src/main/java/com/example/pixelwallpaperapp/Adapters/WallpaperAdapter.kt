package com.example.pixelwallpaperapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pixelwallpaperapp.Models.Photo
import com.example.pixelwallpaperapp.R

class WallpaperAdapter(val list:ArrayList<Photo>,val context: Context):RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder>() {

     /* var list = ArrayList<Photo>()
    lateinit var context: Context

    fun setWallpaper(list:ArrayList<Photo>,context: Context){
        this.list = list
        this.context = context
        notifyDataSetChanged()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
            val view =LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return WallpaperHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WallpaperHolder, position: Int) {
         Glide.with(holder.itemView).load(list[position].src.portrait).into(holder.imageview)
    }

    class WallpaperHolder(itemView : View):RecyclerView.ViewHolder(itemView){
         var imageview:ImageView
         init {
             imageview = itemView.findViewById(R.id.wallpaper)
         }
    }
}