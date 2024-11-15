package com.example.final_tp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.final_tp.data.model.Movies

@Dao
interface MovieDAO {
  @Query("SELECT * FROM movie_table ORDER BY id ASC")
  fun readAllData(): LiveData<List<Movies>>  //getAll

  @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insert(movie: Movies)  //Insert

   @Update
   suspend fun update(movie: Movies)

  //@Update
  //suspend fun update(movie: Movies)

  //@Delete
  //suspend fun deleteUser(movie: Movies)

  //@Query("DELETE FROM movie_table")
  //suspend fun deleteAll()
}