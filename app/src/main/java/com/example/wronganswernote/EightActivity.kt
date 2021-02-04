package com.example.wronganswernote

import android.app.Activity
import android.content.Intent
import android.graphics.ColorFilter
import android.graphics.ColorMatrixColorFilter
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class EightActivity : AppCompatActivity() {
    private val OPEN_GALLERY = 1
    var checking : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight)

        val adView = findViewById<AdView>(R.id.adView)
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111")
        adView.loadAd(AdRequest.Builder().build())

        val currentDateTime = Calendar.getInstance().time
        var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA).format(currentDateTime)
        val nowtime = findViewById<TextView>(R.id.nowtime)
        nowtime.text = dateFormat

        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)
        val imageView7 = findViewById<ImageView>(R.id.imageView7)
        val imageView8 = findViewById<ImageView>(R.id.imageView8)
        imageView.setOnClickListener{
            checking = 1
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView.setOnLongClickListener(View.OnLongClickListener {
            setBlackAndWhite(imageView)
            true
        })
        imageView2.setOnClickListener{
            checking = 2
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView2.setOnLongClickListener(View.OnLongClickListener {
            setBlackAndWhite(imageView2)
            true
        })
        imageView3.setOnClickListener{
            checking = 3
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView3.setOnLongClickListener(View.OnLongClickListener {
            setBlackAndWhite(imageView3)
            true
        })
        imageView4.setOnClickListener{
            checking = 4
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView4.setOnLongClickListener(View.OnLongClickListener {
            setBlackAndWhite(imageView4)
            true
        })
        imageView5.setOnClickListener{
            checking = 5
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView5.setOnLongClickListener(View.OnLongClickListener {
            setBlackAndWhite(imageView5)
            true
        })
        imageView6.setOnClickListener{
            checking = 6
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView6.setOnLongClickListener(View.OnLongClickListener {
            setBlackAndWhite(imageView6)
            true
        })
        imageView7.setOnClickListener{
            checking = 7
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView7.setOnLongClickListener(View.OnLongClickListener {
            setBlackAndWhite(imageView7)
            true
        })
        imageView8.setOnClickListener{
            checking = 8
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        imageView8.setOnLongClickListener(View.OnLongClickListener {
            setBlackAndWhite(imageView8)
            true
        })
        val cancel_8 = findViewById<Button>(R.id.cancel_8)
        cancel_8.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val flat_logo8 = findViewById<ImageView>(R.id.flat_logo8)
        flat_logo8.setOnClickListener{
            val popupMenu: PopupMenu = PopupMenu(this, flat_logo8)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.item1 ->
                        Toast.makeText(this, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.item2 ->
                        Toast.makeText(this, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                    R.id.item3 ->
                        Toast.makeText(this, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
                }
                true
            })
            popupMenu.show()
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
                    val imageView3 = findViewById<ImageView>(R.id.imageView3)
                    val imageView4 = findViewById<ImageView>(R.id.imageView4)
                    val imageView5 = findViewById<ImageView>(R.id.imageView5)
                    val imageView6 = findViewById<ImageView>(R.id.imageView6)
                    val imageView7 = findViewById<ImageView>(R.id.imageView7)
                    val imageView8 = findViewById<ImageView>(R.id.imageView8)
                    when(checking){
                        1 -> imageView.setImageBitmap(bitmap)
                        2 -> imageView2.setImageBitmap(bitmap)
                        3 -> imageView3.setImageBitmap(bitmap)
                        4 -> imageView4.setImageBitmap(bitmap)
                        5 -> imageView5.setImageBitmap(bitmap)
                        6 -> imageView6.setImageBitmap(bitmap)
                        7 -> imageView7.setImageBitmap(bitmap)
                        8 -> imageView8.setImageBitmap(bitmap)
                    }
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        } else {
            Log.d("ActivityResult", "something wrong")
        }
    }
    private fun setBlackAndWhite(iv: ImageView?) {
        val colorMatrix = floatArrayOf(
            0.33f, 0.33f, 0.33f, 0f, 70f,  //red
            0.33f, 0.33f, 0.33f, 0f, 70f,  //green
            0.33f, 0.33f, 0.33f, 0f, 70f,
            0f, 0f, 0f, 1f, 0f
        )
        val colorFilter: ColorFilter = ColorMatrixColorFilter(colorMatrix)
        iv!!.colorFilter = colorFilter
    }
}