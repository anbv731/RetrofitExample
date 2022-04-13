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

import com.example.retrofitexample.network.Controller
import com.example.retrofitexample.domain.MainRepository

class FishFragment : Fragment() {
    lateinit var binding: FragmentBinding
    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MainViewModel
    private val retrofitService = Controller()
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
        adapter= RecyclerAdapter(requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java)
        viewModel.fishList.observe(viewLifecycleOwner,Observer{adapter.setFishList(it)})


        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {

        })
        viewModel.getAllFish()
//        val retroApi = Controller().getApi()
//        retroApi.getData().enqueue(object : Callback<List<FishModel?>> {
//
//            override fun onResponse(call: Call<List<FishModel?>>, response: Response<List<FishModel?>>) {
//                val body = response.body()
//                if (body != null) {
//                    val listFishModel: List<FishModel?> = body
//                    setList(listFishModel)
//                }
//            }
//
//            override fun onFailure(call: Call<List<FishModel?>>, t: Throwable) {
//                println("FAIL " + t.toString())
//            }
//        })
    }

//    private fun setList(list: List<FishModel?>) {
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = RecyclerAdapter( requireContext())
//    }
}