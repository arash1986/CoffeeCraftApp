package com.arash.coffeecraftapp.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {

    @GET("getEquipment.php")
    fun getCoffeeItems(
        @Header("X-Requested-With") XMLHttpRequest: String?
    ): Call<String?>?

}