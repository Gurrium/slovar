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

class LetterAdapter(private val context: Context): RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {
    private val dataset = listOf<String>("А", "Б", "С")

    class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button? = view.findViewById(R.id.letter)
    }

    // parent: ViewHolderがもつ、リスト内の要素のビューがattachされる先
    // viewType: 要素のビューの種類。同じ種類の者同士でないと再利用できない。一つのRecyclerViewの中に複数種類のビューがある場合に見る。
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        // LayoutInflater: レイアウトを定義したXMLファイルをViewのインスタンスにする。
        // なぜcontextを参照する必要がある？
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return LetterViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        // ここはビューにデータを紐付けるためのメソッドなのでそれをしている
        holder.button?.text = dataset[position]
        holder.button?.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, DetailActivity::class.java)
            Log.d("Action", intent.action.toString())
            Log.d("Categories", intent.categories?.joinToString().toString())
            intent.putExtra("letter", holder.button.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataset.size
}