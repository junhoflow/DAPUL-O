package com.example.wronganswernote

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class TwoActivity : AppCompatActivity() {

    private val OPEN_GALLERY = 1
    var checking : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val currentDateTime = Calendar.getInstance().time
        var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA).format(currentDateTime)
        val nowtime = findViewById<TextView>(R.id.nowtime)
        nowtime.text = dateFormat

        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView.setOnClickListener{
            checking = 1
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView2.setOnClickListener{
            checking = 2
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }

        val cancel_2 = findViewById<Button>(R.id.cancel_2)
        cancel_2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY){
                var currentImageUrl : Uri? = data?.data

                try{
                    val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, currentImageUrl)
                    val imageView = findViewById<ImageView>(R.id.imageView)
                    val imageView2 = findViewById<ImageView>(R.id.imageView2)
                    when(checking){
                        1 -> imageView.setImageBitmap(bitmap)
                        2 -> imageView2.setImageBitmap(bitmap)
                    }
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        } else {
            Log.d("ActivityResult", "something wrong")
        }
    }
}