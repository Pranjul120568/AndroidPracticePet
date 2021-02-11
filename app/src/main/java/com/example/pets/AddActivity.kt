package com.example.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.get
import com.example.pets.database.PetsDB
import com.example.pets.database.PetsTable
import com.example.pets.databinding.ActivityAddBinding

 class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    val petsss=ArrayList<Pets>()
    private val genders = arrayListOf("Male", "Female", "Unknown")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val db= PetsDB(this).writableDatabase
        setUpSpinner()
        binding.SavePet.setOnClickListener {
            val newPet=Pets(
                    binding.InputNametv.text.toString(),
                    binding.InputBreedTv.text.toString(),
                    binding.SpinnerCataegory.selectedItem.toString(),
                    binding.InputAgeTv.toString()
                    )
            PetsTable.insertPet(db,newPet)
                    finish()
        }
    }
    private fun setUpSpinner() {
        val petadapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)
        genders.sort()
        binding.SpinnerCataegory.adapter = petadapter
    }
}