package com.example.movieapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieapplication.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object{
        @Volatile private var instance: MovieDataBase? = null

        fun getDatabase(context: Context): MovieDataBase{
            if (instance==null){
                synchronized(this){
                    instance= Room.databaseBuilder(context,
                        MovieDataBase::class.java,
                        "movieDB"
                    ).build()
                }
            }
            return instance!!
        }
    }
}