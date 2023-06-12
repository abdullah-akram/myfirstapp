package com.example.myfirstapplication

import retrofit2.Call

import retrofit2.http.GET

interface RetrofitAPI {
    @GET("8RFY")
    fun  getCourse(): Call<Names?>?

}