package com.arashabd.coffeecraftapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arashabd.coffeecraftapp.utils.SessionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
open class BaseActivity: AppCompatActivity() {

    @Inject
    lateinit var sessionManager : SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}