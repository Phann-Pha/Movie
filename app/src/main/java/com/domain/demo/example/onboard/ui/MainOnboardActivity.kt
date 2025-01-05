package com.domain.demo.example.onboard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.domain.demo.example.R
import com.domain.demo.example.databinding.ActivityMainOnboardBinding
import com.domain.demo.example.onboard.adapter.MainOnboardAdapter
import com.domain.demo.example.onboard.ui.fragments.OnboardV1Fragment
import com.domain.demo.example.onboard.ui.fragments.OnboardV2Fragment
import com.domain.demo.example.onboard.ui.fragments.OnboardV3Fragment

class MainOnboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainOnboardBinding
    private lateinit var onboardAdapter: MainOnboardAdapter
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainOnboardActivity, R.layout.activity_main_onboard)
        
        onInitMainOnboardAdapter()
    }
    
    private fun onInitMainOnboardAdapter()
    {
        onboardAdapter = MainOnboardAdapter(fragmentActivity = this@MainOnboardActivity)
        onboardAdapter.addFragment(OnboardV1Fragment())
        onboardAdapter.addFragment(OnboardV2Fragment())
        onboardAdapter.addFragment(OnboardV3Fragment())
        
        binding.viewpagerOnboard.adapter = onboardAdapter
    }
}