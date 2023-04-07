package com.example.movieapplication

import MovieListFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.movieapplication.api.MovieApiService
import com.example.movieapplication.api.RetrofitHelper
import com.example.movieapplication.repository.Repository
import com.example.movieapplication.viewModels.MainViewModel
import com.example.movieapplication.viewModels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val repository = (application as MovieApplication).movieRepository

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.movies.observe(this, Observer {
            Log.d("Vedant",it.MovieList.toString())
        })
        val movieListFragment = MovieListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, movieListFragment)
            .commit()

        mainViewModel.movies.observe(this) { movies ->
            movieListFragment.setMovies(movies)
        }
    }


}