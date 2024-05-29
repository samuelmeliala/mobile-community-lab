package com.dnjisme.samplemap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuotesAdapter (private val quoteList : ArrayList<Quotes>):
        RecyclerView.Adapter<QuotesAdapter.MyViewHolder>(){

            class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
                val quoteTextView : TextView = itemView.findViewById(R.id.TVContent)
                val authorTextView : TextView = itemView.findViewById(R.id.TVAuthor)
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.quote_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = quoteList[position]
        holder.quoteTextView.text = currentItem.quoteContent
        holder.authorTextView.text = currentItem.quoteAuthor
    }

}