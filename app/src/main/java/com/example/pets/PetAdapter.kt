package com.example.pets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(private val data: ArrayList<Pets> = ArrayList<Pets>()): RecyclerView.Adapter<PetAdapter.PetHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetHolder {
        return PetHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent,false)
        )
    }
    override fun onBindViewHolder(holder: PetHolder, position: Int) =holder.bind(data[position])
    override fun getItemCount(): Int = data.size
    inner class PetHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(item:Pets)= with(itemView){
            findViewById<TextView>(R.id.Dognametv).text=item.name
            findViewById<TextView>(R.id.Breednametv).text=item.breed
            findViewById<TextView>(R.id.Agenametv).text= item.age
            findViewById<TextView>(R.id.Gendernametv).text=item.gender
        }
    }
}