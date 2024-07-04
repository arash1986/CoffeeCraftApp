package com.arashabd.coffeecraftapp.models

import com.google.gson.annotations.SerializedName


data class ServingModel(

    @SerializedName("title") var title: String? = null,
    @SerializedName("Description") var Description: String? = null,
    @SerializedName("imageURL") var imageURL: String? = null

)
