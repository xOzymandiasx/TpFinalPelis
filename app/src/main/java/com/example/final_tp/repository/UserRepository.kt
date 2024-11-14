package com.example.final_tp.repository

import androidx.lifecycle.LiveData
import com.example.final_tp.data.UserDAO
import com.example.final_tp.data.UserDb
import com.example.final_tp.data.model.User

class UserRepository {

  private val userDao = UserDb.getDatabase().userDao()

  val readAllData: LiveData<List<User>> = userDao.readAllData()

  suspend fun insertUser(user: User) {
    userDao.insert(user = user)
  }

  suspend fun updateUser(user: User) {
    userDao.update(user = user)
  }
}