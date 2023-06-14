package com.example.pixelwallpaperapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pixelwallpaperapp.Models.Photo
import com.example.pixelwallpaperapp.R
import com.example.pixelwallpaperapp.WallpaperActivity

class WallpaperAdapter(val list:ArrayList<Photo>,val context: Context):RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
            val view =LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return WallpaperHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WallpaperHolder, position: Int) {
         Glide.with(holder.itemView).load(list[position].src.portrait).into(holder.imageview)
        holder.itemView.setOnClickListener {
            val intent : Intent = Intent(context,WallpaperActivity::class.java)
            intent.putExtra("image",list[position].src.portrait)
            context.startActivity(intent)
        }
    }

    class WallpaperHolder(itemView : View):RecyclerView.ViewHolder(itemView){
         var imageview:ImageView
         init {
             imageview = itemView.findViewById(R.id.wallpaper)
         }
    }
}