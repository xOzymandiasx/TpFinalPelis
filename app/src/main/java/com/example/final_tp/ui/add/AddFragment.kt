package com.example.final_tp.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.final_tp.R
import com.example.final_tp.data.model.User
import com.example.final_tp.databinding.FragmentAddBinding
import com.example.final_tp.ui.UserViewModel

class AddFragment : Fragment() {

  private lateinit var binding: FragmentAddBinding
  private val userViewModel by viewModels<UserViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = FragmentAddBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.btnAddUser.setOnClickListener {
      val name = binding.etName.text.toString()
      val lastname = binding.etLastName.text.toString()
      val age = binding.etAge.text.toString()

      if (name.isNotBlank() && lastname.isNotBlank() && age.isNotBlank()) {
        val user = User(id = 0, name = name, lastName = lastname, age = age.toInt())
        userViewModel.insertUser(user = user)

        findNavController().navigate(R.id.action_addFragment_to_listFragment)
      } else {
        Toast.makeText(requireContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show()
      }
    }
  }

}