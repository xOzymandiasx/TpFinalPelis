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
import com.example.final_tp.data.model.User
import com.example.final_tp.databinding.FragmentDetailBinding
import com.example.final_tp.ui.UserViewModel

class DetailFragment : Fragment(), MenuProvider {

  var user: User? = null

  private lateinit var binding: FragmentDetailBinding
  private val userViewModel by viewModels<UserViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentDetailBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    user = arguments?.getSerializable("user") as User

    binding.etName.setText(user!!.name)
    binding.etLastName.setText(user!!.lastName)
    binding.etAge.setText(user!!.age.toString())

    binding.btnUpdateUser.setOnClickListener {
      val name = binding.etName.text.toString()
      val lastName = binding.etLastName.text.toString()
      val age = binding.etAge.text.toString()

      if (name.isNotBlank() && lastName.isNotBlank() && age.isNotBlank()) {
        val userCopy = User(user!!.id, name, lastName, age.toInt())
        userViewModel.UpdateUser(user = userCopy)

        findNavController().navigate(R.id.action_detailFragment_to_listFragment)
      } else {
        Toast.makeText(requireContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show()
      }
    }
    binding.btnDeleteUser.setOnClickListener {
      deleteUser()
    }

  }

  override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
    menuInflater.inflate(R.menu.delete_menu, menu)
  }

  override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
    return when(menuItem.itemId) {
      R.id.menu_delete -> {
        deleteUser()
        true
      }
      else -> {
        false
      }
    }
  }

  private fun deleteUser() {
    val dialog = AlertDialog.Builder(requireContext())
    dialog.setTitle("¿Desea borrar el siguiente registro?")
    dialog.setMessage("¿Seguro quiere borrar a ${user!!.name}?")
    dialog.setNegativeButton("No") { _, _ ->
      return@setNegativeButton
    }

    dialog.setPositiveButton("Si") { _, _ ->
      userViewModel.deleteUser(user = user!!)
      findNavController().navigate(R.id.action_detailFragment_to_listFragment)
    }

    dialog.create().show()
  }

}