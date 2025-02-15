package com.domain.demo.example.moduls.home.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.domain.demo.example.R
import com.domain.demo.example.databinding.FragmentHomeBinding
import com.domain.demo.example.moduls.home.adapter.CarouselAdapter
import com.domain.demo.example.moduls.home.adapter.CategoryAdapter
import com.domain.demo.example.moduls.home.domain.model.CarouselModel
import com.domain.demo.example.moduls.home.viewmodel.HomeViewModel
import kotlin.math.abs

class HomeFragment(private val activity: Activity) : Fragment(R.layout.fragment_home)
{
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        
        onObserveViewModel()
        onInitCategoryAdapter()
    }
    
    private fun onObserveViewModel()
    {
        homeViewModel.onGetCarouselModel.observe(viewLifecycleOwner) { data ->
            onInitCarouselAdapter(data)
        }
    }
    
    private fun onInitCarouselAdapter(list: ArrayList<CarouselModel>)
    {
        val carouselAdapter = CarouselAdapter(list)
        binding.carousel.adapter = carouselAdapter
        
        binding.carousel.clipToPadding = false
        binding.carousel.clipChildren = false
        binding.carousel.offscreenPageLimit = 2
        binding.carousel.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        
        val compositePageTransform = CompositePageTransformer()
        compositePageTransform.addTransformer(MarginPageTransformer(40))
        compositePageTransform.addTransformer { page, position ->
            val ratio = 1 - abs(position)
            page.scaleY = 0.8f + ratio * 0.2f
        }
        binding.carousel.setPageTransformer(compositePageTransform)
        binding.indicator.attachTo(binding.carousel)
    }
    
    private fun onInitCategoryAdapter()
    {
        val list = arrayListOf(
            "All",
            "Comedy",
            "Animation",
            "Documentary"
        )
        val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val listener: () -> Unit = {
            // your code
        }
        val categoryAdapter = CategoryAdapter(activity, list, callback = listener)
        binding.recyclerviewCategories.layoutManager = layoutManager
        binding.recyclerviewCategories.adapter = categoryAdapter
    }
}