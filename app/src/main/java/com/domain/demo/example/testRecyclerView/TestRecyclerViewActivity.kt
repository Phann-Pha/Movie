package com.domain.demo.example.testRecyclerView

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.domain.demo.example.R
import com.domain.demo.example.databinding.ActivityTestRecyclerviewBinding
import com.domain.demo.example.testRecyclerView.adapter.TestRecyclerViewAdapter
import com.domain.demo.example.testRecyclerView.model.ProductionModel

class TestRecyclerViewActivity : AppCompatActivity()
{
    private lateinit var activity: Activity
    private lateinit var binding: ActivityTestRecyclerviewBinding
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activity = this@TestRecyclerViewActivity
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_test_recyclerview)
        
        onInitTestRecyclerViewAdapter()
    }
    
    private fun onBindProductionList(): List<ProductionModel>
    {
        return arrayListOf(
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00"),
            ProductionModel(image = R.drawable.orange, title = "Orange", description = "Orange description", price = "$ 2.00"),
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00"),
            ProductionModel(image = R.drawable.orange, title = "Orange", description = "Orange description", price = "$ 1.00"),
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00"),
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00"),
            ProductionModel(image = R.drawable.orange, title = "Orange", description = "Orange description", price = "$ 2.00"),
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00"),
            ProductionModel(image = R.drawable.orange, title = "Orange", description = "Orange description", price = "$ 1.00"),
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00"),
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00"),
            ProductionModel(image = R.drawable.orange, title = "Orange", description = "Orange description", price = "$ 2.00"),
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00"),
            ProductionModel(image = R.drawable.orange, title = "Orange", description = "Orange description", price = "$ 1.00"),
            ProductionModel(image = R.drawable.apple, title = "Apple", description = "Apple description", price = "$ 4.00")
        )
    }
    
    private fun onInitTestRecyclerViewAdapter()
    {
        val testRecyclerViewAdapter = TestRecyclerViewAdapter(onBindProductionList())
        // val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val layoutManger = object : LinearLayoutManager(activity)
        {
            override fun canScrollVertically(): Boolean
            {
                return true
            }
            
            override fun canScrollHorizontally(): Boolean
            {
                return false
            }
        }
        binding.recyclerView.layoutManager = layoutManger
        binding.recyclerView.adapter = testRecyclerViewAdapter
    }
}