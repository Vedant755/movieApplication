package com.example.movieapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapplication.R
import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.MovieList

class MovieAdapter(private var movies :MovieList):RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        )
    }

    override fun getItemCount(): Int = movies.MovieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindMovie(movie)
    }
    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
        private val posterImageView: ImageView = itemView.findViewById(R.id.movie_poster)
        private val castTextView: TextView = itemView.findViewById(R.id.cast)
        private val releaseYear: TextView = itemView.findViewById(R.id.movie_release_date)

        fun bindMovie(movie: Movie){
            titleTextView.text = movie.Title
            castTextView.text = movie.Cast
            releaseYear.text = movie.Year

        }


    }

    fun setData(newMovies: MovieList) {
        movies = newMovies
        notifyDataSetChanged()
    }
}