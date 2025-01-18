package com.domain.demo.example.testRecyclerView.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.domain.demo.example.R
import com.domain.demo.example.databinding.ItemTestRecyclerviewBinding
import com.domain.demo.example.testRecyclerView.model.ProductionModel

class TestRecyclerViewAdapter(private val list: List<ProductionModel>): RecyclerView.Adapter<TestRecyclerViewAdapter.TestViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder
    {
        /*val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_test_recyclerview, parent, false)
        
        return TestViewHolder(view)*/
        
        val binding: ItemTestRecyclerviewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_test_recyclerview, parent, false )
        return TestViewHolder(binding)
    }
    
    override fun getItemCount(): Int
    {
        return list.size
    }
    
    override fun onBindViewHolder(holder: TestViewHolder, position: Int)
    {
        val currentItem = list[position]
        holder.onBind(currentItem)
    }
    
    inner class TestViewHolder(private val binding: ItemTestRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun onBind(item: ProductionModel)
        {
            binding.imageView.setImageResource(item.image)
            binding.title.text = item.title
            binding.description.text = item.description
            binding.price.text = item.price
        }
    }
}