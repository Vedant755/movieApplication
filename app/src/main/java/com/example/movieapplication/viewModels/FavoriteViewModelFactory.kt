package com.example.movieapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.favoritemovies.FavoriteMovieRepository
import com.example.movieapplication.repository.Repository

class FavoriteViewModelFactory(private val favoriteMovieRepository: FavoriteMovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return FavoriteMovieViewModel(favoriteMovieRepository) as T
    }
}