package com.DapulO.wronganswernote

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Showscreenshot : AppCompatActivity() {
    private lateinit var viewscreenshot : ImageView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showscreenshot)
        this.setTitle("Screenshot")

        viewscreenshot = findViewById(R.id.viewscreenshot)

        viewscreenshot.setImageBitmap(getFilescreenshot())
    }

    fun getFilescreenshot() : Bitmap{
        val fileScreenshot = this.getExternalFilesDir(null)!!.absolutePath + "/Screenshot/Screenshot.jpg"
        val screenshotBitmap = BitmapFactory.decodeFile(fileScreenshot)

        return screenshotBitmap
    }
}