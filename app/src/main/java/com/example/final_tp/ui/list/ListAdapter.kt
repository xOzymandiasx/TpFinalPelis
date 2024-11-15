package com.example.final_tp.ui.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.final_tp.R
import com.example.final_tp.data.model.Movies
import com.example.final_tp.databinding.ItemRecyclerviewListBinding

//Creamos una clase, que no existe, del item a repetir, dentro de esta clase
class ListAdapter(val onUserClick: (movie: Movies) -> Unit): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

  private var movieList = emptyList<Movies>()

  //Esta clase solo vive aca
  inner class ListViewHolder(private val binding: ItemRecyclerviewListBinding): RecyclerView.ViewHolder(binding.root){
    //Esta seccion lo pinta en pantalla
    fun bind(movie: Movies) {
      with(binding) {
        tvName.text = movie.movie
        tvLastName.text = movie.genre
        tvAge.text = movie.duration.toString()
        tvId.text = movie.id.toString()
      }

      binding.root.setOnClickListener {
        onUserClick(movie)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
    val binding = ItemRecyclerviewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ListViewHolder(binding = binding)
  }

  override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
    val movie = movieList.get(position) //Obtiene toda la posicion y la guarda en la variable
    holder.bind(movie = movie)
  }

  override fun getItemCount(): Int {
    return movieList.size
  }

  @SuppressLint("NotifyDataSetChanged")
  fun setList(movieList: List<Movies>) {
    //Usamos this para utilizar la variable de este entorno y no la que recibe la funcion como parametro
    this.movieList = movieList
    notifyDataSetChanged()
  }
}