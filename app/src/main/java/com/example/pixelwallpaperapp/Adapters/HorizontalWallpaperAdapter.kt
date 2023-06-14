package com.example.pixelwallpaperapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pixelwallpaperapp.R
import com.example.pixelwallpaperapp.SelectedCategoriesWallapers

class HorizontalWallpaperAdapter(val context: Context, val list: List<Int> , val nameList:List<String>) :
    RecyclerView.Adapter<HorizontalWallpaperAdapter.MyviewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.itemshorizontal,parent,false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position]).into(holder.imageView)
        holder.imageView.setOnClickListener{
           val intent = Intent(context,SelectedCategoriesWallapers::class.java)
            intent.putExtra("categories",nameList[position])
            context.startActivity(intent)
        }
    }

    class MyviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView
        init {
            imageView = itemView.findViewById(R.id.categoriesImg)
        }

    }
}