package com.domain.demo.example.moduls.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.domain.demo.example.R
import com.domain.demo.example.databinding.MostItemMoviePopularLayoutBinding
import com.domain.demo.example.moduls.home.domain.model.MostItemPopularModel

class MostItemMoviePopularAdapter(private val list: ArrayList<MostItemPopularModel>) : RecyclerView.Adapter<MostItemMoviePopularAdapter.MostItemMoviePopularViewHolder>()
{
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostItemMoviePopularViewHolder
    {
        val binding: MostItemMoviePopularLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.most_item_movie_popular_layout, parent, false)
        return MostItemMoviePopularViewHolder(binding)
    }
    
    override fun getItemCount(): Int
    {
        return list.size
    }
    
    override fun onBindViewHolder(holder: MostItemMoviePopularViewHolder, position: Int)
    {
        val currentItem = list[position]
        holder.onBind(currentItem)
    }
    
    inner class MostItemMoviePopularViewHolder(binding: MostItemMoviePopularLayoutBinding) : RecyclerView.ViewHolder(binding.root)
    {
        private val _binding = binding
        
        fun onBind(item: MostItemPopularModel)
        {
            _binding.titleItem.text = item.title
            _binding.typeItem.text = item.type
            // _binding.imageItem.setImageResource()
            
            //Glide.with(_binding.root.context).load(item.image).into(_binding.imageItem)
            _binding.ratingValue.text = item.ratingValue.toString()
        }
    }
}