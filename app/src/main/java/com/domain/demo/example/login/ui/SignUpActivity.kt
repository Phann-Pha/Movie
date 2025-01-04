package com.domain.demo.example.login.ui

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.domain.demo.example.R
import com.domain.demo.example.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var activity: Activity
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        activity = this
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_sign_up)
        
    }
}