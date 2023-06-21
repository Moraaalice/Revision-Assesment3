package com.example.revisingassesment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.revisingassesment.databinding.ActivityLogInBinding
import com.example.revisingassesment.databinding.ActivityMainBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btLogIn.setOnClickListener {
            val intent = Intent(this,ActivityMainBinding::class.java)
            startActivity(intent)
        }
        binding.btLogIn.setOnClickListener {
            validate()
        }
    }
        fun validate(){
            val user = binding.etUserName.text.toString()
            val pass = binding.etPassword.text.toString()
            var error = false

            if (user.isEmpty()){
                binding.tilUserName.error = "User name required"
                error = true
            }
            if (pass.isEmpty()){
                binding.tilPassWord.error = "Password required"
                error = true
            }
            if (!error){
                Toast.makeText(this,"$user $pass",Toast.LENGTH_LONG)
                    .show()
            }
        }
    }