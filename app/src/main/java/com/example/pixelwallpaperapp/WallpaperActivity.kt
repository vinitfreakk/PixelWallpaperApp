package com.example.pixelwallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class WallpaperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper)
        val url = intent.getStringExtra("image")
        val imageview = findViewById<ImageView>(R.id.largeimage)

        Glide.with(this).load(url).into(imageview)
    }
}