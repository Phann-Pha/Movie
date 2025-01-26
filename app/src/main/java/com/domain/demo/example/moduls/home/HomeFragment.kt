package com.domain.demo.example.moduls.home

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.domain.demo.example.R
import com.domain.demo.example.databinding.FragmentHomeBinding

class HomeFragment(private val activity: Activity) : Fragment(R.layout.fragment_home)
{
    private lateinit var binding: FragmentHomeBinding
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
    }
}