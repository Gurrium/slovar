package com.example.slovar.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.slovar.DetailActivity
import com.example.slovar.R

class WordAdapter(private val context: Context): RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    private val dataset = listOf<String>("А1", "А2", "А3С")

    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button? = view.findViewById(R.id.item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordAdapter.WordViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return WordAdapter.WordViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: WordAdapter.WordViewHolder, position: Int) {
        holder.button?.text = dataset[position]
        holder.button?.setOnClickListener {
            Log.d("onBindViewHolder", "word is tapped")
        }
    }

    override fun getItemCount() = dataset.size
}