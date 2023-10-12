package com.arash.coffeecraftapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.arash.coffeecraftapp.network.ApiHelper
import com.arash.coffeecraftapp.network.MainRepository
import com.arash.coffeecraftapp.utils.SessionManager


class ViewModelFactory(private val sessionManager: SessionManager) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return when {
            modelClass.isAssignableFrom(ViewModelMainActivity::class.java) -> {
                ViewModelMainActivity(sessionManager) as T
            }

            else -> throw IllegalArgumentException("Unknown class name")
        }
    }
}
