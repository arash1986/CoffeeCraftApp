package com.arash.coffeecraftapp.viewModel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arash.coffeecraftapp.R
import com.arash.coffeecraftapp.models.Data
import com.arash.coffeecraftapp.network.ApiClient
import com.arash.coffeecraftapp.utils.Constants
import com.arash.coffeecraftapp.utils.SessionManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.lang.reflect.Type
import java.util.Locale

class ViewModelMainActivity(private val context: Context): ViewModel() {

    fun ViewModelMainActivity(){}
    var jsonArray = MutableLiveData<List<Data>>()

    fun getItemsData() {
        val call = ApiClient.getClient(context, context.getString(R.string.loading_your_data)).getCoffeeItems(Constants.XMLHttpRequest)
        call!!.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                try {
                    if (response.isSuccessful) {
                        Log.d("asdadasdsas", response.body().toString())

                        val listType: Type = object : TypeToken<List<Data?>?>() {}.type
                        jsonArray.value = Gson().fromJson(response.body().toString(), listType)
                    }
                }catch (e: Exception) {
                    Log.d("asdadadas", e.toString())
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {

            }

        })
    }
}