package com.example.retrofitexample

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitexample.databinding.ItemBinding


class RecyclerAdapter(private val list: List<Model?>, private val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.FishViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater)
        return FishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FishViewHolder, position: Int) {
        holder.textView3.setText(
            Html.fromHtml(
                list.get(position)?.location ?: "",
                null,
                MyTagHandler()
            )
        )
        holder.textView4.setText(
            Html.fromHtml(
                list.get(position)?.habitat ?: "",
                null,
                MyTagHandler()
            )
        )
        holder.textView1.text = (list.get(position)?.speciesName)
        holder.textView2.text = (list.get(position)?.scientificName)
        holder.textViewTitle.text = (list.get(position)?.imageGallery?.title)
        Glide.with(context)
            .load(list.get(position)?.imageGallery?.src)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FishViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView1 = binding.textView
        val textView2 = binding.textView2
        val textView3 = binding.textView3
        val textView4 = binding.textView4
        val textViewTitle = binding.textViewTitle
        val imageView = binding.image
    }
}