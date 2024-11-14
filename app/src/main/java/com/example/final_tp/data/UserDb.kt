package com.example.final_tp.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.final_tp.TpFinalMovileApp
import com.example.final_tp.data.model.User
import com.example.final_tp.utils.Constans

@Database(entities = [User::class], version = 1, exportSchema = false)
//La mantenemos abstracta para que nadie implemente los metodos de esta clase
abstract class UserDb : RoomDatabase(){

  abstract fun userDao(): UserDAO

  companion object {
    //Patron Singleton
    private var INSTANCE: UserDb? = null

    fun getDatabase(): UserDb {
      val tempInstance = INSTANCE

      if (tempInstance != null) {
        return tempInstance
      }

      synchronized(this) {
        val instance = Room.databaseBuilder(
          TpFinalMovileApp.instance.applicationContext,
          UserDb::class.java,
          Constans.DB_NAME
        ).allowMainThreadQueries()
          .fallbackToDestructiveMigration()
          .build()

        INSTANCE = instance
        return instance
      }
    }
  }
}