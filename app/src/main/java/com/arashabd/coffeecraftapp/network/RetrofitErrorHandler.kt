package com.arashabd.coffeecraftapp.network

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.arashabd.coffeecraftapp.R
import com.arashabd.coffeecraftapp.utils.DialogBuilder
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.util.Locale


class RetrofitErrorHandler(var context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val request = chain.request()
            val response = chain.proceed(request)

            if (!response.isSuccessful) {
                // Handle non-successful responses here
                val errorCode = response.code
                val errorMessage = response.message
                Log.d("errorRetrofit", String.format(Locale.ENGLISH, "$errorMessage ,${errorCode}"))

            }
            Handler(Looper.getMainLooper()).post {
                DialogBuilder.hideProgressDialog()
            }



            return response
        } catch (e: IOException) {
            Log.d("errorRetrofitIO", String.format(Locale.ENGLISH, e.toString()))
            Handler(Looper.getMainLooper()).post {
                DialogBuilder.hideProgressDialog()
                Toast.makeText(
                    context,
                    context.getString(R.string.no_network_connection),
                    Toast.LENGTH_SHORT
                ).show()

            }

            // Handle network-related errors (e.g., no internet connection, timeout)
            return Response.Builder()
                .code(500) // Example error code
                .message("Network error")
                .body("Network error message".toResponseBody(null))
                .request(Request.Builder().url("https://example.com").build())
                .protocol(Protocol.HTTP_1_1)
                .build()

        } catch (e: HttpException) {
            Log.d("errorRetrofitHttp", String.format(Locale.ENGLISH, e.response().toString()))
            Handler(Looper.getMainLooper()).post {
                DialogBuilder.hideProgressDialog()
                Toast.makeText(
                    context,
                    e.toString(),
                    Toast.LENGTH_SHORT
                ).show()

            }

            return Response.Builder()
                .code(500) // Example error code
                .message("Network error")
                .body("Network error message".toResponseBody(null))
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .build()
        } catch (e: Exception) {
            Handler(Looper.getMainLooper()).post {
                DialogBuilder.hideProgressDialog()
                Toast.makeText(
                    context,
                    context.getString(R.string.no_network_connection),
                    Toast.LENGTH_SHORT
                ).show()

            }

            return Response.Builder()
                .code(500) // Example error code
                .message("Network error")
                .body("Network error message".toResponseBody(null))
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .build()

        }
    }
}