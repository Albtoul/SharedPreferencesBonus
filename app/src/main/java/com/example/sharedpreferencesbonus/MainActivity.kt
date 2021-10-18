package com.example.sharedpreferencesbonus

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var ed1:EditText
    lateinit var ed2:EditText
    lateinit var bt1:Button
    lateinit var bt2:Button
    private lateinit var SHPFS: SharedPreferences
    var names =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1=findViewById(R.id.editTextTextPersonName)
        ed2=findViewById(R.id.editTextTextPersonName2)
        bt1=findViewById(R.id.button)
        bt2=findViewById(R.id.button2)
        SHPFS = this.getSharedPreferences(
            getString(R.string.preference_file_key), MODE_PRIVATE
        )

            bt1.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
               intent.putExtra("fname" , ed1.text.toString())
                 intent.putExtra("lname" , ed2.text.toString())
                startActivity(intent)

            }
        bt2.setOnClickListener {
            names="${ed1.text}${ed2.text} "
            save()
}

    }

    private fun save() {
        with(SHPFS.edit()) {
         val sh=  putString("name",names)
            apply()
            Toast.makeText(applicationContext,"save it in shpfs",Toast.LENGTH_SHORT).show()
        }
    }



}