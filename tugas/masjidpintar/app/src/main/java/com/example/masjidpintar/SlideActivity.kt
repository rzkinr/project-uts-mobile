package com.example.masjidpintar

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
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_slide.*
import kotlinx.android.synthetic.main.activity_tagline.*
import org.json.JSONArray
import org.json.JSONObject

class SlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)
        getdariserver()

//        btn5.setOnClickListener(){
//
//            val data_judul: String = judul_slideshow.text.toString()
//            val data_url: String = url_slide.text.toString()
//            postkeserve(data_judul, data_url)
//
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//
//        }

        btnkembalislide.setOnClickListener(){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun getdariserver(){
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val slides=ArrayList<slideshow>()

        AndroidNetworking.get("https://masjidpintar.000webhostapp.com/slide-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("judul_slideshow"))

                        val isi1 = jsonObject.optString("judul_slideshow").toString()
                        val isi2 = jsonObject.optString("url_slideshow").toString()

                        slides.add(slideshow("$isi1", "$isi2"))

                    }

                    val adapter = CustomAdapter(slides)
                    recyclerView.adapter= adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

//    fun postkeserve(data1:String, data2:String){
//        AndroidNetworking.post("https://masjidpintar.000webhostapp.com/proses-slideshow.php")
//            .addBodyParameter("judul_pengumuman", data1)
//            .addBodyParameter("url_pengumuman", data2)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONArray(object : JSONArrayRequestListener {
//                override fun onResponse(response: JSONArray?) {
//
//                }
//
//                override fun onError(anError: ANError?) {
//
//                }
//            })
//    }
}
