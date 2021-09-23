package com.example.imagedownloader

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("lifecycle: ","OnCreate")
        val imgView: ImageView = findViewById<ImageView>(R.id.imgView)
        val edtURL:EditText = findViewById<EditText>(R.id.edtURL)
        val btnDownload = findViewById<Button>(R.id.btnDownload)
        val btnLottie = findViewById<Button>(R.id.btnLottie)
        val btnAlert = findViewById<Button>(R.id.btnAlert)
        val thread = Thread.currentThread()
        Log.i("MainActivity: ","Main Activity is running on thread ${thread.id}")
        btnDownload.setOnClickListener {
            if(edtURL.text.isNotBlank()){
                val download = DownloadImageTask()
                imgView.tag = edtURL.text.toString()
                download.execute(imgView)
            }
            else {
                Toast.makeText(this, "Please enter URL!",Toast.LENGTH_LONG).show()
            }
        }
        btnLottie.setOnClickListener {
            val intent = Intent(this, LottieActivity::class.java)
            startActivity(intent)
        }
        btnAlert.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Do you want to close this application ?")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })
            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("AlertDialogExample")
            // show alert dialog
            alert.show()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle: ","OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle: ","OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle: ","OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifecycle: ","OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifecycle: ","OnDestroy")
    }
}