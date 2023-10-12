package com.arash.coffeecraftapp.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.HttpException
import java.io.IOException
import java.util.Locale

class RetrofitErrorHandler : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val request = chain.request()
            val response = chain.proceed(request)

            if (!response.isSuccessful) {
                // Handle non-successful responses here
                val errorCode = response.code
                val errorMessage = response.message
                Log.d("errorRetrofit", String.format(Locale.ENGLISH, "$errorMessage ,${errorCode}"))
                // You can log or perform custom actions here
            }

            return response
        } catch (e: IOException) {
            Log.d("errorRetrofitIO", String.format(Locale.ENGLISH, e.toString()))

            // Handle network-related errors (e.g., no internet connection, timeout)
            throw e
        } catch (e: HttpException) {
            Log.d("errorRetrofitHttp", String.format(Locale.ENGLISH, e.response().toString()))

            // Handle Retrofit-specific HTTP errors (e.g., 401 Unauthorized, 404 Not Found)
            // You can access error response details like e.response()
            throw e
        } catch (e: Exception) {
            Log.d("errorRetrofitExc", String.format(Locale.ENGLISH, e.toString()))

            // Handle other unexpected errors
            throw e
        }
    }
}