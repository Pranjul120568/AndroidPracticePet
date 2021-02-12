package com.example.pets.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pets (var name:String,
                 var breed:String,
                 var gender:String ,
                 var age:String,
                 @PrimaryKey(autoGenerate = true)
                 val id:Long=0L
)