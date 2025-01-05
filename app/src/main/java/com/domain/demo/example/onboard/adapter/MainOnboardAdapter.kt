package com.domain.demo.example.onboard.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainOnboardAdapter(private val fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity)
{
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    
    fun addFragment(fragment: Fragment)
    {
        fragmentList.add(fragment)
    }
    
    override fun getItemCount(): Int = fragmentList.size
    
    override fun createFragment(position: Int): Fragment = fragmentList[position]
}