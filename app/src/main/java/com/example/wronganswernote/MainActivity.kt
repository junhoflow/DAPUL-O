package com.example.wronganswernote

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.preference.PreferenceManager
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import java.lang.Integer.parseInt


class MainActivity : AppCompatActivity() {

    var todo: String = ""
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var mRewardedAd: RewardedAd


    lateinit var preferences: SharedPreferences
    var isRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this)
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        mRewardedAd = RewardedAd(this, "ca-app-pub-3940256099942544/5224354917")

        val rewardAd_btn = findViewById<Button>(R.id.rewardAd_btn)
        val progressbar = findViewById<ProgressBar>(R.id.progressBar)
        val adLoadCallback = object : RewardedAdLoadCallback() {
            override fun onRewardedAdLoaded() {
                super.onRewardedAdLoaded()
                progressbar.visibility = GONE
                rewardAd_btn.visibility = VISIBLE
            }
        }
        mRewardedAd.loadAd(AdRequest.Builder().build(), adLoadCallback)

        val adView = findViewById<AdView>(R.id.adView)
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111")
        adView.loadAd(AdRequest.Builder().build())


        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)


        val button_two = findViewById<Button>(R.id.button_two)
        val button_four = findViewById<Button>(R.id.button_four)
        val button_six = findViewById<Button>(R.id.button_six)
        val button_eight = findViewById<Button>(R.id.button_eight)
        button_two.setOnClickListener {
            if(App.restricted == 0) {
                val intent = Intent(this, TwoActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "횟수가 부족합니다. 광고시청 혹은 다풀오PRO버전을 이용해보세요!", Toast.LENGTH_SHORT).show()
            }
        }
        button_four.setOnClickListener {
            if(App.restricted == 0) {
                val intent = Intent(this, FourActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "횟수가 부족합니다. 광고시청 혹은 다풀오PRO버전을 이용해보세요!", Toast.LENGTH_SHORT).show()
            }
        }
        button_six.setOnClickListener {
            if(App.restricted == 0) {
                val intent = Intent(this, SixActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "횟수가 부족합니다. 광고시청 혹은 다풀오PRO버전을 이용해보세요!", Toast.LENGTH_SHORT).show()
            }
        }
        button_eight.setOnClickListener {
            if(App.restricted == 0) {
                val intent = Intent(this, EightActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "횟수가 부족합니다. 광고시청 혹은 다풀오PRO버전을 이용해보세요!", Toast.LENGTH_SHORT).show()
            }
        }

        val howto_btn = findViewById<Button>(R.id.howto_btn)
        howto_btn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.howto_popup, null)
            val button = dialogView.findViewById<Button>(R.id.cancel)
            builder.setView(dialogView).show()

            button.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        val bug_btn = findViewById<Button>(R.id.bug_btn)
        bug_btn.setOnClickListener {
            val email = Intent(Intent.ACTION_SEND)
            email.type = "plain/text"
            val address = arrayOf("tikibird@naver.com")
            email.putExtra(Intent.EXTRA_EMAIL, address)
            email.putExtra(Intent.EXTRA_SUBJECT, "<======= ⭕다풀오⭕ 개발자에게 메일보내기 ======>")
            email.putExtra(
                Intent.EXTRA_TEXT,
                "앱 버전: ${BuildConfig.VERSION_NAME}\nAndroid(SDK): ${Build.VERSION.SDK_INT}\n 핸드폰 기종: \n 내용:"
            )
            startActivity(email)
        }
        val saving_btn = findViewById<Button>(R.id.saving_btn)
        val todolist = findViewById<EditText>(R.id.todolist)
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var st = prefs.getString("todo", "")
        todolist?.setText(st)


        saving_btn.setOnClickListener {

            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()
            }

            todo = todolist.text.toString()

            val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
            val editor: SharedPreferences.Editor = prefs.edit()

            editor.putString("todo", todo)
            editor.apply();

            Toast.makeText(this, "저장되었습니다", Toast.LENGTH_SHORT).show()
        }

        isRunning = true
        var thread = ThreadClass()
        thread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }

    inner class ThreadClass : Thread() {
        override fun run() {
            while (isRunning) {
                SystemClock.sleep(100)
                val cnt = preferences.getInt("CNT", 0)
                App.TotalCount = cnt
                var counting = findViewById<TextView>(R.id.counting)
                var math: Int = 15 - cnt
                runOnUiThread {
                    counting.text = "$math"

                    if(math == 0 || math < 0){
                        counting.text = "0"
                        App.restricted++
                    } else {
                        App.restricted = 0
                    }
                }

            }
        }
    }

}
