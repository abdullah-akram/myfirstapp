package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import java.util.*

class InputForm : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_form)

        val date = findViewById<DatePicker>(R.id.date)
        val today = Calendar.getInstance()

        date.init(2022, 8,
            12

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(this@InputForm, msg, Toast.LENGTH_SHORT).show()
        }

    }
}