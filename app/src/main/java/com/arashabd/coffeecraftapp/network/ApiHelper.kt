package com.arashabd.coffeecraftapp.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHelper @Inject constructor(private val apiService: ApiInterface) {

    suspend fun getCoffeeItems() = apiService.getCoffeeItems("XMLHttpRequest")

}
