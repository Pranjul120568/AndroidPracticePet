package com.example.pets.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.pets.Pets

object PetsTable {
    val TABLE_NAME="pets"
    object Columns{
        val ID="id"
        val NAME="name"
        val BREED="breed"
        val GENDER="gender"
        val AGE="age"
    }
    //The usage of three quotes is we can add multiple lines in between them
    val CMD_CREATE="""CREATE TABLE IF NOT EXISTS $TABLE_NAME
        (
        ${Columns.ID} INTEGER PRIMARY KEY AUTO INCREMENT,
        ${Columns.NAME} TEXT,
         ${Columns.BREED} TEXT,
          ${Columns.GENDER} TEXT,
           ${Columns.AGE} INTEGER,
        
    """.trimMargin()
    //To make the table jump to petsdb and then under onCreate
// u need to put siome command in order to create the table


    //And then we implement two functions one of them is to create a pet inside and one of them is to getallthe pets
    fun insertPet(db: SQLiteDatabase,pets: Pets){
     val row=ContentValues()
        row.put(Columns.NAME,pets.name)
        row.put(Columns.GENDER,pets.gender)
        row.put(Columns.BREED,pets.breed)
        row.put(Columns.AGE,pets.age)

        db.insert(TABLE_NAME,null,row)
    }
    fun getAllPets(db:SQLiteDatabase):ArrayList<Pets>{
        //db.query is a cursor
db.query(TABLE_NAME,
        arrayOf(Columns.NAME,Columns.BREED,Columns.AGE,Columns.GENDER),null,null,null,null,null
        )
    }
}