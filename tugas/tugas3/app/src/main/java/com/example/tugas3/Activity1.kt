package com.example.tugas3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_1.*

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        BtnIntentUtama1.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val bobiObjek: Intent = intent
        val masukAkhir = bobiObjek.getStringExtra("impor")
        textView.text = "Hey $masukAkhir"
    }
}
