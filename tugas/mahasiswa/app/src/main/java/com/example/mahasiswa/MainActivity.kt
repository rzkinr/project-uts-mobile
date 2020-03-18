package com.example.mahasiswa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getdata()

        floating_action_button.setOnClickListener(){
            startActivity(Intent(this,TambahActivity::class.java))
            finish()
        }

        btn_keluar.setOnClickListener(){
            val sharedPreferences=getSharedPreferences("ceklogin", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
    }

    fun getdata(){
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val mhs = ArrayList<mahasiswa>()

        AndroidNetworking.get("https://mhs-data.000webhostapp.com/mahasiswa-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_mahasiswa"))

                        val nama = jsonObject.optString("nama_mahasiswa").toString()
                        val alamat = jsonObject.optString("nomor_mahasiswa").toString()
                        val nomor = jsonObject.optString("alamat_mahasiswa").toString()

                        mhs.add(mahasiswa("$nama", "$alamat", "$nomor"))

                    }

                    val adapter = CustomAdapter(mhs)
                    recyclerView.adapter= adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }
}
