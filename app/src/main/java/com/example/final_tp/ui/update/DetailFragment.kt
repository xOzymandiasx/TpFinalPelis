package com.example.final_tp.ui.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.final_tp.R
import com.example.final_tp.data.model.Movies
import com.example.final_tp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

  var movie: Movies? = null

  private lateinit var binding: FragmentDetailBinding
  private val movieViewModel by viewModels<MovieViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentDetailBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    movie = arguments?.getSerializable("movie") as Movies

    binding.etName.setText(movie!!.movie)
    binding.etLastName.setText(movie!!.genre)
    binding.etAge.setText(movie!!.duration.toString())

    binding.btnUpdateUser.setOnClickListener {
      val peli = binding.etName.text.toString()
      val genre = binding.etLastName.text.toString()
      val duration = binding.etAge.text.toString()

      if (peli.isNotBlank() && genre.isNotBlank() && duration.isNotBlank()) {
        val movieCopy = Movies(movie!!.id, peli, genre, duration.toInt())
        movieViewModel.UpdateMovie(movie = movieCopy)

        findNavController().navigate(R.id.action_detailFragment_to_listFragment)
      } else {
        Toast.makeText(requireContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show()
      }
    }
    binding.btnDeleteUser.setOnClickListener {
      deleteMovie()
    }

  }

  private fun deleteMovie() {
    val dialog = AlertDialog.Builder(requireContext())

    dialog.setTitle("Desea eliminar este registro")
    dialog.setMessage("Esta seguro que quiere eliminar ${movie!!.movie}")

    dialog.setNegativeButton("No") { _, _ ->
      return@setNegativeButton
    }

    dialog.setPositiveButton("Si") { _, _ ->
      movieViewModel.deleteMovie(movie = movie!!)
      findNavController().navigate(R.id.action_detailFragment_to_listFragment)
    }

    dialog.create().show()
  }

}