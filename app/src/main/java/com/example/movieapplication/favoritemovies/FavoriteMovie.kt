package com.example.movieapplication.favoritemovies

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "favorite_movie")
data class FavoriteMovie(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("IMDBID") val imdbId: String,
    val Cast: String,
    val Runtime: String?,
    val Title: String,
    val Year: String,

)
