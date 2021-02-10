package com.example.pets.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


//Here we take help of sqliteopenhelper it makes easy to read write delete update
// tasks as it has many inbuilt functionalities of sqlite databse
class PetsDB(context:Context):SQLiteOpenHelper(context,"pets.db",null,1) {
    //This  is called when the app is installed.
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(PetsTable.CMD_CREATE)
    }
//This is called when the version of the database is changed
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}