package com.arash.coffeecraftapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arash.coffeecraftapp.utils.SessionManager

open class BaseActivity: AppCompatActivity() {

    lateinit var sessionManager : SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(this)
    }
}