package com.example.masjidpintar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_pengumuman.*
import kotlinx.android.synthetic.main.activity_slide.*
import org.json.JSONArray
import org.json.JSONObject

class PengumumanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman)
        getdariserver()

        btnsimpanpengumuman.setOnClickListener(){

            val data_judul: String = judul_pengumuman.text.toString()
            val data_isi: String = isi_pengumuman.text.toString()
            postkeserve(data_judul, data_isi)

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btnsimpanpengumuman.setOnClickListener(){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun getdariserver(){
        AndroidNetworking.get("https://masjidpintar.000webhostapp.com/pengumuman-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("judul_pengumuman"))

                        txt1pengumuman.setText(jsonObject.optString("judul_pengumuman"))
                        txt2pengumuman.setText(jsonObject.optString("isi_pengumuman"))

                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserve(data1:String, data2:String){
        AndroidNetworking.post("https://masjidpintar.000webhostapp.com/proses-pengumuman.php")
            .addBodyParameter("judul_pengumuman", data1)
            .addBodyParameter("isi_pengumuman", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}
