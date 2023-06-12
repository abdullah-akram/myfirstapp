package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.OneShotPreDrawListener.add

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

            val button= findViewById<Button>(R.id.button)
            button.setOnClickListener(){
//                finish()
            val i = Intent(applicationContext,ThirdScreen::class.java)
                startActivity(i)
            }


            val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener(){
//
//                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
//
            Toast.makeText(applicationContext,"this is toast message", Toast.LENGTH_SHORT).show()

            val fragment1     = Fragment1()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.fragment_container,fragment1).commit()

        }
}}