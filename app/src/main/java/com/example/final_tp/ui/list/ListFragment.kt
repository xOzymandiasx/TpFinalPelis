package com.example.final_tp.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_tp.R
import com.example.final_tp.databinding.FragmentListBinding
import com.example.final_tp.ui.update.MovieViewModel

class ListFragment : Fragment() {

  private lateinit var binding: FragmentListBinding

  private val movieViewModel by viewModels<MovieViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val adapter = ListAdapter { movie ->
      val bundle = Bundle()
      bundle.putSerializable("movie", movie) //los datos que pasamos con la key
      //Aca le decimos a cada uno de los items, hacia el fragment hacia donde nos diriginos
      findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }

    val layout = LinearLayoutManager(requireContext())
    binding.listadoRecyclerView.layoutManager = layout
    binding.listadoRecyclerView.adapter = adapter

    //Linea divisoria
    val divisor = DividerItemDecoration(requireContext(), layout.orientation)
    binding.listadoRecyclerView.addItemDecoration(divisor)


    binding.btnAdd.setOnClickListener { //boton para navegar a la pantalla add
      findNavController().navigate(R.id.action_listFragment_to_addFragment)
    }

    movieViewModel.readAllData.observe(viewLifecycleOwner) { movieList ->
      adapter.setList(movieList = movieList)
    }

    binding.btnDelete.setOnClickListener {
      deleteMovie()
    }
  }

  private fun deleteMovie() {
    val dialog = AlertDialog.Builder(requireContext())

    dialog.setTitle("¿Desea eliminar todos los registros?")
    dialog.setMessage("¿Esta seguro que quiere eliminar todas las películas?")

    dialog.setNegativeButton("No") { _, _ ->
      return@setNegativeButton
    }

    dialog.setPositiveButton("Si") { _, _ ->
      movieViewModel.deleteAll()
    }

    dialog.create().show()
  }
}
