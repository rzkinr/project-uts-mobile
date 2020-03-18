package com.example.tugas3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnIntent1.setOnClickListener {
            val intentPlusData = Intent(this, Activity1::class.java)
            val nameKotak: String = inputText1.text.toString()
            intentPlusData.putExtra("impor",nameKotak)
            startActivity(intentPlusData)
        }

        BtnIntent2.setOnClickListener{
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)

        }
    }
}
