package com.arashabd.coffeecraftapp.di.module

import android.app.Application
import android.app.Dialog
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.arashabd.coffeecraftapp.R
import com.arashabd.coffeecraftapp.network.ApiInterface
import com.arashabd.coffeecraftapp.network.RetrofitErrorHandler
import com.arashabd.coffeecraftapp.network.TokenInterceptor
import com.arashabd.coffeecraftapp.network.VersionInterceptor
import com.arashabd.coffeecraftapp.utils.Constants
import com.arashabd.coffeecraftapp.utils.DialogBuilder
import com.arashabd.coffeecraftapp.utils.SessionManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSessionManager(app: Application): SessionManager {
        return SessionManager(app)
    }
    @Provides
    @Singleton
    fun provideLoadingDialog(app: Application): Dialog {
        val pDialog: Dialog?
        pDialog = Dialog(app, R.style.AnimatedDialog)
        pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        pDialog.setContentView(R.layout.dialog_view_loading_new)
        val mainTitleTextView: TextView = pDialog.findViewById(R.id.mainTitle)
      //  mainTitleTextView.text = content
        val width = (app.resources.displayMetrics.widthPixels * 0.90).toInt()
        pDialog.window!!.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        pDialog.setCancelable(false)
        return pDialog
    }

    @Provides
    @Singleton
    fun provideMyApi(app: Application): ApiInterface {
        return  retrofit2.Retrofit.Builder()
            .baseUrl(Constants.BASEURL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient().newBuilder()
                .readTimeout(15, TimeUnit.SECONDS)
                .callTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(VersionInterceptor())
                .addInterceptor(TokenInterceptor(app))
                .addInterceptor(RetrofitErrorHandler(app))
                .build()).build().create(ApiInterface::class.java)
    }
}