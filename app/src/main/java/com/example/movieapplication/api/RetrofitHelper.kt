package com.example.movieapplication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL="http://task.auditflo.in/"

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}