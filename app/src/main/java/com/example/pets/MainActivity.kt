package com.example.pets

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pets.database.PetsDB
import com.example.pets.database.PetsTable
import com.example.pets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var petlist = ArrayList<Pets>()
    val db = PetsDB(this).readableDatabase
    var petadapter=PetAdapter(petlist)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.Recyclerpet.adapter=PetAdapter()
        refreshTodoList()
    }
    fun newpet(view: View) {
        val i = Intent(this, AddActivity::class.java)
        startActivity(i)
    }
    fun refreshTodoList () {
        val petList = PetsTable.getAllPets(db)
        petlist.clear()
        petlist.addAll(petList)
        petadapter.notifyDataSetChanged()
        binding.Recyclerpet.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter= this@MainActivity.petadapter
        }
    }
}