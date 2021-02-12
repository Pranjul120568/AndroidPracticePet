package com.example.pets.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PetsDao {
    @Insert
suspend fun insertPet(pets: Pets):Long
    @Query("SELECT * FROM Pets")
fun getPets():LiveData<List<Pets>>
}