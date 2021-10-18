package com.example.sharedpreferencesbonus


import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var tv2 : TextView
    lateinit var bt: Button
    private lateinit var SHPFS: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tv2 = findViewById(R.id.textView)
        bt=findViewById(R.id.button3)
        SHPFS = this.getSharedPreferences(
            getString(R.string.preference_file_key), MODE_PRIVATE
        )
        val str1 = intent.getStringExtra("fname")
        val str2 = intent.getStringExtra("lname")
        tv2.text="$str1 $str2"


        bt.setOnClickListener {
       val str3= SHPFS.getString("name","")
            tv2.text="$str3"

        }



    }
}