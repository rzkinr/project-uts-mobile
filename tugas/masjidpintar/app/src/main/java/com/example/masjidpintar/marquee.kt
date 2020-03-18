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
import kotlinx.android.synthetic.main.activity_marquee.*
import org.json.JSONArray
import org.json.JSONObject

class marquee : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marquee)

        getdariserver()

        btn3.setOnClickListener(){

            val data_marq = marquee.text.toString()
            postkeserve(data_marq)

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btnkembali3.setOnClickListener(){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    fun getdariserver(){
        AndroidNetworking.get("https://masjidpintar.000webhostapp.com/marquee-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("isi_marquee"))

                        txt1marquee.setText(jsonObject.optString("isi_marquee"))
                    }
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserve(data1:String){
        AndroidNetworking.post("https://masjidpintar.000webhostapp.com/proses-marq.php")
            .addBodyParameter("isi_marquee", data1)
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
