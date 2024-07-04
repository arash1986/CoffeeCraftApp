package com.arashabd.coffeecraftapp.room.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.arashabd.coffeecraftapp.room.entity.Items


@Dao
interface DaoItems {
    @Insert
    suspend fun insert(coffeeItem: Items)

    @Query("SELECT * FROM Items")
    suspend fun getAllCoffeeItems(): List<Items>
}
