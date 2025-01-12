package com.domain.demo.example.onboard.ui

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.domain.demo.example.MainActivity
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
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this@MainOnboardActivity, R.layout.activity_main_onboard)
        
        onChangeIconStatusBarColor()
        onInitMainOnboardAdapter()
    }
    
    private fun onChangeIconStatusBarColor()
    {
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
        }
    }
    
    private fun onInitMainOnboardAdapter()
    {
        onboardAdapter = MainOnboardAdapter(fragmentActivity = this@MainOnboardActivity)
        onboardAdapter.addFragment(
            fragment = OnboardV1Fragment(),
            title = resources.getString(R.string.TitleOnboardV1),
            description = resources.getString(R.string.DescriptionOnboardV1)
        )
        onboardAdapter.addFragment(
            fragment = OnboardV2Fragment(),
            title = resources.getString(R.string.TitleOnboardV2),
            description = resources.getString(R.string.DescriptionOnboardV2)
        )
        onboardAdapter.addFragment(
            fragment = OnboardV3Fragment(),
            title = resources.getString(R.string.TitleOnboardV3),
            description = resources.getString(R.string.DescriptionOnboardV3)
        )
        
        binding.viewpagerOnboard.adapter = onboardAdapter
        binding.indicator.attachTo(binding.viewpagerOnboard)
        
        binding.viewpagerOnboard.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback()
        {
            override fun onPageSelected(position: Int)
            {
                super.onPageSelected(position)
                val title = onboardAdapter.getTitleOnboard(position = position)
                val description = onboardAdapter.getDescriptionOnboard(position = position)
                
                binding.txtTitleOnboard.text = title
                binding.txtDescriptionOnboard.text = description
            }
        })
        
        binding.btnNextOnboard.setOnClickListener {
            val currentOnboardPosition = binding.viewpagerOnboard.currentItem
            
            if (currentOnboardPosition == 2)
            {
                val intent = Intent(this@MainOnboardActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else
            {
                binding.viewpagerOnboard.currentItem = (currentOnboardPosition + 1)
            }
        }
    }
}