package com.example.final_tp.ui.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_tp.data.model.Movies
import com.example.final_tp.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {

  private val repository = MovieRepository()
  val readAllData: LiveData<List<Movies>> = repository.readAllData


  fun insertUser(movie: Movies) {
    repository.inserMovie(movie = movie)
  }

  fun UpdateMovie(movie: Movies) {
    repository.updateUser(movie = movie)
  }

  fun deleteMovie(movie: Movies) {
    viewModelScope.launch {
      repository.deleteMovie(movie = movie)
    }
  }

  fun deleteAll() {
    viewModelScope.launch {
      repository.deleteAll()
    }
  }


}