package com.example.myfirstapplication

import android.content.ClipData.Item
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.myfirstapplication.databinding.MovieItemBinding
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.coroutines.currentCoroutineContext


class MoviesAdapter(val movies: List<Result>,val onClicks: (str:String)->Unit) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var onClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    private fun onItemClicked(position: Int) {
        // Handle item click event
        val clickedItem = movies[position]
//        Toast.makeText(,"Clicked: $clickedItem", Toast.LENGTH_SHORT).show()
    Log.d("okokok","clicked")

    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

//
//        holder.itemView.setOnTouchListener(){view, event ->
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> {
//                    // Touch down event
//                    Log.d("bindvh","down")
//
//                    true
//                }
//                MotionEvent.ACTION_MOVE -> {
//                    // Touch move event
//                    Log.d("bindvh","move")
//                    false
//                }
//                MotionEvent.ACTION_UP -> {
//                    Log.d("bindvh","up")
//                    // Touch up event
//                    false
//                }
//
//                else -> false
//            }
//        }
        holder.currentPosition = position
        val item = movies[position]

        holder.itemView.setOnClickListener {
            onClicks(holder.currentPosition.toString())
//            Log.d("okokok",movies[position].toString())

        }



        return holder.bind(movies[position])


    }
//    fun setOnClickListener(onClickListener: OnClickListener) {
//        this.onClickListener = onClickListener
//    }

    // onClickListener Interface
//    interface OnClickListener : View.OnClickListener {
//        fun onClick(position: Int, model: Result)
//    }
    override fun getItemCount(): Int {
        return movies.size
    }



 inner class MoviesViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
     var currentPosition: Int = RecyclerView.NO_POSITION


//     init {
//         binding.root.setOnClickListener {
//             if (currentPosition != RecyclerView.NO_POSITION) {
//                 onItemClicked(currentPosition)
//             }
//         }
//     }

        private val glideRequest by lazy {
            Glide.with(itemView.context)
        }

        val bind:(Result)->Unit = { movie->

            binding.apply {
                glideRequest.load("https://image.tmdb.org/t/p/w500${movie.poster_path}").into(moviePhoto)


                glideRequest.
                load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
                    .apply(RequestOptions.bitmapTransform(BlurTransformation(5, 6)))
                    .into(moviePhotoBg)

                movieTitle.text = "Title: " + movie.title.formatForDisplay()
                movieOverview.text = movie.overview
                movieRating.text ="Rating : " + movie.vote_average.toString().formatForDisplay()

            }


        }

    }

    fun String.formatForDisplay(): String {
        return this.toUpperCase() // Add bold formatting using HTML tags
    }


}

