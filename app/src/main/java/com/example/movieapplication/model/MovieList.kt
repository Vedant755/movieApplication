package com.example.movieapplication.model

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("Movie List")
    val MovieList: List<Movie>
) {
    operator fun get(position: Int): Movie {
        return MovieList[position]
    }
}