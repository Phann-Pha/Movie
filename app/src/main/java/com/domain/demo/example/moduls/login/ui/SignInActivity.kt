package com.domain.demo.example.moduls.login.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.domain.demo.example.R
import com.domain.demo.example.common.hideSoftKeyboard
import com.domain.demo.example.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySignInBinding
    private lateinit var activity: Activity
    
    private var isPasswordVisible = false
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        activity = this
        binding = DataBindingUtil.setContentView(activity, R.layout.activity_sign_in)
        
        val btnLogin = binding.btnLogin
        btnLogin.setOnClickListener {
            onValidateField()
        }
        
        onVisibilityPassword()
        
        binding.mainLayout.setOnClickListener {
            hideSoftKeyboard()
        }
        
        onNavToSignUpScreen()
    }
    
    private fun onValidateField()
    {
        val email = binding.edEmail.text.trim().toString()
        val password = binding.edPassword.text.toString()
        
        if (email.isEmpty())
        {
            Toast.makeText(activity, "Please Enter Email!", Toast.LENGTH_SHORT).show()
        } else
        {
            if (password.isEmpty())
            {
                Toast.makeText(activity, "Please Enter Your Password!", Toast.LENGTH_SHORT).show()
            } else
            {
                // your code here
                Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun onVisibilityPassword()
    {
        val iconVisibility = binding.eyesVisibility
        iconVisibility.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            
            if (isPasswordVisible)
            {
                binding.edPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.eyesVisibility.setImageResource(R.drawable.ic_visibility_off)
            } else
            {
                binding.edPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.eyesVisibility.setImageResource(R.drawable.ic_eyes_visibility)
            }
        }
    }
    
    private fun onNavToSignUpScreen()
    {
        binding.txtSignUp.setOnClickListener {
            val intent = Intent(activity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}