package com.example.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.pets.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddBinding
    private val genders= arrayListOf("Male","Female","Unknown")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
         fun setUpSpinner() {
            val adapter=
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,genders)
            genders.sort()
            binding.spinnergender.adapter=adapter
        }
    }
}