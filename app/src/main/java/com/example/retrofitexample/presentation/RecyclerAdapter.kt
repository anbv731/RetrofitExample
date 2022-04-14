package com.example.retrofitexample.presentation

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitexample.databinding.ItemBinding
import com.example.retrofitexample.model.FishModel

class RecyclerAdapter(private val context: Context, private val viewModel: FishViewModel) :
    RecyclerView.Adapter<RecyclerAdapter.FishViewHolder>() {
    var fish = mutableListOf<FishModel?>()
    fun setFishList(fish: List<FishModel?>) {
        this.fish = fish.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater)
        return FishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FishViewHolder, position: Int) {
        val fish = fish[position]
        holder.textView3.setText(

            Html.fromHtml(
                fish?.location ?: "",
                null,
                MyTagHandler()
            )
        )
        holder.textView4.setText(
            Html.fromHtml(
                fish?.habitat ?: "",
                null,
                MyTagHandler()
            )
        )
        holder.textView1.text = (fish?.speciesName)
        holder.textView2.text = (fish?.scientificName)
        holder.textViewTitle.text = (fish?.imageGallery?.title)
        Glide.with(context)
            .load(fish?.imageGallery?.src)
            .into(holder.imageView)
        if (viewModel.isSavedInFavourite(fish!!)) {
            holder.addButton.text = "Удалить из избранного"
        } else {
            holder.addButton.text = "Добавить в избранное"
        }
        holder.addButton.setOnClickListener {
            viewModel.saveToFavourite(fish)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return fish.size
    }

    class FishViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView1 = binding.textView
        val textView2 = binding.textView2
        val textView3 = binding.textView3
        val textView4 = binding.textView4
        val textViewTitle = binding.textViewTitle
        val imageView = binding.image
        val addButton = binding.addButton
    }
}