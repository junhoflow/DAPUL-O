package com.DapulO_pro.wronganswernote

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.DapulO_pro.wronganswernote.page.*


class MainActivity : AppCompatActivity() {

    var todo: String = ""

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)


        val button_two = findViewById<Button>(R.id.button_two)
        val button_two_vertical = findViewById<Button>(R.id.button_two_vertical)
        val button_four = findViewById<Button>(R.id.button_four)
        val button_six = findViewById<Button>(R.id.button_six)
        val button_eight = findViewById<Button>(R.id.button_eight)
        button_two.setOnClickListener {
            val intent = Intent(this, TwoActivity::class.java)
            startActivity(intent)
        }
        button_two_vertical.setOnClickListener {
            val intent = Intent(this, TwoVerticalActivity::class.java)
            startActivity(intent)
        }
        button_four.setOnClickListener {
            val intent = Intent(this, FourActivity::class.java)
            startActivity(intent)
        }
        button_six.setOnClickListener {
            val intent = Intent(this, SixActivity::class.java)
            startActivity(intent)
        }
        button_eight.setOnClickListener {
            val intent = Intent(this, EightActivity::class.java)
            startActivity(intent)
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

            todo = todolist.text.toString()

            val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
            val editor: SharedPreferences.Editor = prefs.edit()

            editor.putString("todo", todo)
            editor.apply();

            Toast.makeText(this, "저장되었습니다", Toast.LENGTH_SHORT).show()
        }

    }
}
