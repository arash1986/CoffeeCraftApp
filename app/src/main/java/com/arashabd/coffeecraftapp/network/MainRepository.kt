package com.arashabd.coffeecraftapp.network


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getCoffeeItems() = apiHelper.getCoffeeItems()


}
