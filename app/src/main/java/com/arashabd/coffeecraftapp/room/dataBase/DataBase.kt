package com.arashabd.coffeecraftapp.room.dataBase;

import androidx.room.Database
import androidx.room.RoomDatabase

import com.arashabd.coffeecraftapp.room.dao.DaoItems
import com.arashabd.coffeecraftapp.room.entity.Items


    @Database(entities = [Items::class], version = 1)
    abstract class DataBase : RoomDatabase() {

        abstract fun coffeeItemDao(): DaoItems
   }
