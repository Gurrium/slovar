package com.example.slovar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.slovar.adapter.LetterAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // これを呼ぶことでこのActivityのUIがinflateされる
        setContentView(R.layout.activity_main)

        // inflateされたあとはfindViewByIdでActivityのUI中のwidgetを触れる
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = LetterAdapter(this)
        recyclerView.setHasFixedSize(true)
    }
}