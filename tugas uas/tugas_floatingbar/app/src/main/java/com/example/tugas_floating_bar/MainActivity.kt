package com.example.tugas_floating_bar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import java.sql.RowId

class MainActivity : AppCompatActivity() {

    lateinit var snack: Snackbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.activity_main_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ShowSnack()
    }

    fun onclick (view: View){
        ShowSnack()
    }

    fun ShowSnack(){
        val activityview: View = findViewById(R.id.activity_main)
        snack = Snackbar.make(activityview, "This is my snackbar test", Snackbar.LENGTH_INDEFINITE)
        snack.setAction("dismiss")
        { snack.dismiss() }

        val snackbarLayout:View = snack.view
        snackbarLayout.setBackgroundColor(resources.getColor(R.color.colorAccent))
        val sntextview:TextView = snackbarLayout.findViewById(com.google.android.material.R.id.snackbar_text)
        val snactionview:TextView = snackbarLayout.findViewById(com.google.android.material.R.id.snackbar_action)

        sntextview.setTextColor(Color.WHITE)
        snactionview.setTextColor(Color.GRAY)
//        sntextview.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.i)
//        sntextview.compoundDrawablePadding = 12 dp
        snack.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //val inflater:MenuInflater = menuInflater
        //inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
