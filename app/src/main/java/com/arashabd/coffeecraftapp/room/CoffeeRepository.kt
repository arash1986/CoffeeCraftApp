package com.arashabd.coffeecraftapp.room

import android.content.Context
import androidx.room.Room
import com.arashabd.coffeecraftapp.room.dao.DaoItems
import com.arashabd.coffeecraftapp.room.dataBase.DataBase
import com.arashabd.coffeecraftapp.room.entity.Items

class CoffeeRepository(context: Context) {
    var coffeeDatabase: DataBase
    private val coffeeItemDao: DaoItems
    init {

        coffeeDatabase = Room.databaseBuilder(
            context,
            DataBase::class.java,
            "coffee_database"
        ).build()

        coffeeItemDao = coffeeDatabase.coffeeItemDao()
    }

    suspend fun insertCoffeeItem(coffeeItem: Items) {
        coffeeItemDao.insert(coffeeItem)
    }

    suspend fun getAllCoffeeItems(): List<Items> {
        return coffeeItemDao.getAllCoffeeItems()
    }
}