package com.example.final_tp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.final_tp.R
import com.example.final_tp.databinding.ItemRecyclerviewListBinding

//Creamos una clase, que no existe, del item a repetir, dentro de esta clase
class ListAdapter(private val list: List<String>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

  //Esta clase solo vive aca
  inner class ListViewHolder(private val binding: ItemRecyclerviewListBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(animal: String) {
      binding.tvAnimal.text = animal

      binding.root.setOnClickListener {
        val bundle = Bundle()
        bundle.putString("animal", animal) //los datos que pasamos con la key
        //Aca le decimos a cada uno de los items, hacia el fragment hacia donde nos diriginos
        itemView.findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ListViewHolder {
    val binding = ItemRecyclerviewListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ListViewHolder(binding = binding)
  }

  override fun onBindViewHolder(holder: ListAdapter.ListViewHolder, position: Int) {
    val animal = list.get(position) //Obtiene toda la posicion y la guarda en la variable
    holder.bind(animal = animal)
  }

  override fun getItemCount(): Int {
    return list.size
  }
}