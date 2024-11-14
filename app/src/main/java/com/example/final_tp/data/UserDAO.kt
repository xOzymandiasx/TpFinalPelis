package com.example.final_tp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.final_tp.data.model.User

@Dao
interface UserDAO {

  @Query("SELECT * FROM user_table ORDER BY id ASC")
  fun readAllData(): LiveData<List<User>>  //getAll

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun insert(user: User)  //Insert

  @Update
  suspend fun update(user: User)
}