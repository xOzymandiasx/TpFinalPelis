package com.example.final_tp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_tp.data.model.User
import com.example.final_tp.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

  private val repository = UserRepository()

  val readAllData: LiveData<List<User>> = repository.readAllData

  fun insertUser(user: User) {
    viewModelScope.launch {
      repository.insertUser(user = user)

    }


  }

  fun UpdateUser(user: User) {
    viewModelScope.launch {
      repository.updateUser(user = user)
    }
  }
}