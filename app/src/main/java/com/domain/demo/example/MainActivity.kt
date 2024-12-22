package com.domain.demo.example

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.domain.demo.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/
        
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        
        
        // reference view by id
        val btnClick = findViewById<Button>(R.id.btnClick)
        btnClick.setOnClickListener {
        
        }
    }
}