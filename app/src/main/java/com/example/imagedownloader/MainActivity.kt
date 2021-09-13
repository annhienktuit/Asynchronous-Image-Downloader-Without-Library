package com.example.imagedownloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imgView: ImageView = findViewById<ImageView>(R.id.imgView)
        val edtURL:EditText = findViewById<EditText>(R.id.edtURL)
        val btnDownload = findViewById<Button>(R.id.btnDownload)
        val download = DownloadImageTask()
        val thread = Thread.currentThread()
        Log.i("MainActivity: ","Main Activity is running on thread ${thread.id}")
        btnDownload.setOnClickListener {
            if(edtURL.text.isNotBlank()){
                imgView.tag = edtURL.text.toString()
                download.execute(imgView)
            }
            else {
                Toast.makeText(this, "Please enter URL!",Toast.LENGTH_LONG).show()
            }
        }

    }
}