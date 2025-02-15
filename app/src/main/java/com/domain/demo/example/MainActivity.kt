package com.domain.demo.example

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.domain.demo.example.databinding.ActivityMainBinding
import com.domain.demo.example.moduls.download.DownloadFragment
import com.domain.demo.example.moduls.home.ui.HomeFragment
import com.domain.demo.example.moduls.profile.ProfileFragment
import com.domain.demo.example.moduls.search.SearchFragment

class MainActivity : AppCompatActivity()
{
    private lateinit var activity: Activity
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        activity = this
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_main)
        
        onInitBottomNavigationBar()
    }
    
    private fun onInitBottomNavigationBar()
    {
        onSetFragment(HomeFragment(activity))
        binding.bottomNavigationBar.onItemSelected = { id ->
            when (id)
            {
                0 ->
                {
                    onSetFragment(HomeFragment(activity))
                }
                
                1 ->
                {
                    onSetFragment(SearchFragment())
                }
                
                2 ->
                {
                    onSetFragment(DownloadFragment())
                }
                
                3 ->
                {
                    onSetFragment(ProfileFragment())
                }
            }
        }
    }
    
    private fun onSetFragment(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, fragment)
            commitNow()
        }
    }
}