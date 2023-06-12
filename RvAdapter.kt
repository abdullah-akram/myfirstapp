package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RvAdapter(private val strlist:List<DataClass>): RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.details_row ,viewGroup,false)

        return  ViewHolder(view)

    }


    override fun getItemCount(): Int {
        return strlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val s = strlist[position]
        holder.textView.text = s.toString()
        holder.textView2.text = s.toString()
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textView2: TextView = itemView.findViewById(R.id.textView2)
    }


}