package com.arash.coffeecraftapp.viewModel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arash.coffeecraftapp.R
import com.arash.coffeecraftapp.models.Data
import com.arash.coffeecraftapp.network.ApiClient
import com.arash.coffeecraftapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
@SuppressLint("StaticFieldLeak")
class ViewModelMainActivity(private val context: Context): ViewModel() {

    var jsonArray = MutableLiveData<List<Data?>>()

    suspend fun getItemsData() {

        val call = ApiClient.getClient(context, context.getString(R.string.loading_your_data))
            .getCoffeeItems(Constants.XMLHttpRequest)

        if(call!!.isSuccessful) {
            withContext(Dispatchers.Main) {
                jsonArray.value = call.body()
            }
        }
    }
}