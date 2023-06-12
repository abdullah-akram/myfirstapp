package com.example.myfirstapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView

class ThirdScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)
        val tv = findViewById<TextView>(R.id.text)
        val animate = findViewById<Button>(R.id.animate)
        animate.setOnClickListener(){
            val animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
            tv.startAnimation(animationBounce)
        }

    }
}