package com.example.movieapplication.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.model.MovieList
import com.example.movieapplication.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val movieRepository: Repository):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.getMovies()
        }
    }
    val movies : LiveData<MovieList>
    get() = movieRepository.movies
}