package com.example.project_uts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
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

        kembali_dashboard.setOnClickListener(){
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    fun getdata(){
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val pndk = ArrayList<penduduk>()

        AndroidNetworking.get("http://192.168.1.78/project-uts/data-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_mahasiswa"))

                        val nama = jsonObject.optString("nama_penduduk").toString()
                        val ttl = jsonObject.optString("ttl_penduduk").toString()
                        val nomor = jsonObject.optString("hp_penduduk").toString()
                        val alamat = jsonObject.optString("alamat_penduduk").toString()

                        pndk.add(penduduk("$nama", "$ttl", "$nomor", "$alamat"))

                    }

                    val adapter = CustomAdapter(pndk)
                    recyclerView.adapter= adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }
}
