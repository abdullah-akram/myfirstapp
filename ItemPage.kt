package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ItemPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_page)

        if(intent.hasExtra("name")){
            // get the Serializable data model class with the details in it
            val b = intent.getStringExtra("name")
            Log.d("okokok",b.toString())
        }
    }
}