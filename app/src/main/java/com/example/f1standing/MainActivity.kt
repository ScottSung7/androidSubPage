package com.example.f1standing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.f1standing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        standingListIntent()
    }
    private fun standingListIntent(){
        binding.standingListButton
            .setOnClickListener{
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent);
            }
    }
}