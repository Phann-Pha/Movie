package com.domain.demo.example.moduls.onboard.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainOnboardAdapter(private val fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity)
{
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    private val titleOnboardList: ArrayList<String> = ArrayList()
    private val descriptionOnboardList: ArrayList<String> = ArrayList()
    
    fun addFragment(fragment: Fragment, title: String, description: String)
    {
        fragmentList.add(fragment)
        titleOnboardList.add(title)
        descriptionOnboardList.add(description)
    }
    
    fun getTitleOnboard(position: Int): String = titleOnboardList[position]
    
    fun getDescriptionOnboard(position: Int): String = descriptionOnboardList[position]
    
    override fun getItemCount(): Int = fragmentList.size
    
    override fun createFragment(position: Int): Fragment = fragmentList[position]
}