package com.DapulO.wronganswernote.page

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import com.DapulO.wronganswernote.*
import com.DapulO.wronganswernote.screenshot.Screenshot
import com.DapulO.wronganswernote.screenshot.Sharescreenshot
import com.DapulO.wronganswernote.screenshot.Showscreenshot
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.io.File
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class FourActivity : AppCompatActivity() {

    private val OPEN_GALLERY = 1
    var checking : Int = 0
    lateinit var sharedPreferences: SharedPreferences

    lateinit var screenshot : Screenshot
    lateinit var sharescreenshot: Sharescreenshot
    lateinit var constsView : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)

        val adView = findViewById<AdView>(R.id.adView)
        MobileAds.initialize(this, "ca-app-pub-9542671839226052/5125253846")
        adView.loadAd(AdRequest.Builder().build())

        constsView = findViewById(R.id.ConstsView4)
        screenshot = Screenshot(this)
        sharescreenshot = Sharescreenshot()

        val currentDateTime = Calendar.getInstance().time
        var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA).format(currentDateTime)
        val nowtime = findViewById<TextView>(R.id.nowtime)
        nowtime.text = dateFormat

        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        imageView.setOnClickListener{
            checking = 1
            App.four_count++
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        var angle = 0f
        var angle2 = 0f
        imageView.setOnLongClickListener(View.OnLongClickListener {
            val popupMenu: PopupMenu = PopupMenu(this, imageView)
            popupMenu.menuInflater.inflate(R.menu.image_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.filter -> {
                        setBlackAndWhite(imageView)
                    }
                    R.id.rotate1 ->{
                        imageView.rotation = 90f + angle
                        angle += 90f
                    }
                    R.id.rotate2 ->{
                        imageView.rotation = 180f + angle2
                        angle2 -= 180f
                    }
                }
                true
            })
            popupMenu.show()
            true
        })
        imageView2.setOnClickListener{
            checking = 2
            App.four_count++
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        var angle3 = 0f
        var angle4 = 0f
        imageView2.setOnLongClickListener(View.OnLongClickListener {
            val popupMenu: PopupMenu = PopupMenu(this, imageView2)
            popupMenu.menuInflater.inflate(R.menu.image_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.filter -> {
                        setBlackAndWhite(imageView2)
                    }
                    R.id.rotate1 ->{
                        imageView2.rotation = 90f + angle3
                        angle3 += 90f
                    }
                    R.id.rotate2 ->{
                        imageView2.rotation = 180f + angle4
                        angle4 -= 180f
                    }
                }
                true
            })
            popupMenu.show()
            true
        })
        imageView3.setOnClickListener{
            checking = 3
            App.four_count++
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        var angle5 = 0f
        var angle6 = 0f
        imageView3.setOnLongClickListener(View.OnLongClickListener {
            val popupMenu: PopupMenu = PopupMenu(this, imageView3)
            popupMenu.menuInflater.inflate(R.menu.image_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.filter -> {
                        setBlackAndWhite(imageView3)
                    }
                    R.id.rotate1 ->{
                        imageView3.rotation = 90f + angle5
                        angle5 += 90f
                    }
                    R.id.rotate2 ->{
                        imageView3.rotation = 180f + angle6
                        angle6 -= 180f
                    }
                }
                true
            })
            popupMenu.show()
            true
        })

        imageView4.setOnClickListener{
            checking = 4
            App.four_count++
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*")
            startActivityForResult(intent, OPEN_GALLERY)
        }
        var angle7 = 0f
        var angle8 = 0f
        imageView4.setOnLongClickListener(View.OnLongClickListener {
            val popupMenu: PopupMenu = PopupMenu(this, imageView4)
            popupMenu.menuInflater.inflate(R.menu.image_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.filter -> {
                        setBlackAndWhite(imageView4)
                    }
                    R.id.rotate1 ->{
                        imageView4.rotation = 90f + angle7
                        angle7 += 90f
                    }
                    R.id.rotate2 ->{
                        imageView4.rotation = 180f + angle8
                        angle8 -= 180f
                    }
                }
                true
            })
            popupMenu.show()
            true
        })

        val cancel_4 = findViewById<Button>(R.id.cancel_4)
        cancel_4.setOnClickListener{
            finish()
        }

        val flat_logo4 = findViewById<ImageView>(R.id.flat_logo4)
        flat_logo4.setOnClickListener{
            val popupMenu: PopupMenu = PopupMenu(this, flat_logo4)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when(item.itemId) {
                    R.id.item1 -> {
                        ambilscreenshot(constsView)
                        Toast.makeText(this, "시험지가 저장되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                    R.id.item2 ->{
                        lihatfilescreenshot()
                    }
                    R.id.item3 ->{
                        bagiscreenshot()
                        App.four_clicked++
                    }
                }
                true
            })
            popupMenu.show()
        }

        if (App.four_count > 2 || App.four_clicked == 1) {
            App.TotalCount++
            sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("CNT", App.TotalCount)
            editor.apply()
            App.four_clicked = 0
            App.four_count = 0
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (App.four_count > 2 || App.four_clicked == 1) {
            App.TotalCount++
            sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("CNT", App.TotalCount)
            editor.apply()
            App.four_clicked = 0
            App.four_count = 0
        }
    }

    override fun onPause() {
        super.onPause()
        if (App.four_count > 2 || App.four_clicked == 1) {
            App.TotalCount++
            sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("CNT", App.TotalCount)
            editor.apply()
            App.four_clicked = 0
            App.four_count = 0
        }
    }

    fun ambilscreenshot(view: View) {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val bgDrawable: Drawable = view.background
        bgDrawable.draw(canvas)
        view.draw(canvas)

        bitmap?.let { screenshot.saveScreenshot(it) }
    }

    fun bagiscreenshot() {
        val fileScreenshot = File(this.getExternalFilesDir(null)!!.absolutePath + "/Screenshot/Screenshot.jpg")
        startActivity(sharescreenshot.ShareFileScreenshot(fileScreenshot))
    }

    fun lihatfilescreenshot(){
        startActivity(Intent(this, Showscreenshot::class.java))
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
                    when(checking){
                        1 -> imageView.setImageBitmap(bitmap)
                        2 -> imageView2.setImageBitmap(bitmap)
                        3 -> imageView3.setImageBitmap(bitmap)
                        4 -> imageView4.setImageBitmap(bitmap)
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