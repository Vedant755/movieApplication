package com.example.movieapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.movieapplication.favoritemovies.FavoriteMovie
import com.example.movieapplication.favoritemovies.FavoriteMovieRepository
import com.example.movieapplication.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteMovieViewModel(private val favoriteMovieRepository: FavoriteMovieRepository) :ViewModel(){
    fun addToFavorite(movie: Movie){
        CoroutineScope(Dispatchers.IO).launch {
            favoriteMovieRepository.addToFavorite(
                FavoriteMovie(
                    movie.id,
                    movie.Cast,
                    movie.imdbId,
                    movie.Runtime,
                    movie.Title,
                    movie.Year
                )
            )
        }
    }

    suspend fun checkMovie(id: String) = favoriteMovieRepository.checkMovie(id)

    fun removeFromFavorite(id: String){
        CoroutineScope(Dispatchers.IO).launch {
            favoriteMovieRepository.removeFromFavorite(id)
        }
    }
}