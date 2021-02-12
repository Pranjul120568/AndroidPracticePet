package com.example.pets

import android.icu.text.LocaleDisplayNames
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.pets.database.AppDatabse
import com.example.pets.database.Pets
import com.example.pets.databinding.ActivityAddBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val DB_NAME="todo.db"
 class AddActivity : AppCompatActivity() {
     lateinit var binding: ActivityAddBinding
     val petsss = ArrayList<Pets>()
     private val genders = arrayListOf("Male", "Female", "Unknown")
     val db by lazy {
         AppDatabse.getDatabase(this)
     }
     override fun onCreate(savedInstanceState: Bundle?) {
         binding = ActivityAddBinding.inflate(layoutInflater)
         super.onCreate(savedInstanceState)
         setContentView(binding.root)
         setUpSpinner()
         binding.SavePet.setOnClickListener {
             savepet()
         }
     }

     private fun setUpSpinner() {
         val petadapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)
         genders.sort()
         binding.SpinnerCataegory.adapter = petadapter
     }

     private fun savepet() {
         val name = binding.InputNametv.text.toString()
         val breed = binding.InputBreedTv.text.toString()
         val gender = binding.SpinnerCataegory.selectedItem.toString()
         val age = binding.InputAgeTv.text.toString()

         GlobalScope.launch (Dispatchers.Main){
            val id= withContext(Dispatchers.IO){
                return@withContext db.petsDao().insertPet(
                    Pets(
                        name, breed, gender, age
                    )
                )
            }
             finish()
             }
         }
     }