package com.example.masjidpintar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val slideList: ArrayList<slideshow>):RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val slide: slideshow=slideList[position]
        holder?.textViewName?.text = slide.judul_slideshow
        holder?.textViewAddress?.text = slide.url_slideshow

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }


    override fun getItemCount(): Int {

        return slideList.size
    }



    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewName = itemView.findViewById(R.id.textViewName) as TextView
        val textViewAddress = itemView.findViewById(R.id.textViewAddress) as TextView




    }




}
