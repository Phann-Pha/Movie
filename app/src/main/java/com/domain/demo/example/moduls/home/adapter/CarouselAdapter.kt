package com.domain.demo.example.moduls.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.domain.demo.example.R
import com.domain.demo.example.databinding.ItemCarouselLayoutBinding
import com.domain.demo.example.moduls.home.domain.model.CarouselModel

class CarouselAdapter(private val list: ArrayList<CarouselModel>) : RecyclerView.Adapter<CarouselAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val binding: ItemCarouselLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_carousel_layout, parent, false)
        return ViewHolder(binding)
    }
    
    override fun getItemCount(): Int
    {
        return list.size
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val currentItem = list[position]
        holder.onBind(currentItem)
    }
    
    inner class ViewHolder(private val binding: ItemCarouselLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(item: CarouselModel)
        {
            binding.image.setImageResource(item.image)
            binding.title.text = item.title
            binding.date.text = item.date
        }
    }
}