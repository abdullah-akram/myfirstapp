package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myfirstapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.button1.setOnClickListener(){
            val i = Intent(applicationContext,SecondScreen::class.java)
            startActivity(i)

        }

        binding.button2.setOnClickListener(){
            val i = Intent(applicationContext,BottomSheet::class.java)
            startActivity(i)

        }

        binding.button3.setOnClickListener(){
            val i = Intent(applicationContext,DetailsRv::class.java)
            startActivity(i)

        }

        binding.button4.setOnClickListener(){
            val i = Intent(applicationContext,ViewPagerScreen::class.java)
            startActivity(i)

        }

        binding.button5.setOnClickListener(){
            val i = Intent(applicationContext,ViewPager2Screen::class.java)
            startActivity(i)

        }

        binding.button6.setOnClickListener(){
            val i = Intent(applicationContext,MoviesMainPage::class.java)
            startActivity(i)

        }

        binding.button7.setOnClickListener(){
            val i = Intent(applicationContext,RoomMainScreen::class.java)
            startActivity(i)

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Abdullah","ondestroy")
    }
}