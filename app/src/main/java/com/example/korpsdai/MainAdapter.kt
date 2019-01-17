package com.example.korpsdai

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.korpsdai.model.Dai
import com.example.korpsdai.response.ListDai
import kotlinx.android.synthetic.main.list_dai.view.*

class MainAdapter(val context: Context, val dai : List<ListDai.Allfile>?) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.list_dai, p0, false))
    }

    override fun getItemCount(): Int {
        return dai?.size!!
    }

    override fun onBindViewHolder(p0: MainViewHolder, p1: Int) {
        dai?.get(p1)?.let { p0.bind(it) }
    }


    class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dai : ListDai.Allfile){
            itemView.tv_nama.text = dai.nama_dai
        }
    }

}