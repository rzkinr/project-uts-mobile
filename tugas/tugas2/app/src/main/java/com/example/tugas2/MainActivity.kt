package com.example.tugas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*jumlah(bilangan1,bilangan2)  >>> Salah
        kurang(bilangan1,bilangan2) >>> Salah
        kali(bilangan1,bilangan2) >>> SAlah
        */

        jumlahkan.setOnClickListener() {
            jumlah()
        }

        kurangkan.setOnClickListener(){
            kurang()
        }

        kalikan.setOnClickListener(){
            kali()
        }

        bagikan.setOnClickListener(){
            bagi()
        }

        /*jumlahkan.setOnClickListener() {

            var bilangan1: String = bil1.text.toString()
            var bilangan2: String = bil2.text.toString()

            var a: Int = bilangan1.toInt()
            var b: Int = bilangan2.toInt()

            var c: Int = a + b

            hasil.setText(c.toString())
        }*/
    }

    fun jumlah(){
        var bilangan1: String = bil1.text.toString()
        var bilangan2: String = bil2.text.toString()

        var a: Int = bilangan1.toInt()
        var b: Int = bilangan2.toInt()
        var c: Int = a + b

        hasil.setText(c.toString())
    }

    fun kurang(){
        var bilangan1: String = bil1.text.toString()
        var bilangan2: String = bil2.text.toString()

        var a: Int = bilangan1.toInt()
        var b: Int = bilangan2.toInt()
        var d: Int = a - b

        hasil.setText(d.toString())
    }

    fun kali(){
        var bilangan1: String = bil1.text.toString()
        var bilangan2: String = bil2.text.toString()

        var a: Int = bilangan1.toInt()
        var b: Int = bilangan2.toInt()
        var e: Int = a * b

        hasil.setText(e.toString())
    }

    fun bagi(){
        var bilangan1: String = bil1.text.toString()
        var bilangan2: String = bil2.text.toString()

        var a: Int = bilangan1.toInt()
        var b: Int = bilangan2.toInt()
        var f: Int = a / b

        hasil.setText(f.toString())
    }
}
