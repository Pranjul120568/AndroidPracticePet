package com.example.pets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pets.database.AppDatabse
import com.example.pets.database.Pets
import com.example.pets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var petlist = ArrayList<Pets>()
    var petadapter=PetAdapter(petlist)
    val db by lazy {
        AppDatabse.getDatabase(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.Recyclerpet.adapter=PetAdapter()

        binding.Recyclerpet.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter= this@MainActivity.petadapter
        }

        db.petsDao().getPets().observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                petlist.clear()
                petlist.addAll(it)
                petadapter.notifyDataSetChanged()
            } else {
                petlist.clear()
                petadapter.notifyDataSetChanged()
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return super.onCreateOptionsMenu(menu)
    }
    fun newpet(view: View) {
        val i = Intent(this, AddActivity::class.java)
        startActivity(i)
    }
}