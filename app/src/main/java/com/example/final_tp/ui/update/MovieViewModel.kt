package com.example.final_tp.ui.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.final_tp.data.model.Movies
import com.example.final_tp.repository.MovieRepository

class MovieViewModel: ViewModel() {

  private val repository = MovieRepository()
  val readAllData: LiveData<List<Movies>> = repository.readAllData


  fun insertUser(movie: Movies) {
    repository.inserMovie(movie = movie)
  }





}