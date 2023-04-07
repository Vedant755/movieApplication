package com.example.movieapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(
    val Cast: String,
    val Director: String,
    val Genres: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("IMDBID") val imdbId: String,
    @SerializedName("Movie_Poster")
    val MoviePoster: String?,
    val Rating: String?,
    val Runtime: String?,
    @SerializedName("Short_Summary")
    val ShortSummary: String?,
    val Summary: String,
    val Title: String,
    val Writers: String,
    val Year: String,
    @SerializedName("Youtube_Trailer")
    val YouTubeTrailer: String?
)