package com.example.movieapplication.api

import com.example.movieapplication.model.Movie
import com.example.movieapplication.model.MovieList
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiService {
    @GET("1.json")
    suspend fun getMovieList1(): Response<MovieList>

    @GET("2.json")
    suspend fun getMovieList2(): Response<MovieList>
}