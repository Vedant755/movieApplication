package com.example.movieapplication.favoritemovies

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapplication.db.MovieDao
import com.example.movieapplication.model.Movie

@Database(entities = [FavoriteMovie::class], version = 1)
abstract class FavoriteMovieDatabase: RoomDatabase() {
    abstract fun getfavoriteMovieDao(): FavoriteMovieDao

    companion object{
        @Volatile private var instance: FavoriteMovieDatabase? = null

        fun getDatabase(context: Context): FavoriteMovieDatabase{
            if (instance==null){
                synchronized(this){
                    instance= Room.databaseBuilder(context,
                        FavoriteMovieDatabase::class.java,
                        "Fav_movieDB"
                    ).build()
                }
            }
            return instance!!
        }
    }
}