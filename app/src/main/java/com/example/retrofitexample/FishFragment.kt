package com.example.retrofitexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample.databinding.FragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FishFragment : Fragment() {
    lateinit var binding: FragmentBinding
    lateinit var recyclerView: RecyclerView
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

        val retroApi = Controller().getApi()
        retroApi.getData().enqueue(object : Callback<List<Model?>> {

            override fun onResponse(call: Call<List<Model?>>, response: Response<List<Model?>>) {
                val body = response.body()
                if (body != null) {
                    val listModel: List<Model?> = body
                    setList(listModel)
                }
            }

            override fun onFailure(call: Call<List<Model?>>, t: Throwable) {
                println("FAIL " + t.toString())
            }
        })
    }

    private fun setList(list: List<Model?>) {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecyclerAdapter(list, requireContext())
    }
}