package com.example.retrofitexample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FishFragment(), null)
            .commit()

    }
}