package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsRv : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_rv)


    val rv  = findViewById<RecyclerView>(R.id.recyclerView)
        val fab = findViewById<FloatingActionButton>(R.id.fab)



        fab.setOnClickListener(){
            val i = Intent(applicationContext, InputForm::class.java)
            startActivity(i)
        }

        rv.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<DataClass>()


//        for (i in 1..20){
//            data.add(("item data"+i))
//        }


        GlobalScope.launch { populate(data) }

//        populate(data)


            val adapter = RvAdapter(data)
        rv.adapter = adapter

    }

     fun populate( data: ArrayList<DataClass>){
//        coroutineScope { // limits the scope of concurrency
            for (i in 1..100) { // is a shorter way to write IntRange(0, 10)
//                async(Dispatchers.IO) { // async means "concurrently", context goes here
                    data.add(DataClass("item data"+i,"data2"))


            }
    }



//
//
//    private fun getData() {
//        // on below line we are creating a retrofit
//        // builder and passing our base url
//        // on below line we are creating a retrofit
//        // builder and passing our base url
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://jsonkeeper.com/b/")
//
//            // on below line we are calling add Converter
//            // factory as GSON converter factory.
//            // at last we are building our retrofit builder.
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        // below line is to create an instance for our retrofit api class.
//        // below line is to create an instance for our retrofit api class.
//        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
//
//        val call: Call<Names?>? = retrofitAPI.getCourse()
//
//        // on below line we are making a call.
//        call!!.enqueue(object : Callback<Names?> {
//            override fun onResponse(
//                call: Call<Names?>?,
//                response: Response<Names?>
//            ) {
//                if (response.isSuccessful()) {
//                    // inside the on response method.
//                    // we are hiding our progress bar.
//
//
//                    // on below line we are getting data from our response
//                    // and setting it in variables.
//                    val courseName: String = response.body()!!.name
//
//
//                    // on below line we are setting our data
//                    // to our text view and image view.
//                    courseReqTV.text = coursePreq
//
//
//                    // on below line we are setting image view from image url.
//
//
//                    // on below line we are adding click listener for our button.
//
//                }
//            }
//
//            override fun onFailure(call: Call<Names?>?, t: Throwable?) {
//                // displaying an error message in toast
//                Toast.makeText(this@DetailsRv, "Fail to get the data..", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        })
//    }

}