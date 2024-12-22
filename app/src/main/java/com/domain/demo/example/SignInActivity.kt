package com.domain.demo.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.domain.demo.example.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySignInBinding
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@SignInActivity, R.layout.activity_sign_in)
        
        
    }
}