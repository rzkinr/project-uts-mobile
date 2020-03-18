package com.example.project_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_tambah.*
import org.json.JSONArray

class TambahActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        btn_tambah.setOnClickListener(){
            val nama: String = textnama.text.toString()
            val ttl: String = textttl.text.toString()
            val nomor: String = textnomor.text.toString()
            val alamat: String = textalamat.text.toString()

            tambahdata(nama,ttl,  nomor, alamat)

            textnama.setText("")
            textttl.setText("")
            textnomor.setText("")
            textalamat.setText("")
        }

        btn_kembali.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    fun tambahdata(nama:String,ttl:String, nomor:String,alamat:String){
        AndroidNetworking.post("http://192.168.1.78/project-uts/proses-json.php")
            .addBodyParameter("nama_penduduk", nama)
            .addBodyParameter("ttl_penduduk", ttl)
            .addBodyParameter("hp_penduduk", nomor)
            .addBodyParameter("alamat_penduduk", alamat)
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
