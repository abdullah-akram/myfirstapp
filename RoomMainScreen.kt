package com.example.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

class RoomMainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "user"
        ).build()
        val userDao = db.userDao()
        val users: List<User> = userDao.getAll()
    }
}