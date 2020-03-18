package com.example.tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a = 5
        var b = 6
        var c = 10
        hitung(a,b,c)
//        var a = 5
//        var b = 7
        penjumlahan(a,b)

/*    var jam = 12

        if (jam <= 12){
            Log.i("Hasil","Selamat Pagi")
        } else {
            Log.i("Hasil", "Selamat Petang")
        }
*/


/*        var Nilai = 70

        if (Nilai >= 90)
        {
            Log.i("Hasil", "Nilai Anda A")
            tampil.text="Nilai Anda A"
//            tampil.setText("Nilai Anda A")
        } else if(Nilai < 90 && Nilai >= 80)
        {
            Log.i("Hasil", "Nilai Anda AB")
            tampil.text="Nilai Anda AB"
        }else if(Nilai < 80 && Nilai >= 70)
        {
            Log.i("Hasil", "Nilai Anda B")
            tampil.text="Nilai Anda B"
        }else if(Nilai < 70 && Nilai >= 60)
        {
            Log.i("Hasil", "Nilai Anda BC")
            tampil.text="Nilai Anda BC"
        }else{
            Log.i("Hasil", "Nilai Anda C")
            tampil.text="Nilai Anda C"
        }
 */

/*        for (x in 0..10)
            Log.i("Hasil", "$x")*/

/*        var i = 1

        while (i <= 5)
        {
            Log.i("Line","$i")
            ++i
        }*/

        /*var i = 1
        var num = 2

        do {
            Log.i("Perkalian " ,"2 * $i = "+ num * i)
            i++
        }while (i < 11)*/

    }

    fun penjumlahan(a:Int, b:Int){
        var c :Int
        c = a + b
        Log.i("Hasil", "$c")
    }

    fun hitung(a:Int, b:Int, c:Int){
        var d : Int
        d = ((a*b) - 10 ) / c
        Log.i("Hasil", "$d")
    }

    }
}
