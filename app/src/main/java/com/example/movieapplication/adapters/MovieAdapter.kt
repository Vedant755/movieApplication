package com.example.movieapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.R
import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.MovieList
import com.example.movieapplication.viewModels.FavoriteMovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieAdapter(
    private var movies: MovieList,
    private val favoriteMovieViewModel: FavoriteMovieViewModel
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.MovieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindMovie(movie)

        // Check if the movie is in the user's favorite list
        CoroutineScope(Dispatchers.IO).launch {
            val isFavorite = favoriteMovieViewModel.checkMovie(movie.imdbId)
            withContext(Dispatchers.Main) {
                holder.setFavorite(isFavorite == 1) // convert the Int value to a Boolean value
            }
        }

        // Add or remove the movie from the user's favorite list when the favorite button is clicked
        holder.isFavoriteButton.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                favoriteMovieViewModel.addToFavorite(movie)
            } else {
                favoriteMovieViewModel.removeFromFavorite(movie.imdbId)
            }
        }
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
        private val runtime: TextView = itemView.findViewById(R.id.runtime_text_view)
        private val castTextView: TextView = itemView.findViewById(R.id.cast)
        private val releaseYear: TextView = itemView.findViewById(R.id.year_text_view)
        val isFavoriteButton: ToggleButton = itemView.findViewById(R.id.toggle_favorite)

        fun bindMovie(movie: Movie) {
            titleTextView.text = movie.Title
            castTextView.text = movie.Cast
            releaseYear.text = movie.Year
            runtime.text = movie.Runtime
        }

        fun setFavorite(isFavorite: Boolean) {
            isFavoriteButton.isChecked = isFavorite
        }
    }

    fun setData(newMovies: MovieList) {
        movies = newMovies
        notifyDataSetChanged()
    }
}
