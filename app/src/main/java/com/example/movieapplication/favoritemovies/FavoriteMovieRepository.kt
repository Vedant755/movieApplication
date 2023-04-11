package com.example.movieapplication.favoritemovies

class FavoriteMovieRepository  (
    private val favoriteMovieDatabase: FavoriteMovieDatabase
){
    suspend fun addToFavorite(favoriteMovie: FavoriteMovie) = favoriteMovieDatabase.getfavoriteMovieDao().addToFavorite(favoriteMovie)
    fun getFavoriteMovies() = favoriteMovieDatabase.getfavoriteMovieDao().getFavoriteMovie()
    suspend fun checkMovie(id: String) = favoriteMovieDatabase.getfavoriteMovieDao().checkMovie(id)
    suspend fun removeFromFavorite(id: String) {
        favoriteMovieDatabase.getfavoriteMovieDao().removeFromFavorite(id)
    }
}