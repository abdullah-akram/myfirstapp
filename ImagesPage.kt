package com.example.myfirstapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import java.io.IOException
import java.net.URL
import java.util.concurrent.Executors


class ImagesPage : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images_page)

        val images: Array<ImageView> by lazy {
            arrayOf(
                findViewById<ImageView>(R.id.img1),
                findViewById<ImageView>(R.id.img2),
                findViewById<ImageView>(R.id.img3),
                findViewById<ImageView>(R.id.img4),
                findViewById<ImageView>(R.id.img5),
                findViewById<ImageView>(R.id.img6)

            )

        }
//
//        load(images)
        Glide.with(this)
            .load("https://media.istockphoto.com/id/915681526/photo/bandra-worli-sea-link-mumbai.jpg?s=2048x2048&w=is&k=20&c=COtSrx9PiA785aNsQ2rPaW8ooHNuTkCWkpK8G5ty0YY=")
            .placeholder(R.drawable.logo)
            .apply(RequestOptions.bitmapTransform( RoundedCorners(54)))
            .into(images[0]);
        Glide.with(this)
            .load("https://media.istockphoto.com/id/915681526/photo/bandra-worli-sea-link-mumbai.jpg?s=2048x2048&w=is&k=20&c=COtSrx9PiA785aNsQ2rPaW8ooHNuTkCWkpK8G5ty0YY=")
            .placeholder(R.drawable.logo)
            .apply(RequestOptions.bitmapTransform( RoundedCorners(54)))
            .into(images[1]);

        Glide.with(this)
            .load("https://media.istockphoto.com/id/915681526/photo/bandra-worli-sea-link-mumbai.jpg?s=2048x2048&w=is&k=20&c=COtSrx9PiA785aNsQ2rPaW8ooHNuTkCWkpK8G5ty0YY=")
            .placeholder(R.drawable.logo)
            .into(images[2]);
        Glide.with(this)
            .load("https://media.istockphoto.com/id/915681526/photo/bandra-worli-sea-link-mumbai.jpg?s=2048x2048&w=is&k=20&c=COtSrx9PiA785aNsQ2rPaW8ooHNuTkCWkpK8G5ty0YY=")
            .placeholder(R.drawable.logo)
            .into(images[3]);

        Glide.with(this)
            .load("https://media.istockphoto.com/id/915681526/photo/bandra-worli-sea-link-mumbai.jpg?s=2048x2048&w=is&k=20&c=COtSrx9PiA785aNsQ2rPaW8ooHNuTkCWkpK8G5ty0YY=")
            .placeholder(R.drawable.logo)
//            .apply(RequestOptions.bitmapTransform())
            .into(images[4]);

//            val url = ("https://media.istockphoto.com/id/915681526/photo/bandra-worli-sea-link-mumbai.jpg?s=2048x2048&w=is&k=20&c=COtSrx9PiA785aNsQ2rPaW8ooHNuTkCWkpK8G5ty0YY=")
        val executor = Executors.newSingleThreadExecutor()

        val imageURL = "https://media.istockphoto.com/id/915681526/photo/bandra-worli-sea-link-mumbai.jpg?s=2048x2048&w=is&k=20&c=COtSrx9PiA785aNsQ2rPaW8ooHNuTkCWkpK8G5ty0YY="
        var image: Bitmap? = null
        val handler = Handler(Looper.getMainLooper())

        // Tries to get the image and post it in the ImageView
        // with the help of Handler
        Log.d("Abdullah","nonono")
        executor.execute {
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
                Log.d("Abdullah", "ththt")

                // Only for making changes in UI\
                Log.d("Abdullah", "aokaok")
                handler.post {
                    Log.d("Abdullah", "yoyoyo")

//                imageView.setImageBitmap(image)
                Glide.with(this)
                    .asBitmap()
                    .load(image)
                    .placeholder(R.drawable.logo)
                    .apply(RequestOptions.overrideOf(500,500))
//                    .apply(RequestOptions.bitmapTransform(BlurTransformation(25, 3)))
                    .into(images[5]);

                }
            }

            // If the URL doesnot point to
            // image or any other kind of failure
            catch (e: Exception) {
                e.printStackTrace()
            }
        }






    }



    suspend fun load(images:Array<ImageView>){
//        Glide.with(this)
//            .load("https://media.istockphoto.com/id/915681526/photo/bandra-worli-sea-link-mumbai.jpg?s=2048x2048&w=is&k=20&c=COtSrx9PiA785aNsQ2rPaW8ooHNuTkCWkpK8G5ty0YY=")
//            .placeholder(R.drawable.logo)
//            .apply(RequestOptions.bitmapTransform( RoundedCorners(14)))
//            .into(images[0]);
//    }
}}