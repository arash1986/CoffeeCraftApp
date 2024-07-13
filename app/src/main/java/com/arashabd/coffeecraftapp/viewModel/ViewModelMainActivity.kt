package com.arashabd.coffeecraftapp.viewModel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arashabd.coffeecraftapp.R
import com.arashabd.coffeecraftapp.models.Data
import com.arashabd.coffeecraftapp.network.ApiHelper
import com.arashabd.coffeecraftapp.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
@SuppressLint("StaticFieldLeak")
class ViewModelMainActivity @Inject constructor (private val apiHelper: ApiHelper): ViewModel() {

    var jsonArray = MutableLiveData<List<Data?>>()

    suspend fun getItemsData() {
        val call = apiHelper
            .getCoffeeItems()

        if(call!!.isSuccessful) {
            withContext(Dispatchers.Main) {
                jsonArray.value = call.body()
            }
        }
    }
}