package com.example.final_tp.ui.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.final_tp.R
import com.example.final_tp.data.model.User
import com.example.final_tp.databinding.ItemRecyclerviewListBinding

//Creamos una clase, que no existe, del item a repetir, dentro de esta clase
class ListAdapter(val onUserClick: (user: User) -> Unit): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

  private var userList = emptyList<User>()

  //Esta clase solo vive aca
  inner class ListViewHolder(private val binding: ItemRecyclerviewListBinding): RecyclerView.ViewHolder(binding.root){
    //Esta seccion lo pinta en pantalla
    fun bind(user: User) {
      with(binding) {
        tvName.text = user.name
        tvLastName.text = user.lastName
        tvAge.text = user.age.toString()
        tvId.text = user.id.toString()
      }

      binding.root.setOnClickListener {
        onUserClick(user)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
    val binding = ItemRecyclerviewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ListViewHolder(binding = binding)
  }

  override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
    val user = userList.get(position) //Obtiene toda la posicion y la guarda en la variable
    holder.bind(user = user)
  }

  override fun getItemCount(): Int {
    return userList.size
  }

  @SuppressLint("NotifyDataSetChanged")
  fun setList(userList: List<User>) {
    //Usamos this para utilizar la variable de este entorno y no la que recibe la funcion como parametro
    this.userList = userList
    notifyDataSetChanged()
  }
}