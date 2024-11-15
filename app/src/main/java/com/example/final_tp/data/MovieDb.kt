package com.example.final_tp.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.final_tp.TpFinalMovileApp
import com.example.final_tp.data.model.Movies
import com.example.final_tp.utils.Constante

@Database(entities = [Movies::class], version = 1, exportSchema = false)
abstract class MovieDb : RoomDatabase(){

  abstract fun movieDao(): MovieDAO

  companion object {
    //Patron Singleton
    private var INSTANCE: MovieDb? = null

    fun getDatabase(): MovieDb {
      val tempInstance = INSTANCE

      if (tempInstance != null) {
        return tempInstance
      }

      synchronized(this) {
        val instance = Room.databaseBuilder(
          TpFinalMovileApp.instance.applicationContext,
          MovieDb::class.java,
          Constante.DB_NAME
        ).allowMainThreadQueries()
          .fallbackToDestructiveMigration()
          .build()

        INSTANCE = instance
        return instance
      }
    }
  }

}