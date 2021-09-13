package com.example.imagedownloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgView: ImageView = findViewById<ImageView>(R.id.imgView)
        imgView.tag = "https://i.imgur.com/DjLKmgA.jpeg"
        val download = DownloadImageTask()
        download.execute(imgView)
    }
}