package com.example.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.pets.databinding.ActivityAddBinding

 class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    private val genders = arrayListOf("Male", "Female", "Unknown")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpSpinner()
    }
    private fun setUpSpinner() {
        val petadapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)
        genders.sort()
        binding.SpinnerCataegory.adapter = petadapter
    }
}