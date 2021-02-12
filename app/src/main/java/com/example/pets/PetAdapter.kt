package com.example.pets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pets.database.Pets

class PetAdapter( val data: ArrayList<Pets> = ArrayList<Pets>()): RecyclerView.Adapter<PetAdapter.PetHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetHolder {
        return PetHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        )
    }
    override fun onBindViewHolder(holder: PetHolder, position: Int) =holder.bind(data[position])
    override fun getItemCount(): Int = data.size
    inner class PetHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(pets: Pets)= with(itemView){
            findViewById<TextView>(R.id.Dognametv).text=pets.name
            findViewById<TextView>(R.id.Breednametv).text=pets.breed
            findViewById<TextView>(R.id.Agenametv).text= pets.age
            findViewById<TextView>(R.id.Gendernametv).text=pets.gender
        }
    }
}