package com.example.final_tp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_tp.data.MovieDb
import com.example.final_tp.data.model.Movies
import kotlinx.coroutines.launch

class MovieRepository{

  private val movieDao = MovieDb.getDatabase().movieDao()

  val readAllData: LiveData<List<Movies>> = movieDao.readAllData()


   suspend fun inserMovie(movie: Movies) {
       movieDao.insert(movie = movie)
  }

  suspend fun updateUser(movie: Movies) {
      movieDao.update(movie = movie)
  }

  suspend fun deleteMovie(movie: Movies) {
    movieDao.deleteMovie(movie = movie)
  }

  suspend fun deleteAll() {
    movieDao.deleteAll()
  }
}