package com.example.pets.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pets.DB_NAME

@Database(entities = [Pets::class],version = 1)
abstract class AppDatabse: RoomDatabase() {
    abstract fun petsDao(): PetsDao

    companion object {
        //This companion object helps us to resolve the error as the room database
        // has a bug that it does'nt onstantaneously shos the data changed inside the app and
        @Volatile
        /*
        Volatile keyword is used to modify the value of a variable by different threads.
        It is also used to make classes thread safe.
        It means that multiple threads can use a method and instance of the classes at the same time without any problem.
        The volatile keyword can be used either with primitive type or objects.
         */
        private var INSTANCE: AppDatabse? = null

        fun getDatabase(context: Context): AppDatabse {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabse::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}