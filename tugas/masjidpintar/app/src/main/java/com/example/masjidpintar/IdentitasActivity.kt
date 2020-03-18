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
import kotlinx.android.synthetic.main.activity_identitas.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class IdentitasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identitas)
        getdariserver()

        btn1.setOnClickListener(){
            var data_namamasjid: String = nama_masjid.text.toString()
            var data_alamatmasjid: String = alamat_masjid.text.toString()

            postkeserve(data_namamasjid, data_alamatmasjid)
            getdariserver()

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btnkembali1.setOnClickListener(){
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun getdariserver(){
        AndroidNetworking.get("https://masjidpintar.000webhostapp.com/identitas-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_masjid"))

                        txt1identitas.setText(jsonObject.optString("nama_masjid"))
                        txt2identitas.setText(jsonObject.optString("alamat_masjid"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserve(data1:String, data2:String){
        AndroidNetworking.post("https://masjidpintar.000webhostapp.com/proses-identitas.php")
            .addBodyParameter("nama_masjid", data1)
            .addBodyParameter("alamat_masjid", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener{
                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}
