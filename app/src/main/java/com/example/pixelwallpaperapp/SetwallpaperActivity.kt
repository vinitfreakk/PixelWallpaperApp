package com.example.pixelwallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class SetwallpaperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper)
        val url = intent.getStringExtra("image")
        val imageview = findViewById<ImageView>(R.id.largeimage)
        val btn = findViewById<Button>(R.id.apply)

        Glide.with(this).load(url).into(imageview)
        btn.setOnClickListener {

        }

    }
}