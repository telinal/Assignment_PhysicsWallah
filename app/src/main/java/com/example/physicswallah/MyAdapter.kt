package com.example.physicswallah

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.physicswallah.databinding.ItemViewBinding
import com.example.physicswallah.model.Users
import java.util.zip.Inflater

class MyAdapter(val listofName: List<Users>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    lateinit var binding: ItemViewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         val data = listofName[position]
        holder.setData(data)

    }

    override fun getItemCount(): Int {
        return listofName.size
    }

    class MyViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(user: Users){
            binding.user = user
        }
    }
}