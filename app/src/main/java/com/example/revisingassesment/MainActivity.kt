package com.example.revisingassesment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.revisingassesment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.etLogIn.setOnClickListener {
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
        binding.btSignUp.setOnClickListener {
            validation()
        }
    }
    fun validation(){
        val user = binding.etUserName.text.toString()
        val email = binding.etEmail.text.toString()
        val phone = binding.etPhoneNumber.text.toString()
        val password = binding.etPassword.text.toString()
        var error = false

        if (user.isEmpty()){
            binding.tilUserName.error = "User name required"
            error = true
        }
        if (email.isEmpty()){
            binding.tilEmail.error = "Email required"
            error = true
        }
        if (phone.isEmpty()){
            binding.tilPhoneNumber.error = "Phone Number required"
            error = true
        }
        if (password.isEmpty()){
            binding.tilPhoneNumber.error = "Password required"
            error = true
        }
        if (!error){
            Toast.makeText(this,"$user $email $phone $password",Toast.LENGTH_LONG)
                .show()
        }
    }
}