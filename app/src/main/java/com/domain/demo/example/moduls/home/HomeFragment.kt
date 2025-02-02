package com.domain.demo.example.moduls.home

import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.core.view.marginStart
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.domain.demo.example.R
import com.domain.demo.example.databinding.FragmentHomeBinding
import com.domain.demo.example.moduls.home.adapter.CarouselAdapter
import com.domain.demo.example.moduls.home.adapter.CategoryAdapter
import com.domain.demo.example.moduls.home.model.CarouselModel
import kotlin.math.abs

class HomeFragment(private val activity: Activity) : Fragment(R.layout.fragment_home)
{
    private lateinit var binding: FragmentHomeBinding
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        
        binding.btnFavorite.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(0.8f, 1f)
            animator.apply {
                duration = 500
                interpolator = OvershootInterpolator()
                addUpdateListener {
                    binding.btnFavorite.scaleX = it.animatedValue as Float
                    binding.btnFavorite.scaleY = it.animatedValue as Float
                }
                start()
            }
        }
        
        onInitCarouselAdapter()
        onInitCategoryAdapter()
    }
    
    private fun onInitCarouselAdapter()
    {
        val list = arrayListOf(
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.carousel_1),
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.carousel_2),
            CarouselModel("Black Panther: Wakanda Forever", "On March 2, 2022", R.drawable.carousel_1),
        )
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