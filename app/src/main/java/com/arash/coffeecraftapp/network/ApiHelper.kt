package com.arash.coffeecraftapp.network


class ApiHelper(private val apiService: ApiInterface) {

    suspend fun getCoffeeItems() = apiService.getCoffeeItems("XMLHttpRequest")

}
