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
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getdariserver()

        btn2.setOnClickListener(){
            val data_dhuha: String = dhuha.text.toString()
            val data_shubuh: String = shubuh.text.toString()
            val data_dhuhur: String = dhuhur.text.toString()
            val data_ashar: String = ashar.text.toString()
            val data_maghrib: String = maghrib.text.toString()
            val data_isha: String = isha.text.toString()

            postkeserve(data_dhuha, data_shubuh, data_dhuhur, data_ashar, data_maghrib, data_isha)

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

        }

        btnkembali2.setOnClickListener(){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun getdariserver(){
        AndroidNetworking.get("https://masjidpintar.000webhostapp.com/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("shubuh"))

                        txt1.setText(jsonObject.optString("shubuh"))
                        txt2.setText(jsonObject.optString("dhuhur"))
                        txt3.setText(jsonObject.optString("ashar"))
                        txt4.setText(jsonObject.optString("maghrib"))
                        txt5.setText(jsonObject.optString("isha"))
                        txt6.setText(jsonObject.optString("dhuha"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserve(data1:String, data2:String, data3:String,data4:String,data5:String,data6:String){
        AndroidNetworking.post("https://masjidpintar.000webhostapp.com/proses-jadwal.php")
            .addBodyParameter("dhuha", data1)
            .addBodyParameter("shubuh", data2)
            .addBodyParameter("dhuhur", data3)
            .addBodyParameter("ashar", data4)
            .addBodyParameter("maghrib", data5)
            .addBodyParameter("isha", data6)
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
