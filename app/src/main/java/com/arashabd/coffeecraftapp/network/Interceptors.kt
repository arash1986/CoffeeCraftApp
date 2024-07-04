package com.arashabd.coffeecraftapp.network

import android.content.Context
import com.arashabd.coffeecraftapp.utils.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(
    context: Context,
) : Interceptor {
    var sessionManager: SessionManager = SessionManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url

        val newUrlBuilder = url.newBuilder()
        val newRequestBuilder = request.newBuilder()
        newRequestBuilder.url(newUrlBuilder.build()).addHeader("Authorization", sessionManager.tokenType + sessionManager.token)
        return chain.proceed(newRequestBuilder.build())

    }
}
class VersionInterceptor(
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url

        val newUrlBuilder = url.newBuilder()
        val newRequestBuilder = request.newBuilder()
        newRequestBuilder.url(newUrlBuilder.build()).addHeader(
            "Version",
            "222")
        return chain.proceed(newRequestBuilder.build())

    }
}