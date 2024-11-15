package com.example.final_tp.repository

import androidx.lifecycle.LiveData
import com.example.final_tp.data.MovieDb
import com.example.final_tp.data.UserDb
import com.example.final_tp.data.model.Movies
import com.example.final_tp.data.model.User

class MovieRepository {

  private val movieDao = MovieDb.getDatabase().movieDao()

  val readAllData: LiveData<List<Movies>> = movieDao.readAllData()

  //suspend fun insertUser(movie: Movies) {
    //movieDao.insert(movie = movie)
  //}

  //suspend fun updateUser(movie: Movies) {
    //movieDao.update(movie = movie)
  //}

  //suspend fun deleteUser(movie: Movies) {
    //movieDao.deleteUser(movie = movie)
  //}

  //suspend fun deleteAll() {
    //movieDao.deleteAll()
  //}

   fun inserMovie(movie: Movies) {
    movieDao.insert(movie = movie)
  }

  fun updateUser(movie: Movies) {
    movieDao.update(movie = movie)
  }
}