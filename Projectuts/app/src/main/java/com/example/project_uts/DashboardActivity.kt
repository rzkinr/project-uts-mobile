package com.example.project_uts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        data_penduduk.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        tambah_penduduk.setOnClickListener(){
            val intent = Intent(this, TambahActivity::class.java)
            startActivity(intent)
        }

        keluar.setOnClickListener(){
            val sharedPreferences=getSharedPreferences("ceklogin", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }
}
