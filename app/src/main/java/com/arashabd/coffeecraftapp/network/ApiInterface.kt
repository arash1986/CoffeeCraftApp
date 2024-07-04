package com.arashabd.coffeecraftapp.network

import com.arashabd.coffeecraftapp.models.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {

    @GET("getEquipment.php")
    suspend fun getCoffeeItems(
        @Header("X-Requested-With") XMLHttpRequest: String?
    ): Response<List<Data?>?>?

}