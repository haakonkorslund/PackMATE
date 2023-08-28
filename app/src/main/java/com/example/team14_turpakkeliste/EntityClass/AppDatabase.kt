package com.example.team14_turpakkeliste.EntityClass

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [WeatherInfo:: class], version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun UserDao(): UserDao

    companion object{

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if  (tempInstance != null){

                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase :: class.java,
                    "app_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return  instance
            }
        }
    }

}