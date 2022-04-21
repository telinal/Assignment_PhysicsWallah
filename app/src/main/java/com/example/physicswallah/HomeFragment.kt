package com.example.physicswallah

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.physicswallah.api.ListApi
import com.example.physicswallah.api.Retrofithelper
import com.example.physicswallah.databinding.FragmentHomeBinding
import com.example.physicswallah.model.Users
import com.example.physicswallah.repository.MainRepository
import com.example.physicswallah.viewmodel.MainViewModel
import com.example.physicswallah.viewmodel.MainViewModelFactory


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: MainViewModel
    lateinit var list: List<Users>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.progressBar.visibility = View.VISIBLE
        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(Retrofithelper.getListApi()))).get(MainViewModel::class.java)
        viewModel.userList.observe(viewLifecycleOwner, Observer {
            Log.d("telina", "onViewCreated: $it")
            binding.listshow.adapter = MyAdapter(it)
            binding.progressBar.visibility = View.GONE
        })

        viewModel.errorMessage.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.GONE
        }
    }


}