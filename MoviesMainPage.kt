package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.databinding.ActivityMoviesMainPageBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface MoviesPopularData{
    fun popularmoviesData(call: Call<PopularMovies>)
}

class MoviesMainPage : AppCompatActivity(), MoviesPopularData {

    lateinit var request: MoviesApiService

    private lateinit var binding: ActivityMoviesMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        request = ServiceBuilder.buildService(MoviesApiService::class.java)
        val call = request.getMovies("8f5dcace3981a269e646dc73120cc50a")
        Log.d("Moviesa", "Goin in")

        popularmoviesData(call)

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("CoroutineScopeMain", "IO: 1")
            delay(1000)
            Log.i("CoroutineScopeMain", "IO: 2")
            withContext(Dispatchers.Main) {
                delay(3000)
                Log.i("CoroutineScopeMain", "Main: ")
            }

        }




    }

    override fun popularmoviesData(call: Call<PopularMovies>){
        CoroutineScope(Dispatchers.IO).launch {
            call.enqueue(object : Callback<PopularMovies> {

                override fun onResponse(
                    call: Call<PopularMovies>,
                    response: Response<PopularMovies>
                ) {
//                Log.d("Moviesa","Goin in2")
                    Log.d("Moviesa", call.request().url.toString())



                    if (response.isSuccessful) {

                        Log.d("Moviesa", response.toString())

                        binding.progressBar.visibility = View.GONE
                        binding.recyclerView.apply {
                            setHasFixedSize(true)
                            layoutManager = GridLayoutManager(this@MoviesMainPage, 2)
                            adapter = MoviesAdapter(response.body()!!.results){position ->
                                val selectedItem = response.body()!!.results[position.toInt()]
                                Log.d("okokok","abraka2")
//                                Toast.makeText(applicationContext,"eewewere",Toast.LENGTH_SHORT).show()
                                val i = Intent(this@MoviesMainPage,ItemPage::class.java)
                                i.putExtra("name",selectedItem.toString())
                                startActivity(i)
                            }
                        }
                    } else {
                        Log.d("Moviesa", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                    Toast.makeText(this@MoviesMainPage, "${t.message}", Toast.LENGTH_SHORT).show()
                    Log.d("Moviesa", t.message.toString())
                }

            })
        }

    }

}