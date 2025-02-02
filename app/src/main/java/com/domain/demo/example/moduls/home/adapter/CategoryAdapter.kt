package com.domain.demo.example.moduls.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.domain.demo.example.R
import com.domain.demo.example.databinding.ItemCategoryLayoutBinding

class CategoryAdapter(private val context: Context, private val list: ArrayList<String>, private val callback: () -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>()
{
    private var currentPosition = 0
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder
    {
        val binding: ItemCategoryLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_category_layout, parent, false)
        return CategoryViewHolder(binding)
    }
    
    override fun getItemCount(): Int
    {
        return list.size
    }
    
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int)
    {
        holder.onBind(list[position], position)
    }
    
    inner class CategoryViewHolder(private val binding: ItemCategoryLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    {
        @SuppressLint("NotifyDataSetChanged")
        fun onBind(item: String, position: Int)
        {
            binding.title.text = item
            binding.title.setOnClickListener {
                currentPosition = position
                callback.invoke()
                notifyDataSetChanged()
            }
            
            if (currentPosition == position)
            {
                binding.title.background = ContextCompat.getDrawable(context, R.drawable.bg_category)
                binding.title.setTextColor(ContextCompat.getColor(context, R.color.sky_color))
            } else
            {
                binding.title.background = null
                binding.title.setTextColor(ContextCompat.getColor(context, R.color.white))
            }
        }
    }
}