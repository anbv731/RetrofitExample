package com.example.retrofitexample.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample.databinding.FragmentBinding

class FishFragment : Fragment() {
    lateinit var binding: FragmentBinding
    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: FishViewModel
    lateinit var adapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        recyclerView = binding.recyclerView
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            FishViewModelFactory(requireContext())
        ).get(FishViewModel::class.java)
        adapter = RecyclerAdapter(requireContext(), viewModel)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.fishList.observe(viewLifecycleOwner, Observer {
            adapter.setFishList(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            println("Error " + it.toString())

        })
        viewModel.getAllFish()
    }
}