package com.example.movieapplication

import android.app.Application
import com.example.movieapplication.api.MovieApiService
import com.example.movieapplication.api.RetrofitHelper
import com.example.movieapplication.db.MovieDataBase
import com.example.movieapplication.repository.Repository

class MovieApplication:Application() {
    lateinit var movieRepository: Repository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }
    private fun initialize(){
        val movieService = RetrofitHelper.getInstance().create(MovieApiService::class.java)
        val database = MovieDataBase.getDatabase(applicationContext)
        movieRepository = Repository(  movieService,database)
    }
}