package com.example.movieapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapplication.api.MovieApiService
import com.example.movieapplication.db.MovieDataBase
import com.example.movieapplication.model.MovieList

class Repository(private val  movieApiService: MovieApiService,private val movieDataBase: MovieDataBase) {

    private val movieLiveData = MutableLiveData<MovieList>()

    val movies: LiveData<MovieList>
    get() = movieLiveData


    suspend fun getMovies(){
        val result1 = movieApiService.getMovieList1()
        val result2 = movieApiService.getMovieList2()
        if (result1?.body()!=null && result2?.body()!=null){
            movieDataBase.movieDao().addMovies(result1.body()!!.MovieList)
            movieLiveData.postValue(result1.body())
            movieDataBase.movieDao().addMovies(result2.body()!!.MovieList)
            movieLiveData.postValue(result2.body())
        }
    }
}