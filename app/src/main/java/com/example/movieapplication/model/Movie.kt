package com.example.movieapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(


    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("IMDBID") val imdbId: String,
    val Cast: String,
    val Runtime: String?,
    val Title: String,

    val Year: String,

)