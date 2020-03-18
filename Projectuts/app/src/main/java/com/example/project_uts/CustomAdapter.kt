package com.example.project_uts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val mhsList: ArrayList<penduduk>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pndk: penduduk=mhsList[position]
        holder?.nama_penduduk?.text = pndk.nama_penduduk
        holder?.ttl_penduduk?.text = pndk.ttlpenduduk
        holder?.hp_penduduk?.text = pndk.hp_penduduk
        holder?.alamat_penduduk?.text = pndk.alamat_penduduk
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.item_row, parent, false)
        return  ViewHolder(v)

    }

    override fun getItemCount(): Int {

        return mhsList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val nama_penduduk = itemView.findViewById(R.id.nama_penduduk) as TextView
        val ttl_penduduk = itemView.findViewById(R.id.ttl_penduduk) as TextView
        val hp_penduduk = itemView.findViewById(R.id.hp_penduduk) as TextView
        val alamat_penduduk = itemView.findViewById(R.id.alamat_penduduk) as TextView

    }

}